package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends BasePage {
    By paymentChangeBtn = By.id("payment-change");
    By modalBody = By.id("payment-methods-modal-body");
    By completeBtn = By.xpath("//*[text()='Complete']");
    By modalSelectBtn = By.xpath("(//*[@data-testid='default-button-text'])[1]");
    By errorDesc = By.id("notification-message-description");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void changePaymentMethod() {
        waitForClickable(paymentChangeBtn).click();
    }

    public String printAvailablePaymentMethods() {
        WebElement modal = waitForElement(modalBody);
        List<WebElement> paymentMethods = modal.findElements(By.cssSelector(".radio-selection-wrapper"));

        boolean cashFound = false;
        StringBuilder details = new StringBuilder("Payment Methods:\n");
        for (WebElement method : paymentMethods) {
            String name = method.getText().trim();
            details.append(name).append("\n");
            if (name.toLowerCase().contains("cash")) cashFound = true;
        }

        if (!cashFound) {
            System.out.println("Cash payment method is NOT available!");
            details.append("Cash payment method is NOT available!").append("\n");}
        return details.toString();
    }

    public String completeBooking() {
        StringBuilder details = new StringBuilder("Notification:\n");
        waitForClickable(modalSelectBtn).click();
        waitForClickable(completeBtn).click();
        String notificationText = waitForClickable(errorDesc).getText();
        System.out.println(notificationText);
        details.append(notificationText).append("\n");
        return details.toString();
    }
}
