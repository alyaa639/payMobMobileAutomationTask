package test.base_test;

import test.server.appiumServer;
import test.device.Device;

import java.util.Properties;

public class BaseTest {
        protected static Properties data;
    protected static Device device = new Device(35);
    protected static boolean beforeAll = true;

    public appiumServer server = new appiumServer() ;

}