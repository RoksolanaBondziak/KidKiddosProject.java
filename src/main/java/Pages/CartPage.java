package Pages;

public class CartPage extends BasePage {
    public static final String CART_TEXT = "//h1[text() = 'Your cart']";
    public static final String CHANGE_THE_NUMBER_OF_BOOKS = "//input[@type='number']";
    public static final String UPDATE_BUTTON = "//input[@name='update'][@class='btn btn--secondary cart__update cart__update--large small--hide']";
    public static final String PRICE_FOR_ONE_BOOK = "//span[@class = 'cbb-price-digits'][text() = '31.99']";
    public static final String PRICE_FOR_FIVE_BOOK = "//span[@class = 'cbb-price-digits'][text() = '159.95']";
    public static final String PRICE_FOR_SIX_BOOKS = "//span[@class = 'cbb-price-digits'][text() = '191.94']";

    public boolean isVisibleCartPage() {
        return elementExists(CART_TEXT);
    }

    public static void clearQuantityInCart() {
        clearTextByXpath(CHANGE_THE_NUMBER_OF_BOOKS);
    }

    public static void enterQuantityOfBooksInCart() {
        sendTextToElementByXpath(CHANGE_THE_NUMBER_OF_BOOKS, "6");
    }

    public static void clickOnUpdate() {
        clickElementByXpath(UPDATE_BUTTON);
    }

    public static String verifyQuantityIsSix() {
        return findElementByXpath(CHANGE_THE_NUMBER_OF_BOOKS).getAttribute("value");
    }

    public static String verifyPriceForOneBook() {
        return findElementByXpath(PRICE_FOR_ONE_BOOK).getText();
    }

    public static String verifyPriceForFiveBooks() {
        return findElementByXpath(PRICE_FOR_FIVE_BOOK).getText();
    }

    public static String verifyPriceForSixBooks() {
        return findElementByXpath(PRICE_FOR_SIX_BOOKS).getText();
    }
}
