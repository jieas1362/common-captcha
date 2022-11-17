package com.future.captcha.api.generator;

import com.future.captcha.api.conf.CaptchaConf;
import com.future.captcha.api.conf.CaptchaConfParams;
import com.future.captcha.component.CaptchaProcessor;

/**
 * captcha processor generator
 *
 * @author liuyunfei
 */
@SuppressWarnings("unused")
public final class ProCaptchaGenerator {

    private static final CaptchaConf DEFAULT_CONF = new CaptchaConfParams();

    public static CaptchaProcessor generateCaptchaProcessor() {
        return generateCaptchaProcessor(DEFAULT_CONF);
    }

    public static CaptchaProcessor generateCaptchaProcessor(CaptchaConf captchaConf) {
        return new CaptchaProcessor(captchaConf!=null ? captchaConf : DEFAULT_CONF);
    }

}
