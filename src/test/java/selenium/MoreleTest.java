package selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.Selector;
import selenium.SeleniumWrapper;

import java.util.concurrent.TimeUnit;

public class MoreleTest {
    private SeleniumWrapper sw;

    @BeforeAll
    public static void setUp() {
        //uncomment for chrome tests
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        //uncomment for firefox tests
//        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        //uncomment for edge tests
//        System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
    }

    @BeforeEach
    public void setUpTest() {
        //uncomment for chrome tests
        WebDriver driver = new ChromeDriver();

        //uncomment for firefox tests
//        WebDriver driver = new FirefoxDriver();

        //uncomment for edge tests
//        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.morele.net/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        sw = new SeleniumWrapper(driver);
    }

    @AfterEach
    public void cleanAfterTest() {
        sw.closeDriver();
    }

    @Test
    public void addToBasketTest() {
        System.out.println("Hovering over the \"Laptops\" nav option");
        sw.hover(Selector.XPATH,"/html/body/header/div[2]/div/div/div/nav[1]/div[2]/div[2]/div[1]/ul/li[1]/a");

        System.out.println("Clicking \"Laptops\" category");
        sw.click(Selector.XPATH,"/html/body/header/div[2]/div/div/div/nav[1]/div[2]/div[2]/div[1]/ul/li[1]/div/div[3]/ul[1]/li[1]/ul/li[1]/a");

        System.out.println("Adding a laptop to the basket");
        sw.click(Selector.XPATH,"/html/body/main/div/div/div[2]/div[1]/div[6]/div[1]/div[1]/div/div[2]/div[2]/div[6]/a");

        System.out.println("Clicking anywhere on the site to get rid of \"Additional warranty\" popup");
        sw.click(Selector.XPATH,"/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[1]/form/div/input");

        System.out.println("Moving to the basket");
        sw.click(Selector.XPATH,"/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a");

        System.out.println("Checking the basket value");
        String value = sw.getValue(Selector.XPATH,"/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a/span");
        Assertions.assertNotEquals(value, "0,00 zł");
    }

    @Test
    public void addAlarmCenowyToBasket() {
        System.out.println("Accepting cookies");
        sw.click(Selector.CLASS, "close-cookie-box");

        System.out.println("Copying a promo code");
        String promoCode = sw.getValue(Selector.CLASS,"promo-box-code-value");

        System.out.println("Getting promo price");
        String expectedPrice = sw.getValue(Selector.CLASS,"promo-box-new-price");

        System.out.println("Adding an item from \"Alarm Cenowy\" to basket");
        sw.click(Selector.CLASS,"promo-box-to-basket");

        System.out.println("Moving to basket");
        sw.click(Selector.CLASS, "small-basket-price");

        System.out.println("Click \"Add promo code\" button");
        sw.click(Selector.CLASS,"promo-box");

        System.out.println("Input promo code and click \"Add\"");
        sw.click(Selector.NAME,"discount");
        sw.inputValue(Selector.NAME,"discount", promoCode);
        sw.click(Selector.CLASS,"promotion-code-button");

        System.out.println("Waiting for the price to update");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Checking the price");
        String actualPrice = sw.getValue(Selector.CLASS,"summary-box-price");
        Assertions.assertEquals(expectedPrice, actualPrice.substring(0, actualPrice.indexOf("ł") + 1));
    }
}
