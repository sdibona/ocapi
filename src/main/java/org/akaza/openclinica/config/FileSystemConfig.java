package org.akaza.openclinica.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by stevedibona on 5/26/16.
 */
@Configuration
public class FileSystemConfig {

    @Autowired
    private MultitenancyProperties multitenancyProperties;

    @Bean(name = "attachedFileLocation")
    @ConfigurationProperties(prefix = "spring.multitenancy.datasource1")
    public String attachedFileLocation() {
        return multitenancyProperties.getAttachedFileLocation();
    }
}
