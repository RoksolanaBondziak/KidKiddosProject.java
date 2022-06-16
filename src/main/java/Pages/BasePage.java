package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    protected static void clickElementByXpath(String xpath) {

        logger.info("Clicking element with xpath: " + xpath);
        findElementByXpath(xpath).click();
    }

    protected static void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    protected static void clearTextByXpath(String xpath) {
        findElementByXpath(xpath).clear();
    }

    protected boolean elementExists(String xpath) {
        try {
            logger.info("Check element with xpath exists: " + xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected static WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

}
