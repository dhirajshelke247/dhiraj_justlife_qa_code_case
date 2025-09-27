package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PaymentSteps {
    WebDriver driver;
    PaymentPage paymentPage;

    public PaymentSteps() {
        this.driver = Hooks.driver;
        this.paymentPage = new PaymentPage(driver);
    }


    @When("I change payment type")
    public void i_change_payment_type(){
        paymentPage.changePaymentMethod();
    }

    @When("I check for Cash Option")
    public void i_check_for_cash(){
        String paymentMethods = paymentPage.printAvailablePaymentMethods();
        Hooks.scenario.log(paymentMethods);
    }

    @When("I complete Booking Process")
    public void i_complete_booking(){
        String completeBookingNotification = paymentPage.completeBooking();
        Hooks.scenario.log(completeBookingNotification);
    }

}
