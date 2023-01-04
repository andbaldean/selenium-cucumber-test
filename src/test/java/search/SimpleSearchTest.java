package search;

import com.google.common.annotations.VisibleForTesting;
import org.example.AppConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest {


    @Test
    public void simpleSearchWithOneKeyword() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cel.ro/");

      String searchKeyword = "vase";

        driver.findElement(By.id("keyword")).sendKeys("vase" + Keys.ENTER);

       System.out.println("Pressed Enter in search field.");

       List<WebElement> productNames = driver.findElements(By.cssSelector("div:nth-child(1)"));

      System.out.println("Stored " + productNames.size() + " product names");

       for (WebElement productName : productNames) {
          assertThat("Some of the products names do not contain the searched keyword.",
                productName.getText(), containsString(searchKeyword.toUpperCase()));


      }







    }
}
