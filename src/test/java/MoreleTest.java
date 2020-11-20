import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.SeleniumWrapper;

import java.util.concurrent.TimeUnit;

public class MoreleTest {
    private SeleniumWrapper sw;

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
        sw.hover("/html/body/header/div[2]/div/div/div/nav[1]/div[2]/div[2]/div[1]/ul/li[1]/a");

        System.out.println("Clicking \"Laptops\" category");
        sw.click("/html/body/header/div[2]/div/div/div/nav[1]/div[2]/div[2]/div[1]/ul/li[1]/div/div[3]/ul[1]/li[1]/ul/li[1]/a");

        System.out.println("Adding a laptop to the basket");
        sw.click("/html/body/main/div/div/div[2]/div[1]/div[6]/div[1]/div[1]/div/div[2]/div[2]/div[6]/a");

        System.out.println("Clicking anywhere on the site to get rid of \"Additional warranty\" popup");
        sw.click("/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[1]/form/div/input");

        System.out.println("Moving to the basket");
        sw.click("/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a");

        System.out.println("Checking the basket value");
        String value = sw.getValue("/html/body/header/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a/span");
        Assertions.assertNotEquals(value, "0,00 zł");
    }

    @Test
    public void addAlarmCenowyToBasket() {
        System.out.println("Copying a promo code");
        String promoCode = sw.getValue("/html/body/main/div/div[4]/div[1]/div[2]/div/div/div[3]/div[1]/div[1]");

        System.out.println("Getting promo price");
        String expectedPrice = sw.getValue("/html/body/main/div/div[4]/div[1]/div[2]/div/div/div[1]/div/div[1]/div[2]");

        System.out.println("Adding an item from \"Alarm Cenowy\" to basket");
        sw.click("/html/body/main/div/div[4]/div[1]/div[2]/div/div/div[3]/div[2]/a");

        System.out.println("Click \"Add promo code\" button");
        sw.click("/html/body/div[3]/main/div/div[3]/aside/div[3]/div[1]");

        System.out.println("Input promo code and click \"Add\"");
        sw.click("/html/body/div[3]/main/div/div[3]/aside/div[3]/div[2]/input");
        sw.inputValue("/html/body/div[3]/main/div/div[3]/aside/div[3]/div[2]/input", promoCode);
        sw.click("/html/body/div[3]/main/div/div[3]/aside/div[3]/div[2]/button");

        System.out.println("Checking the price");
        String actualPrice = sw.getValue("/html/body/div[3]/main/div/div[3]/aside/div[2]/div[3]/div[2]/div/b");
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
}
