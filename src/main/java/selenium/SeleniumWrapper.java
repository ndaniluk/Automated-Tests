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

    private WebElement getWebElement(String xpath) {
        waitForWebElement(xpath);
        return webDriver.findElement(By.xpath(xpath));
    }

    private void waitForWebElement(String xpath) {
        (new WebDriverWait(webDriver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void hover(String xpath) {
        WebElement webElement = getWebElement(xpath);
        builder.moveToElement(webElement).perform();
    }

    public void click(String xpath) {
        WebElement webElement = getWebElement(xpath);
        builder.click(webElement).perform();
    }

    public String getValue(String xpath) {
        WebElement webElement = getWebElement(xpath);
        return webElement.getText();
    }

    public void inputValue(String xpath, String value) {
        WebElement webElement = getWebElement(xpath);
        webElement.sendKeys(value);
    }

    public int getElementsCount(String xpath) {
        WebElement webElement = getWebElement(xpath);
        return webElement.findElements(By.tagName("tr")).size();
    }
}
