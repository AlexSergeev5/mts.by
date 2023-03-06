import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTestUpdate {

    WebDriver driver = new ChromeDriver();
    String telephoneNumber = "291032519";
    String amount = "111.22";
    String email = "test@test.ru";
    @Test
    public void open() {
        WebDriverManager.chromedriver().setup();

        driver.get("https://www.mts.by/");
        driver.findElement(By.id("connection-phone")).sendKeys(telephoneNumber);
        driver.findElement(By.id("connection-sum")).sendKeys(amount);
        driver.findElement(By.id("connection-email")).sendKeys(email);
        driver.findElement(By.id("cookie-agree")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}