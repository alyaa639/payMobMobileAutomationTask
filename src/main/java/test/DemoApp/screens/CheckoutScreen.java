package test.DemoApp.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import test.base_screen.BaseScreen;

public class CheckoutScreen extends BaseScreen {
    private final By fieldName = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]") ;
    private final By addressField =AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]") ;
    private final By cityField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]") ;
    private final By zipCodeField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]") ;
    private final By countryField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]") ;
    private final By toPaymentButton = AppiumBy.xpath("//android.widget.TextView[@text=\"To Payment\"]") ;

    public CheckoutScreen(AppiumDriver driver) {
        super(driver);
    }
    public void enterNameInFieldName(String name){
        findElement(fieldName).sendKeys(name);
    }
    public void enterAddressInAddressField(String address){
        findElement(addressField).sendKeys(address);
    }
    public void enterCityInCityField(String city){
        findElement(cityField).sendKeys(city);
    }
    public void enterZipCodeInZipCodeField(String zipCode){
        findElement(zipCodeField).sendKeys(zipCode);
    }
    public void enterCountryInCountryField(String country){
        findElement(countryField).sendKeys(country);
    }
    public PaymentScreen clickOnToPaymentButton(){
        findElement(toPaymentButton).click();
        return new PaymentScreen(driver) ;
    }
}
