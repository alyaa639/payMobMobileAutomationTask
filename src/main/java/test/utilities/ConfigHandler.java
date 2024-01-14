package test.utilities;

import java.io.*;
import java.util.Properties;

public class ConfigHandler {

    private static Properties androidProperties;
    private static  Properties dataProperties ;
    private static final String DATA_COFIG_PATH="resources/config/registraion_data_staging.properties" ;

    public static final String ANDROID_CONFIG_PATH = "resources/config/config-android.properties";

    private ConfigHandler() {
    }


        public static void setConfigProperties() throws IOException {
            setDataProperties();
    }
    public static void setAndroidProperties() throws IOException {
        androidProperties = new Properties();
        androidProperties.load(new FileInputStream(ANDROID_CONFIG_PATH));
    }
    public static void setDataProperties() throws IOException {
        dataProperties = new Properties();
        dataProperties.load(new FileInputStream(DATA_COFIG_PATH));
    }
    public static Properties getAndroidProperties() {
        return androidProperties;
    }
    public static Properties getDataProperties() {
        return dataProperties;
    }

}
