import org.junit.Assert;
import org.junit.Test;
import pages.AddedToCartConfirmationPage;

public class Zajecia4Test extends BaseTest {

    @Test
    public void zadanie4_1() {
        AddedToCartConfirmationPage addedToCartConfirmationPage = mainPage.hoverOverFirstProduct()
                .clickFirstProductQuickViewButton()
                .clickAddToCartButton();

        Assert.assertTrue("Product not added to the cart", addedToCartConfirmationPage.getConfirmationMessage().contains("Product successfully added"));
    }
}
