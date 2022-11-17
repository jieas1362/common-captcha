package com.future.captcha.ioc;

import com.future.captcha.api.conf.CaptchaConf;
import com.future.captcha.component.CaptchaProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

import static com.future.captcha.api.generator.ProCaptchaGenerator.generateCaptchaProcessor;

/**
 * captcha processor configuration
 *
 * @author liuyunfei
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ConditionalOnBean(value = {CaptchaConf.class})
@AutoConfiguration
public class ProCaptchaConfiguration {

    @Bean
    CaptchaProcessor captchaProcessor(CaptchaConf captchaConf) {
        return generateCaptchaProcessor(captchaConf);
    }

}