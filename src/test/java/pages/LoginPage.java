package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    By openUserDropDown = By.id("open-user-dropdown-button");
    By loginBtn = By.xpath("//*[text()='Sign up or Log in']");
    By phoneNumberInput = By.id("phone-number-input");
    By createOTPBtn = By.id("create-otp-button");
    By otpFirstDigit = By.id("otp-digit-0");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String phoneNumber, String otp) {
        int attempts = 0;
        int maxAttempts = 5;
        boolean loginBtnVisible = false;

        while (attempts < maxAttempts) {
            try {
                waitForClickable(openUserDropDown).click();
                if (waitForElement(loginBtn) != null) {
                    loginBtnVisible = true;
                    break;
                }
            } catch (Exception e) {
            }
            attempts++;
        }

        if (!loginBtnVisible) {
            throw new RuntimeException("Login button not visible after " + maxAttempts + " attempts");
        }
        waitForClickable(loginBtn).click();
        waitForClickable(phoneNumberInput).sendKeys(phoneNumber);
        waitForClickable(createOTPBtn).click();
        waitForClickable(otpFirstDigit).sendKeys(otp);

        WebElement usernameElement = waitForClickable(usernameVisible);
        Assert.assertTrue(usernameElement.isDisplayed(), "Username is not visible!");
    }
}
