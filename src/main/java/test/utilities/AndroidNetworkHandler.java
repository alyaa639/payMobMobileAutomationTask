package test.utilities;

import test.driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.android.connection.ConnectionStateBuilder;


public class AndroidNetworkHandler {

    static ConnectionStateBuilder connectionStateBuilder = new ConnectionStateBuilder();

    private static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) AppDriver.getAppDriver().getDriver();
    }

    public static void disableInternetConnection() {
        disableWifi();
        disableData();
    }

    public static void enableInternetConnection() {
        enableWifi();
        enableData();
    }

    public static void setNetworkToGSM() {
        getAndroidDriver().setNetworkSpeed(NetworkSpeed.GSM);
    }
    public static void setNetworkToFull() {
        getAndroidDriver().setNetworkSpeed(NetworkSpeed.FULL);
    }

    public static void disableData() {
        getAndroidDriver().setConnection(connectionStateBuilder.withDataDisabled().build());
    }

    public static void disableWifi() {
        getAndroidDriver().setConnection(connectionStateBuilder.withWiFiDisabled().build());
    }

    public static void enableData() {
        getAndroidDriver().setConnection(connectionStateBuilder.withDataEnabled().build());
    }

    public static void enableWifi() {
        getAndroidDriver().setConnection(connectionStateBuilder.withWiFiEnabled().build());
    }
}
