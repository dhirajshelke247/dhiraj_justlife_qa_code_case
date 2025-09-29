package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BookingPage extends BasePage {
    By closeNotification = By.id("close-notification");
    By hoursDropdown = By.id("duration-1-text");
    By durationDetail = By.id("details-duration");
    By cleanersNumber = By.id("number_of_cleaners-0-text");
    By numberOfCleanerDetails = By.id("details-number-of-cleaners");
    By yesPlease = By.xpath("//*[text()='Yes, please']");
    By materialDetail = By.id("details-material");
    By nextButton = By.id("funnel-next-button");
    By modalHeading = By.xpath("//*[text()=' Choose your frequency']");
    By oneTimeSelector = By.id("frequency-id-1");
    By modalSelectBtn = By.xpath("(//*[@data-testid='default-button-text'])[1]");
    By frequencyDetail = By.id("details-frequency");
    By dateTimeTitle = By.xpath("//*[text()='Date & Time']");
    By enabledDayOne = By.id("enabled-day-1-text");
    By firstAvailableTime = By.id("time-0-text");
    By startTimeDetail = By.id("details-start-time");
    By additionalServiceDetail = By.className("multiple-lines");
    By nextBtnToStep4 = By.xpath("(//*[@data-testid='default-button-text'])[2]");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void selectHours() {
        try {
            if (!driver.findElements(closeNotification).isEmpty()) {
                waitForClickable(closeNotification).click();
            }
        } catch (Exception e) {
            System.out.println("Notification not displayed, continuing...");
        }

        WebElement hours = waitForClickable(hoursDropdown);
        hours.click();
        String displayedHours = waitForClickable(durationDetail).getText();
        Assert.assertTrue(displayedHours.contains(hours.getText()), "Displayed Hours doesn't match");
    }

    public void selectCleaners() {
        WebElement cleaners = waitForClickable(cleanersNumber);
        cleaners.click();
        String cleanerDetail = waitForElement(numberOfCleanerDetails).getText();
        Assert.assertTrue(cleanerDetail.contains(cleaners.getText()), "Number of cleaner doesn't match");
    }

    public void selectMaterial() {
        WebElement materialYes = waitForClickable(yesPlease);
        materialYes.click();
        String materialChosen = waitForElement(materialDetail).getText();
        Assert.assertTrue(materialYes.getText().contains(materialChosen), "Material needed text doesn't match");
    }

    public void clickNext() {
        waitForClickable(nextButton).click();
    }

    public void assertNoAddon() {
        List<WebElement> additionalServices = driver.findElements(additionalServiceDetail);
        Assert.assertTrue(additionalServices.isEmpty(), "Add-on service should NOT be visible!");
    }

    // Step 3/4


    public void changeFrequency() {
        Assert.assertTrue(waitForElement(dateTimeTitle).isDisplayed(), "Not on date and time page");

        WebElement modalTitle = waitForElement(modalHeading);
        Assert.assertTrue(modalTitle.isDisplayed(), "Modal not open");
        waitForClickable(oneTimeSelector).click();
        waitForClickable(modalSelectBtn).click();
        Assert.assertEquals(waitForClickable(frequencyDetail).getText(), "One Time", "Frequency text does not match!");
    }

    public void changeDateTime() {
        WebElement selectedDay = waitForClickable(enabledDayOne);
        selectedDay.click();
        WebElement selectedTime = waitForClickable(firstAvailableTime);
        selectedTime.click();
        String displayedText = waitForClickable(startTimeDetail).getText();
        Assert.assertTrue(displayedText.contains(selectedDay.getText()), "Displayed date does not match");
        Assert.assertTrue(displayedText.contains(selectedTime.getText()), "Displayed time does not match");
    }

    public void goToStep4(){
        waitForClickable(nextBtnToStep4).click();
    }
}
