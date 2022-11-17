package com.future.captcha.component;

import com.future.base.model.exps.ProException;
import com.future.captcha.api.conf.CaptchaConf;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import org.apache.commons.lang3.StringUtils;

import java.awt.image.BufferedImage;
import java.util.Properties;

import static com.future.base.constant.common.ResponseElement.BAD_REQUEST;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author liuyunfei
 */
@SuppressWarnings({"SpellCheckingInspection", "AliControlFlowStatementWithoutBraces"})
public final class CaptchaProcessor {

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

}
