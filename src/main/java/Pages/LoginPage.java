package Pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_TEXT = "//h1[text() = 'Login']";
    private static final String LOGIN_PAGE_OPTION = "//a[@class = 'site-header__account']";
    public static final String SIGN_IN_BUTTON = "//input[@value = 'Sign In']";
    public static final String ERROR_MESSAGE_LOGIN = "//*[text()='Incorrect email or password.']";
    public static final String EMAIL_FIELD = "//input[@id = 'CustomerEmail']";
    public static final String PASSWORD_FIELD = "//input[@id = 'CustomerPassword']";


    public boolean isVisibleLoginPage() {
        return elementExists(LOGIN_PAGE_TEXT);
    }

    public static LoginPage openLoginPage() {
        clickElementByXpath(LOGIN_PAGE_OPTION);
        return new LoginPage();
    }

    public static void clickOnSignInButton() {
        clickElementByXpath(SIGN_IN_BUTTON);
    }

    public static WebElement verifyErrorMessageLoginPage() {
        return findElementByXpath(ERROR_MESSAGE_LOGIN);
    }

    public static void enterEmail(String emailText) {
        sendTextToElementByXpath(EMAIL_FIELD, emailText);
    }

    public static void enterPassword(String passwordText) {
        sendTextToElementByXpath(PASSWORD_FIELD, passwordText);
    }

    public static void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickOnSignInButton();
    }

}
