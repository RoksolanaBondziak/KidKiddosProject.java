package Pages;

public class BooksResultPage extends BasePage {
    public static final String PRODUCT_PAGE_TEXT = "//h1[text() = 'English Only']//ancestor::div[@class = 'section-header text-center']";
    public static final String FORMAT_DROPDOWN_LIST = "//select[@id = 'SingleOptionSelector-0']";
    public static final String HARDCOVER_OPTION = "//select[@data-index='option1']//descendant::option[text()='Hardcover']";
    public static final String QUANTITY_OPTION = "//input[@type='number'][@value = '1']";
    public static final String ADD_TO_CART_BUTTON = "//button[@id='AddToCart-product-template']";

    public boolean isVisibleListOfBooks() {
        return elementExists(PRODUCT_PAGE_TEXT);
    }

    public static void clickOnFormat() {
        clickElementByXpath(FORMAT_DROPDOWN_LIST);
    }

    public static void changeFormatToHardcover() {
        clickElementByXpath(HARDCOVER_OPTION);
    }

    public static void clickOnQuantity() {
        clickElementByXpath(QUANTITY_OPTION);
    }

    public static void clearQuantity() {
        clearTextByXpath(QUANTITY_OPTION);
    }

    public static void enterNewQuantityOfBooks() {
        sendTextToElementByXpath(QUANTITY_OPTION, "5");
    }

    public static CartPage clickOnAddToCart() {
        clickElementByXpath(ADD_TO_CART_BUTTON);
        return new CartPage();
    }
}
