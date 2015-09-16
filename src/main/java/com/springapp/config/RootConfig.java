package com.springapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Root context.
 *
 * @author Sergey Cherepanov
 */
@Configuration
public class RootConfig {

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("SecurityMessages");
        return source;
    }
}
