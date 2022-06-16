import Pages.*;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }


    @Test
    public void loginPageTest() {
        logger.info("Login page test with empty email and password fields");
        LoginPage loginPage = LoginPage.openLoginPage();
        boolean isLoginPageLoaded = loginPage.isVisibleLoginPage();
        assertTrue(isLoginPageLoaded);
        LoginPage.clickOnSignInButton();
        WebElement error = LoginPage.verifyErrorMessageLoginPage();
        assertNotNull(error);
    }

    @Test
    public void loginPageTestInvalidCredits() {
        logger.info("Login page test with invalid credentials");
        LoginPage loginPage = LoginPage.openLoginPage();
        boolean isLoginPageLoaded = loginPage.isVisibleLoginPage();
        assertTrue(isLoginPageLoaded);
        LoginPage.login("T12345@gmail.com","12345ttt" );
        LoginPage.clickOnSignInButton();
        WebElement error = LoginPage.verifyErrorMessageLoginPage();
        assertNotNull(error);
    }

    @Test
    public void EnglishBooksTest() {
        logger.info("Testing adding the English book into the cart,changing the format and changing the quantity");
        BooksResultPage booksResultPage = mainPage.clickOnLanguageDropdownList();
        mainPage.clickOnEnglishOnlyTag();
        boolean isListOfBooksLoaded = booksResultPage.isVisibleListOfBooks();
        assertTrue(isListOfBooksLoaded);
        ProductPage productPage = ProductPage.pickTheBook();
        boolean isProductPageLoaded = productPage.isVisibleProductPage();
        assertTrue(isProductPageLoaded);
        BooksResultPage.clickOnFormat();
        BooksResultPage.changeFormatToHardcover();
        BooksResultPage.clickOnQuantity();
        BooksResultPage.clearQuantity();
        BooksResultPage.enterNewQuantityOfBooks();
        CartPage cartPage = BooksResultPage.clickOnAddToCart();
        boolean isCartLoaded = cartPage.isVisibleCartPage();
        assertTrue(isCartLoaded);
        String priceForOneBook = CartPage.verifyPriceForOneBook();
        assertEquals("31.99", priceForOneBook);
        String priceForFiveBooks = CartPage.verifyPriceForFiveBooks();
        String sumForFiveBooks = String.valueOf(31.99 * 5);
        assertEquals(sumForFiveBooks, priceForFiveBooks);
        CartPage.clearQuantityInCart();
        CartPage.enterQuantityOfBooksInCart();
        CartPage.clickOnUpdate();
        String quantity = CartPage.verifyQuantityIsSix();
        assertEquals("6", quantity);
        String priceForSixBooks = CartPage.verifyPriceForSixBooks();
        String sumForSix = String.valueOf(31.99 * 6);
        assertEquals(sumForSix, priceForSixBooks);

    }
}
