package com.musala.utils;

import java.util.Properties;

import static java.lang.System.getProperty;

public class ConfigUtils {
    private  Properties properties;
    private static ConfigUtils configUtils ;

    private ConfigUtils(){
                properties  = PropertiesUtils.loadProperties("src/test/java/com/musala/config/production.properties");
        }

    public static ConfigUtils getInstance(){
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl(){
        String prop =  properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("could not find the base url in the properties file");
    }
}
