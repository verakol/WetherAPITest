package com.testapi.weatherbit;

import java.io.IOException;

public class Utils {

private static final String FILE_PROPERTIES = "weatherbit.properties";

    public static String getProperty(String name) {
        try {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(FILE_PROPERTIES));
        return System.getProperty(name);
        }
        catch (IOException e){throw new RuntimeException("Property file is not found");}
    }

}
