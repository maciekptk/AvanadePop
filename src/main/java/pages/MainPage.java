package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private By searchInput = By.cssSelector("#search_query_top");
    private By searchButton = By.cssSelector("[name='submit_search']");
    private By dressesButton = By.cssSelector("div>ul>li>[title='Dresses']");
    private By firstProduct = By.cssSelector("ul#homefeatured li:first-of-type");
    private By firstProductQuickViewButton = By.cssSelector("ul#homefeatured li:first-of-type .quick-view");
    private By addToCartButton = By.cssSelector("[id='add_to_cart'] button span");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
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

    public MainPage hoverOverFirstProduct() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(firstProduct)).build().perform();
        return this;
    }

    public MainPage clickFirstProductQuickViewButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductQuickViewButton)).click();
        return this;
    }

    public AddedToCartConfirmationPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton)).click();
        return new AddedToCartConfirmationPage(driver);
    }
}
