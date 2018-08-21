package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage extends BasePage {

    String discountsSelectorString = "//div[@class='right-block']//span[@class='price-percent-reduction']";

    private By productGrid = By.cssSelector("[class='product_list grid row']");
    private By discountProducts = By.xpath(discountsSelectorString + "/..");
    private By oldPrices = By.xpath("//div[@class='right-block']//span[@class='old-price product-price']");
    private By newPrices = By.xpath(discountsSelectorString + "/../span[@class='price product-price']");
    private By discounts = By.xpath(discountsSelectorString);


    public ProductListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> getDiscountProducts() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productGrid));
        return driver.findElements(discountProducts);
    }

    public String getOldPrice() {
        return driver.findElement(oldPrices).getText();
    }

    public String getNewPrice() {
        return driver.findElement(newPrices).getText();
    }

    public String getDiscount() {
        return driver.findElement(discounts).getText();
    }




}
