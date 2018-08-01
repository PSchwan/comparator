package com.schwan.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {

    private static Properties PROPERTIES;
    private static final String PROPERTIES_FILE_LOCATION = "properties/";
    private static final String PROPERTIES_FILE_NAME = "system.properties";

    public static final String PROP_SEMANTICS_API_KEY = "semantics3.api.key";
    public static final String PROP_SEMANTICS_API_SECRET = "semantics3.api.secret";


    public static String get(String propertyName) {
        return get(propertyName, null);
    }

    public static String get(String propertyName, String defaultValue) {
        if(PROPERTIES == null) {
            readPropertiesIn();
        }
        return PROPERTIES.getProperty(propertyName, defaultValue);
    }

    private static void readPropertiesIn() {
        String file_location = PROPERTIES_FILE_LOCATION + PROPERTIES_FILE_NAME;
        System.out.println("Reading in properties at: " + file_location);
        InputStream input = null;
        PROPERTIES = new Properties();

        try {

            input = new FileInputStream(file_location);

            // load a PROPERTIES file
            PROPERTIES.load(input);
            System.out.println(PROPERTIES);

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException when reading PROPERTIES: " + e);
        } catch (IOException e) {
            System.out.println("IOException when reading PROPERTIES: " + e);

        }
    }
}
