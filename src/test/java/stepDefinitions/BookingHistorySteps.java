package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pages.*;

public class BookingHistorySteps {
    WebDriver driver;
    BookingHistoryPage bookingHistoryPage;

    public BookingHistorySteps() {
        this.driver = Hooks.driver;
        bookingHistoryPage = new BookingHistoryPage(driver);
    }


    @Then("I go to Bookings page")
    public void i_go_to_bookings_page(){
        driver.get("https://www.justlife.com/en-AE/my-account/appointments/");
        bookingHistoryPage.verifyBookingsPage();
    }
    @When("I open last booking")
    public void i_open_past_booking(){
        bookingHistoryPage.openLatestBooking();
    }
    @Then("I print past booking detail")
    public void i_print_detail(){
        String bookingDetail = bookingHistoryPage.printBookingDetails();
        Hooks.scenario.log(bookingDetail);
    }


}
