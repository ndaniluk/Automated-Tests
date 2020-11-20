import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.Selector;
import selenium.SeleniumWrapper;

import java.util.concurrent.TimeUnit;

public class GralTest {
    private SeleniumWrapper sw;

    @BeforeAll
    public static void setUp() {
        //uncomment for chrome tests
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Norbert\\Downloads\\chromedriver_win32\\chromedriver.exe");

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
        driver.navigate().to("http://www.gral.pl/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        sw = new SeleniumWrapper(driver);
    }

    @AfterEach
    public void cleanAfterTest() {
        sw.closeDriver();
    }

    @Test
    public void addToAndRemoveFromBasketTest() {
        System.out.println("Move to the \"Mice and trackballs\" category");
        sw.click(Selector.XPATH, "/html/body/table[5]/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[7]/td/table/tbody/tr[17]/td");

        System.out.println("Add first product to basket");
        sw.click(Selector.XPATH, "/html/body/table[5]/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/div/form/button");

        System.out.println("Check if the product has been added");
        int elementsCount = sw.getElementsCount(Selector.XPATH, "/html/body/table[5]/tbody/tr/td[2]/form/table[1]/tbody",
                                                Selector.TAG, "tr");
        Assertions.assertEquals(elementsCount, 6);

        System.out.println("Delete the product from basket");
        sw.click(Selector.XPATH, "/html/body/table[5]/tbody/tr/td[2]/form/table[1]/tbody/tr[2]/td[9]/div/a");

        System.out.println("Check if the product has been deleted");
        elementsCount = sw.getElementsCount(Selector.XPATH, "/html/body/table[5]/tbody/tr/td[2]/form/table[1]/tbody",
                                            Selector.TAG, "tr");
        Assertions.assertEquals(elementsCount, 5);
    }
}
