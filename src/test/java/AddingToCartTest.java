import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.AddedToCartConfirmationPage;
import pages.ProductListPage;

public class AddingToCartTest extends BaseTest {

    String printedDressQuery = "Printed Dress";
    String dressName = "Printed Chiffon Dress";

    @Test
    public void zadanie1Pop() {
        AddedToCartConfirmationPage addedToCartConfirmationPage = mainPage.setSearchInput(printedDressQuery)
                .clickSearchButton()
                .hoverOverPrintedChiffonDress()
                .clickAddToCartButton();

        Assert.assertTrue("Product not added to the cart", addedToCartConfirmationPage.getConfirmationMessage().contains("Product successfully added"));
    }

    @Test
    public void zadanie2Pop() {
        String quantity = "3";
        String size = "L";

        AddedToCartConfirmationPage addedToCartConfirmationPage = mainPage.setSearchInput(printedDressQuery)
                .clickSearchButton()
                .clickPrintedChiffonDress()
                .setQuantity(quantity)
                .setSize(size)
                .clickAddToCartButton();

        Assert.assertEquals("Wrong product added to the cart", dressName, addedToCartConfirmationPage.getAddedProductName());
        Assert.assertEquals("Number of added products is different than: " + quantity, quantity, addedToCartConfirmationPage.getActualQuantity());
        Assert.assertTrue("Size of added product is different than: " + size, addedToCartConfirmationPage.getActualSize().contains(size));
    }

    @Test
    public void zadanie3Pop() {
        ProductListPage productListPage = mainPage.clickDressesButton();

        for (WebElement element : productListPage.getDiscountProducts()) {
            String oldPriceString = productListPage.getOldPrice().substring(1);
            Float oldPrice = Float.parseFloat(oldPriceString);

            String newPriceString = productListPage.getNewPrice().substring(1);
            Float newPrice = Float.parseFloat(newPriceString);

            String discountString = productListPage.getDiscount().replaceAll("[^\\d]", "");
            Float discount = Float.parseFloat(discountString);

            Assert.assertEquals("Actual price is wrongly calculated", (oldPrice * ((100 - discount)/100)), newPrice, 0.01);
        }
    }
}
