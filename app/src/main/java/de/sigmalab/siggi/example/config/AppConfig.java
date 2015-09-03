package de.sigmalab.siggi.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.sigmalab.siggi.example.service.EnvPropertyPrinter;

/**
 * @author  jbellmann
 */
@Configuration
public class AppConfig {

    @Bean
    public EnvPropertyPrinter envPropertyPrinter() {
        return new EnvPropertyPrinter();
    }
}
