package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pages.*;

public class BookingSteps {
    WebDriver driver;
    BookingPage bookingPage;

    public BookingSteps() {
        this.driver = Hooks.driver;
        bookingPage = new BookingPage(driver);
    }

    @When("I select hours")
    public void i_select_hours(){
        bookingPage.selectHours();
    }

    @When("I select number of cleaners")
    public void i_select_cleaners() {
        bookingPage.selectCleaners();
    }

    @When("I select material")
    public void i_select_material() {
        bookingPage.selectMaterial();
    }

    @When("I proceed to add-on page")
    public void i_proceed_addon() {
        bookingPage.clickNext();
    }

    @When("I proceed to date and time page")
    public void i_proceed_date_time() {
        bookingPage.clickNext();
    }

    //Step 3

    @Then("I assert no Add-ons")
    public void i_no_addon(){
        bookingPage.assertNoAddon();
    }

    @When("I change frequency")
    public void i_change_frequency() {
        bookingPage.changeFrequency();
    }

    @When("I change date and time")
    public void i_change_date_time() {
        bookingPage.changeDateTime();
    }

    @When("I move to step 4")
    public void i_proceed_to_step4() {
        bookingPage.goToStep4();
    }

}
