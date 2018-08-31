package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    private By quantityInput = By.cssSelector("#quantity_wanted");
    private By sizeSelector = By.cssSelector("#group_1");
    private By addToCartButton = By.cssSelector("[name='Submit']");


    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
    }

    public ProductDetailsPage setQuantity(String quantity) {
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityInput)).clear();
        driver.findElement(quantityInput).sendKeys(quantity);
        return this;
    }

    public ProductDetailsPage setSize(String size) {
        new Select(driver.findElement(sizeSelector)).selectByVisibleText(size);
        return this;
    }

    public AddedToCartConfirmationPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new AddedToCartConfirmationPage(driver);
    }
}
