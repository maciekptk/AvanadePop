package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends MainPage {

    private By printedChiffonDressName = By.xpath("//div[@class='right-block']//a[@title='Printed Chiffon Dress']");
    private By addToCartButton = By.cssSelector("li.hovered [title='Add to cart']");

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public SearchResultsPage hoverOverPrintedChiffonDress() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(printedChiffonDressName)).build().perform();
        return this;
    }

    public ProductDetailsPage clickPrintedChiffonDress() {
        driver.findElement(printedChiffonDressName).click();
        return new ProductDetailsPage(driver, wait);
    }

    public AddedToCartConfirmationPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new AddedToCartConfirmationPage(driver, wait);
    }

}
