package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private By searchInput = By.cssSelector("#search_query_top");
    private By searchButton = By.cssSelector("[name='submit_search']");
    private By dressesButton = By.cssSelector("div>ul>li>[title='Dresses']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage setSearchInput(String searchInputString) {
        driver.findElement(searchInput).sendKeys(searchInputString);
        return this;
    }

    public ProductListPage clickDressesButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(dressesButton)).click();
        return new ProductListPage(driver, wait);
    }

    public SearchResultsPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver, wait);
    }
}
