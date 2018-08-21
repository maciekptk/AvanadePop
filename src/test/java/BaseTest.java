import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;

    String url = "http://automationpractice.com";

    @Before
    public void initializeDriverAndMaximize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        mainPage = new MainPage(driver, wait);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
