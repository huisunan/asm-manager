package com.ark.tool.manager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "asm")
public class ArkProperties {
    private String path;
    private String serverPath;
}
