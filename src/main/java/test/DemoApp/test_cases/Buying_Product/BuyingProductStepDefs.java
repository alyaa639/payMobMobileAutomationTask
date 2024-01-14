package test.DemoApp.test_cases.Buying_Product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import test.base_test.BaseTest;
import test.device.Device;

public class BuyingProductStepDefs extends BaseTest {


    @Given("app opened successfully to home screen")
    public void appOpenedSuccessfullyToHomeScreen() {
    }

    @When("click on side menu in home page")
    public void clickOnSideMenuInHomePage() {
        Device.demoApp.home.clickOnSideMenuButton();


    }

    @And("click on login button in side menu")
    public void clickOnLoginButtonInSideMenu() {
       Device.demoApp.login= Device.demoApp.home.clickOnLoginOptionInSideMenu();
    }

    @And("select the existing user in login screen")
    public void selectTheExistingUserInLoginScreen() {
        Device.demoApp.login.clickOnUseNmaeAndPasswordHeader();
    }

    @And("click on login button in login screen")
    public void clickOnLoginButtonInLoginScreen() {
     Device.demoApp.home= Device.demoApp.login.clickOnLoginButton();
    }

    @Then("user should be directed to home screen")
    public void userShouldBeDirectedToHomeScreen() {
        Assert.assertTrue(Device.demoApp.home.getProductsTitle());

    }

    @When("click on the first product in home screen")
    public void clickOnTheFirstProductInHomeScreen() {
      Device.demoApp.firstProduct =  Device.demoApp.home.clickOnFirstProduct();
    }

    @And("click on add to cart button in first product screen")
    public void clickOnAddToCartButtonInFirstProductScreen() {
        Device.demoApp.firstProduct.clickOnAddToCartButton();
    }
    @And("click on the cart button in first product screen")
    public void clickOnTheCartButtonInFirstProductScreen() {
     Device.demoApp.myCart =  Device.demoApp.firstProduct.clickOnCartButton();

    }

    @And("click on proceed to checkout in cart screen")
    public void clickOnProceedToCheckoutInCartScreen() {
      Device.demoApp.checkout =Device.demoApp.myCart.clickOnProceedToCheckout();
    }

    @And("enter full name {string} in full name field in checkout screen")
    public void enterFullNameInFullNameFieldInCheckoutScreen(String name) {
        Device.demoApp.checkout.enterNameInFieldName(name);
    }

    @And("enter address {string} in address line field in checkout screen")
    public void enterAddressInAddressLineFieldInCheckoutScreen(String address) {
        Device.demoApp.checkout.enterAddressInAddressField(address);
    }

    @And("enter city {string} in city field in checkout screen")
    public void enterCityInCityFieldInCheckoutScreen(String city) {
        Device.demoApp.checkout.enterCityInCityField(city);
    }

    @And("enter zip coe {string} in zip code field in checkout screen")
    public void enterZipCoeInZipCodeFieldInCheckoutScreen(String code) {
        Device.demoApp.checkout.enterZipCodeInZipCodeField(code);
    }

    @And("enter country {string} in country field in checkout screen")
    public void enterCountryInCountryFieldInCheckoutScreen(String country) {
        Device.demoApp.checkout.enterCountryInCountryField(country);
    }
    @And("click on to payment button in checkout screen")
    public void clickOnToPaymentButtonInCheckoutScreen() {
       Device.demoApp.payment = Device.demoApp.checkout.clickOnToPaymentButton();
    }
    @And("enter card holder name {string} in card holder name field in  payment screen")
    public void enterCardHolderNameInCardHolderNameFieldInPaymentScreen(String cardHolderName) {
        Device.demoApp.payment.enterFullName(cardHolderName);
    }

    @And("enter card number {string} in card number field in payment screen")
    public void enterCardNumberInCardNumberFieldInPaymentScreen(String cardNumber) {
        Device.demoApp.payment.enterCardNumber(cardNumber);
    }

    @And("enter card expiery date {string} in expiery date field in  payment screen")
    public void enterCardExpieryDateInExpieryDateFieldInPaymentScreen(String date) {
        Device.demoApp.payment.enterExpieryDate(date);
    }

    @And("enter security code {string} in security code in  payment screen")
    public void enterSecurityCodeInSecurityCodeInPaymentScreen(String secCode) {
        Device.demoApp.payment.enterSecurityCode(secCode);
    }

    @And("click on review order button in paymnet screen")
    public void clickOnReviewOrderButtonInPaymnetScreen() {
     Device.demoApp.reviewOrder= Device.demoApp.payment.clickOnReviewOrderButton();
    }
    @And("click on proceed to checkout in review your order screen")
    public void clickOnProceedToCheckoutInReviewYourOrderScreen() {
      Device.demoApp.completeCheckout =  Device.demoApp.reviewOrder.clickOnPlaceOrderButton();

    }

    @Then("success message {string} in completed order screen")
    public void successMessageInCompletedOrderScreen(String message) {
        Assert.assertEquals(Device.demoApp.completeCheckout.getCheckoutCompleteTitle(), message);
    }


}
