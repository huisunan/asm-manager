package com.ark.tool.manager.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ArkProperties.class)
public class ArkAutoConfiguration {
}
