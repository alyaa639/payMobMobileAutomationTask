package test.device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.internal.collections.Pair;
import test.driver.AppDriver;
import test.DemoApp.test_cases.DemoApp;
import test.utilities.ConfigHandler;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Device {

    private static final AppDriver appDriver = AppDriver.getAppDriver();
    private static Dimension dimensions;

     public static DemoApp demoApp = new DemoApp(appDriver.getDriver());

    public SoftAssert softAssert = new SoftAssert();

    public Device(int waitTime) {
        dimensions = getDimensions();
        PageFactory.initElements(new AppiumFieldDecorator((AppiumDriver) appDriver.getDriver(), Duration.ofSeconds(waitTime)), this);
    }

        public void launchDemoApp() {
            appDriver.getDriver().activateApp(ConfigHandler.getAndroidProperties().getProperty("appPackage"));
        }



        public void closeDemoApp() {
            appDriver.getDriver().closeApp();
        }
        public static void scrollTo(WebElement element, boolean down) {
            String initialScreenSource;
            while (!elementIsDisplayed(element)) {
                initialScreenSource = appDriver.getDriver().getPageSource();
                scroll(down);
                if (isScreenSourceUnchanged(initialScreenSource)) {
                    throw new NoSuchElementException("An element could not be located on the page using the given search parameters.");}}
        }
        private static boolean isScreenSourceUnchanged(String initialScreenSource) {
            String currentScreenSource = appDriver.getDriver().getPageSource();
            return initialScreenSource.equals(currentScreenSource);
        }

        public static void scroll(boolean down) {

            double screenMiddle = dimensions.getWidth() ;
            double yAxisBottom = dimensions.getHeight() ;
            double yAxisTop = dimensions.getHeight() ;
          TouchAction touchAction = new TouchAction(appDriver.getDriver());

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"first-finger");
            Sequence sequence = new Sequence(finger,0);
            sequence.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), (int) screenMiddle, (int) yAxisBottom))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(), (int) screenMiddle, (int) yAxisTop))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
            if (down)
                appDriver.getDriver().perform(Collections.singletonList(sequence));
        }

        public void swipe(WebElement firstElement, boolean isSwipeRight) {
            int startY = firstElement.getLocation().y;
            Pair<Integer, Integer> coordinates = getSwipeHorizontalCoordinates(isSwipeRight);
            new TouchAction(appDriver.getDriver())
                    .longPress(PointOption.point(coordinates.first(), startY))
                    .moveTo(PointOption.point(coordinates.second(), startY))
                    .release()
                    .perform();
        }

        private Pair<Integer, Integer> getSwipeHorizontalCoordinates(boolean isSwipeRight) {

            double startXCoordinates = dimensions.getWidth() ;
            double endXCoordinates = dimensions.getWidth() ;
            double tempStartXCoordinates = startXCoordinates;

            if (isSwipeRight) {
                startXCoordinates = endXCoordinates;
                endXCoordinates = tempStartXCoordinates;
            }

            return new Pair(startXCoordinates, endXCoordinates);
        }

        public static boolean elementIsDisplayed(WebElement element) {
            try {
                return element.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }

        public boolean elementIsClickable(WebElement element)
        {
            return Boolean.parseBoolean(element.getAttribute("clickable"));
        }

        public boolean elementIsDimmed(WebElement element)
        {
            return Boolean.parseBoolean(element.getAttribute("checked"));
        }

        public String getElementAttribute(WebElement element , String attribute){
            return element.getAttribute(attribute);
        }

        public void waitBySeconds(int seconds){
            WebDriverWait wait = new WebDriverWait(appDriver.getAppDriver().getDriver(), Duration.ofSeconds(seconds)) ;
        }


        private org.openqa.selenium.Dimension getDimensions() {
            return appDriver.getDriver().manage().window().getSize();
        }

        public void goBackToDemoApp() {
            appDriver.getDriver().activateApp(ConfigHandler.getAndroidProperties().getProperty("appPackage"));
        }
    public   void clearDemoAppCache() {
        String appPackage = "io.paysky.yalla.debug";
        String command = String.format("adb -s %s shell pm clear %s",  appDriver.getDriver().getSessionId(), appPackage);
        appDriver.getDriver().executeScript("mobile:shell", command);
    }

        public void resetDemoApp() throws InterruptedException {
            try {
                Runtime.getRuntime().exec("adb shell pm clear com.emeint.android.myservices");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void uninstallDemoApp(String appPackage) {
            appDriver.getDriver().removeApp(ConfigHandler.getAndroidProperties().getProperty(appPackage));
        }


        public boolean elementIsEnabled(WebElement element) {
            try {
                return element.isEnabled();
            } catch (Exception e) {
                return false;
            }
        }

}


