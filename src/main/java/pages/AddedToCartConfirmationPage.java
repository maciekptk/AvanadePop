package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddedToCartConfirmationPage extends BasePage {

    private By okIcon = By.cssSelector(".icon-ok");
    private By confirmationMessage = By.cssSelector(".layer_cart_product h2");
    private By cartLayer = By.cssSelector("[id='layer_cart']");
    private By addedProductName = By.cssSelector("#layer_cart_product_title");
    private By actualQuantity = By.cssSelector("#layer_cart_product_quantity");
    private By actualSize = By.cssSelector("[class='layer_cart_product_info']");

    public AddedToCartConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getConfirmationMessage() {
        String confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
        return confirmation;
    }

    public String getAddedProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedProductName)).getText();
    }

    public String getActualQuantity() {
        return driver.findElement(actualQuantity).getText();
    }

    public String getActualSize() {
        return driver.findElement(actualSize).getText();
    }
}
