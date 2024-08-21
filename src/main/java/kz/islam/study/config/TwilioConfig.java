package kz.islam.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "kz.islam.study")
@PropertySource("classpath:application.properties")
public class TwilioConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public String twilioAccountSid() {
        return env.getProperty("twilio.account.sid");
    }

    @Bean
    public String twilioAuthToken() {
        return env.getProperty("twilio.auth.token");
    }

    @Bean
    public String twilioPhoneNumber() {
        return env.getProperty("twilio.phone.number");
    }
}
