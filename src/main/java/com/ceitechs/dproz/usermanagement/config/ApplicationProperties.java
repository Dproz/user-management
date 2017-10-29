package com.ceitechs.dproz.usermanagement.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to usermanagement.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
