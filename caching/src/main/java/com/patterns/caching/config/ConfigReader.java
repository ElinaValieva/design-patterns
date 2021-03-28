package com.patterns.caching.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

@AllArgsConstructor
public class ConfigReader {

    private final String configFile;

    public ConfigReader() {
        this.configFile = "application.properties";
    }

    public String getProperty(String name) {
        return loadProperties().getProperty(name);
    }

    @SneakyThrows
    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(configFile)) {
            properties.load(is);
        }
        return properties;
    }
}
