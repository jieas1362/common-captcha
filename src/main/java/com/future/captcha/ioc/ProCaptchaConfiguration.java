package com.future.captcha.ioc;

import com.future.captcha.api.conf.CaptchaConf;
import com.future.captcha.component.CaptchaProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import static com.future.captcha.api.generator.ProCaptchaGenerator.generateCaptchaProcessor;

/**
 * captcha processor configuration
 *
 * @author liuyunfei
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@AutoConfiguration
public class ProCaptchaConfiguration {

    @Bean
    @ConditionalOnMissingBean(CaptchaConf.class)
    CaptchaProcessor captchaProcessor() {
        return generateCaptchaProcessor(null);
    }


    @Bean
    CaptchaProcessor captchaProcessor(CaptchaConf captchaConf) {
        return generateCaptchaProcessor(captchaConf);
    }

}