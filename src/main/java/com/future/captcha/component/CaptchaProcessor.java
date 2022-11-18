package com.future.captcha.component;

import com.future.base.model.exps.ProException;
import com.future.base.util.base.CookieUtil;
import com.future.base.util.base.ProChecker;
import com.future.captcha.api.conf.CaptchaConf;
import com.future.redis.util.RedisStringUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.UUID;

import static com.future.base.constant.common.ResponseElement.BAD_REQUEST;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author liuyunfei
 */
@SuppressWarnings({"SpellCheckingInspection", "AliControlFlowStatementWithoutBraces"})
public final class CaptchaProcessor {

    public static final int CAPTCHA_TIME_OUT = 10 * 60;
    private final Producer producer;

    public CaptchaProcessor(CaptchaConf conf) {

        Properties prop = new Properties();

        ofNullable(conf.getBorder())
                .ifPresent(v -> prop.put("kaptcha.border", v));
        ofNullable(conf.getBorderColor()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.border.color", v));
        ofNullable(conf.getBorderThickness())
                .ifPresent(v -> prop.put("kaptcha.border.thickness", v));
        ofNullable(conf.getProducerImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.producer.impl", v));
        ofNullable(conf.getTextProducerImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.textproducer.impl", v));
        ofNullable(conf.getTextProducerCharString()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.textproducer.char.string", v));
        ofNullable(conf.getTextProducerCharLength())
                .ifPresent(v -> prop.put("kaptcha.textproducer.char.length", v));
        ofNullable(conf.getTextProducerFontNames()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.textproducer.font.names", v));
        ofNullable(conf.getTextProducerFontSize())
                .ifPresent(v -> prop.put("kaptcha.textproducer.font.size", v));
        ofNullable(conf.getTextProducerFontColor()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.textproducer.font.color", v));
        ofNullable(conf.getTextProducerCharSpace())
                .ifPresent(v -> prop.put("kaptcha.textproducer.char.space", v));
        ofNullable(conf.getNoiseImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.noise.impl", v));
        ofNullable(conf.getNoiseColor()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.noise.color", v));
        ofNullable(conf.getObscurificatorImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.obscurificator.impl", v));
        ofNullable(conf.getWordImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.word.impl", v));
        ofNullable(conf.getBackgroundImpl()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.background.impl", v));
        ofNullable(conf.getBackgroundClearFrom()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.background.clear.from", v));
        ofNullable(conf.getBackgroundClearTo()).filter(StringUtils::isNotBlank)
                .ifPresent(v -> prop.put("kaptcha.background.clear.to", v));
        ofNullable(conf.getImageWidth()).filter(v -> v > 0)
                .ifPresent(v -> prop.put("kaptcha.image.width", v));
        ofNullable(conf.getImageHeight()).filter(v -> v > 0)
                .ifPresent(v -> prop.put("kaptcha.image.height", v));

        this.producer = new Config(prop).getProducerImpl();
    }

    public BufferedImage generateImage(String text) {
        if (isBlank(text))
            throw new ProException(BAD_REQUEST);
        return producer.createImage(text);
    }

    public String createText() {
        return producer.createText();
    }


    public void generateVerifyCode(HttpServletRequest request, HttpServletResponse response)  {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/png");
        String capText = producer.createText();
        String captchaKey = CookieUtil.getCookieValue(request, Constants.KAPTCHA_SESSION_KEY);
        if (ProChecker.isBlank(captchaKey)) {
            captchaKey = UUID.randomUUID().toString();
            CookieUtil.addCookie(response, Constants.KAPTCHA_SESSION_KEY, captchaKey, CAPTCHA_TIME_OUT);
        }
        RedisStringUtil.set(buildCaptchaKey(captchaKey, capText), capText, CAPTCHA_TIME_OUT);
        OutputStream out = null;
        try {
            BufferedImage bi = producer.createImage(capText);
            out = response.getOutputStream();
            ImageIO.write(bi, "png", out);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }


    public boolean verify(String verifyCode, HttpServletRequest request) {
        String captchaKey = CookieUtil.getCookieValue(request, Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isBlank(captchaKey)) {
            return false;
        }
        String code = RedisStringUtil.get(buildCaptchaKey(captchaKey, verifyCode));
        return StringUtils.equalsIgnoreCase(code,verifyCode);
    }


    private static String buildCaptchaKey(String captchaKey, String captchaCode) {
        if (StringUtils.isBlank(captchaKey)) {
            return null;
        }
        return "captcha:" + captchaCode + ":" + captchaKey;
    }

}
