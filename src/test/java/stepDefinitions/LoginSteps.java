package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import hooks.Hooks;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.driver;
        loginPage = new LoginPage(driver);
    }

    @Given("I open the Justlife checkout page")
    public void i_open_checkout_page() {
        driver.get("https://www.justlife.com/en-AE/home-cleaning/checkout/details?step=1");
    }

    @When("I login with Number {string} and OTP {string}")
    public void i_login(String number, String otp) {
        loginPage.login(number, otp);
    }
}
