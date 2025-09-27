package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    public static Scenario scenario;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
