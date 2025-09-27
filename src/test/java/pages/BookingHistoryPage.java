package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class BookingHistoryPage extends BasePage {
    By pastTabTitle = By.id("past-tab-title");
    By latestPastBooking = By.id("appointment-0");
    By bookingDropdown = By.id("dropdown-bookings");
    By bookingsPageTitle = By.xpath("(//*[text()='Bookings'])[2]");
    By upcomingTabTitle = By.id("upcoming-tab-title");
    By noUpcomingBookingText = By.xpath("//*[text()=\"You don't have any upcoming appointments\"]");


    public BookingHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void goToBookingsPage(){
        waitForClickable(usernameVisible).click();
        waitForClickable(bookingDropdown).click();
        WebElement onBookingsPage = waitForElement(bookingsPageTitle);
        Assert.assertTrue(onBookingsPage.isDisplayed(),"Not on Bookings page");
        waitForElement(upcomingTabTitle).click();
        WebElement noBookings = waitForElement(noUpcomingBookingText);
        Assert.assertTrue(noBookings.isDisplayed(),"Some booking is present");
    }

    public void openLatestBooking() {
        waitForClickable(pastTabTitle).click();
        waitForClickable(latestPastBooking).click();
    }

    public String printBookingDetails() {
        List<WebElement> bookingRows = waitForElements(By.cssSelector(".appointment-detail-row"));

        StringBuilder details = new StringBuilder("Booking Details:\n");
        for (WebElement row : bookingRows) {
            String label = row.findElement(By.cssSelector(".adr-title")).getText();
            String value = row.findElement(By.cssSelector(".adr-description")).getText();
            details.append(label).append(": ").append(value).append("\n");
        }
        return details.toString();
    }
}
