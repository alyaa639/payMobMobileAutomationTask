package test.DemoApp.test_cases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import test.base_test.BaseTest;
import test.utilities.AndroidNetworkHandler;
import test.utilities.ConfigHandler;

import java.io.IOException;
public class HooksHandler extends BaseTest {

    @Before(order = 0)
    public void beforeAll() throws IOException {
        if (beforeAll) {
            ConfigHandler.setConfigProperties();
            beforeAll = false;
                  }
    }

    @Before(order = 1)
    public void setUp() {
            setupAndroid();

    }
    public void setupAndroid() {
        useWifiOnly();
        device.launchDemoApp();
    }

    @Before("@Use-Data-Only")
    public void useDataOnly() {
        AndroidNetworkHandler.enableData();
        AndroidNetworkHandler.disableWifi();
    }

    @Before("@Use-Wifi-Only")
    public void useWifiOnly() {
        AndroidNetworkHandler.enableWifi();
        AndroidNetworkHandler.disableData();
    }

    @Before("@Disable-Wifi")
    public void disableWifi() {
        AndroidNetworkHandler.disableWifi();
    }

    @Before("@Disable-Data")
    public void disableData() {
        AndroidNetworkHandler.disableData();
    }

    @After("@Reset-Network-Speed")
    public void resetNetworkSpeed() {
        AndroidNetworkHandler.setNetworkToFull();
    }


    @After(order = 0)
    public void tearDown() throws InterruptedException {
        device.resetDemoApp();
        device.closeDemoApp();
        server.closeAppiumServer();
    }





}


