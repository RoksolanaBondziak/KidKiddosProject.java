package Pages;

public class ProductPage extends BasePage {

    public static final String PRODUCT_PAGE_DESCRIPTION = "//div[@class = 'product-single__meta']//descendant::h1[contains(text(),'Fruits and Vegetables')]";
    public static final String BOOK_OPTION = "//a[@class = 'grid-view-item__link']//descendant::div[contains(text(), 'I Love to Eat Fruits and Vegetables')]";

    public boolean isVisibleProductPage() {
        return elementExists(PRODUCT_PAGE_DESCRIPTION);
    }

    public static ProductPage pickTheBook() {
        clickElementByXpath(BOOK_OPTION);
        return new ProductPage();
    }
}