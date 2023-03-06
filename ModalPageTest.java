import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModalPageTest extends MainTestUpdate{
    @Test
    public void openModal(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.findElement(By.cssSelector(".header__payment-amount")).getText().isEmpty();
            }
        });
        String amountInModal = driver.findElement(By.cssSelector(".header__payment-amount")).getText();
        String amountInButtonModal = driver.findElement(By.xpath("//button[@type='submit']")).getText();
        String numberInModal = driver.findElement(By.cssSelector(".header__payment-info")).getText();
        System.out.println(amountInModal);
        System.out.println(amountInButtonModal);
        System.out.println(numberInModal);
        assertTrue(amountInModal.contains(amount));
        assertTrue(amountInButtonModal.contains(amount));
        assertTrue(numberInModal.contains(telephoneNumber));
        driver.quit();
    }
}
