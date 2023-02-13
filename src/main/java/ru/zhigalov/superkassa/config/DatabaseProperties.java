package ru.zhigalov.superkassa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
public record DatabaseProperties(
        String url,
        String username,
        String password
) {
}
