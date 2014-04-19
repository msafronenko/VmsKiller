import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 19.04.14
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Parameterized.class)
public class TestGoogle {
    private final String googleXpath = ".//*[@title='Google']";
    private WebDriver driver;

    private String one;
    private String two;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public TestGoogle(String one, String two){
        this.one = one;
        this.two = two;
    }

    @Before
    public void loadBrowser() {
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(profile);

        driver.get("http://www.google.com");
        driver.navigate();
    }

    @Test
    public void testGoogle(){
        WebElement element = driver.findElement(By.xpath(googleXpath));
        collector.checkThat("Google page is not load!!", element.isDisplayed(), CoreMatchers.equalTo(true));

        System.out.println("================="+this.one);

    }

    @After
    public void closeBrowser() {
        if (driver!=null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        Object[][] arr = {{"one", null}, {"two", null}};
        return Arrays.asList(arr);
    }
}
