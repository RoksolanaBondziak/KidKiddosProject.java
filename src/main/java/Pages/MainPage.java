package Pages;

import Consts.Consts;

public class MainPage extends BasePage {

    public static final String BOOKS_BY_LANGUAGE_LIST = "//a[@aria-controls = 'SiteNavLabel-books-by-language']";
    public static final String ENGLISH_ONLY_OPTION = "//div[@id='SiteNavLabel-books-by-language']//descendant::a[text()='English Only']";

    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public BooksResultPage clickOnLanguageDropdownList() {
        clickElementByXpath(BOOKS_BY_LANGUAGE_LIST);
        return new BooksResultPage();
    }

    public void clickOnEnglishOnlyTag() {
        clickElementByXpath(ENGLISH_ONLY_OPTION);
    }


}
