package com.drex.driver.config;

import static org.aeonbits.owner.ConfigCache.getOrCreate;

public class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static Configuration getConfiguration() {
        return getOrCreate(Configuration.class);
    }
}
