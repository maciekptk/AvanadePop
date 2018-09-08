import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;

    String url = "http://automationpractice.com";

    @Before
    public void initializeDriverAndMaximize() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.setCapability("browserName", "chrome");
//        options.setCapability("platform", "WIN10");
        options.addArguments("--start-maximized");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//            driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, 5);
//        driver.manage().window().maximize();
        driver.navigate().to(url);
        mainPage = new MainPage(driver, wait);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
