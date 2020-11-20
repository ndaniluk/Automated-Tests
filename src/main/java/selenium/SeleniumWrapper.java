package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapper {
    private final WebDriver webDriver;
    private final Actions builder;

    public SeleniumWrapper(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.builder = new Actions(webDriver);
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    private WebElement getWebElement(Selector selector, String selectorValue) {
        waitForWebElement(selector, selectorValue);
        return webDriver.findElement(createBy(selector, selectorValue));
    }

    private void waitForWebElement(Selector selector, String selectorValue) {
        (new WebDriverWait(webDriver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(createBy(selector, selectorValue)));
    }

    private By createBy(Selector selector, String selectorValue) {
        switch (selector) {
            case XPATH:
                return By.xpath(selectorValue);
            case CLASS:
                return By.className(selectorValue);
            case TAG:
                return By.tagName(selectorValue);
            case NAME:
                return By.name(selectorValue);
            default:
                return null;
        }
    }

    public void waitForPageLoad(){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete"));
    }

    public void hover(Selector selector, String selectorValue) {
        WebElement webElement = getWebElement(selector, selectorValue);
        builder.moveToElement(webElement).perform();
    }

    public void click(Selector selector, String selectorValue) {
        WebElement webElement = getWebElement(selector, selectorValue);
        builder.click(webElement).perform();
    }

    public String getValue(Selector selector, String selectorValue) {
        WebElement webElement = getWebElement(selector, selectorValue);
        return webElement.getText();
    }

    public void inputValue(Selector selector, String selectorValue, String inputValue) {
        WebElement webElement = getWebElement(selector, selectorValue);
        webElement.sendKeys(inputValue);
    }

    public int getElementsCount(Selector selector, String selectorValue, Selector childSelector, String childSelectorValue) {
        WebElement webElement = getWebElement(selector, selectorValue);
        return webElement.findElements(createBy(childSelector, childSelectorValue)).size();
    }
}
