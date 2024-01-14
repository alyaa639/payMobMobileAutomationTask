package test.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import test.base_test.BaseTest;
import test.utilities.ConfigHandler;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
public class AppDriver extends BaseTest {
        private static final String PLATFORM_NAME = "platformName";
        public static final String PLATFORM_VERSION = "platformVersion";
        public static final String DEVICE_NAME = "deviceName";
        public static final String UDID= "udid";
        public static final String AUTOMATION_NAME ="automationName";

        private static Properties properties;
        private static UiAutomator2Options uiAutomator2Options;
          public static AppDriver appDriver = null ;
        private AndroidDriver driver;

        private AppDriver(){
                setAndroidDriver();

        }

        public static AppDriver getAppDriver() {
            if (appDriver == null) {
                appDriver = new AppDriver();
            }
            return appDriver;
        }

        public AndroidDriver getDriver() {
            return driver;
        }

        public void setAndroidDriver() {
            try {
                ConfigHandler.setAndroidProperties();
                properties = ConfigHandler.getAndroidProperties();
                setAndroidUiAutomator2Options();

                setAppPackageAndActivity();

                driver = new AndroidDriver(server.getCurrentServerUrl(), uiAutomator2Options);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        private static void setAndroidUiAutomator2Options() throws IOException {
            String appDirectory = getAppDirectory();

            uiAutomator2Options = new UiAutomator2Options();
            uiAutomator2Options.setPlatformName(properties.getProperty(PLATFORM_NAME));
            uiAutomator2Options.setPlatformVersion(properties.getProperty(PLATFORM_VERSION));
            uiAutomator2Options.setDeviceName(properties.getProperty(DEVICE_NAME));
            uiAutomator2Options.setCapability("newCommandTimeout", 1200);
            uiAutomator2Options.setApp(appDirectory);
            uiAutomator2Options.setUdid(properties.getProperty(UDID));
            uiAutomator2Options.setAutomationName(properties.getProperty(AUTOMATION_NAME));
            uiAutomator2Options.setCapability("autoDismissAlerts", true);
            uiAutomator2Options.setCapability("unicodeKeyboard", true);
            uiAutomator2Options.setCapability("resetKeyboard", true);
        }

        private static void setAppPackageAndActivity() {
            uiAutomator2Options.setAppPackage(properties.getProperty("appPackage"));
            uiAutomator2Options.setAppActivity(properties.getProperty("appActivity"));
        }

        private static String getAppDirectory() throws IOException {
            File app = new File(properties.getProperty("app"));
            String appDirectory = app.getCanonicalPath();
            return appDirectory;
        }
    }


