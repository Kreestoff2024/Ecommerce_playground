package testcases;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ForgotPassword {
    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    //Test passant

    @Test
    public void forgotPasswordOK() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/div[2]/a")).click();
        driver.findElement(By.id("input-email")).sendKeys("chris@tof.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/button")).click();

        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
            assertEquals("An email with a confirmation link has been sent your email address.", element.getText());
        } catch (NoSuchElementException e) {
            fail("Élément introuvable dans la page");
        }
    }

    //Tests non passants - E-mail non enregistré


    @Test
    public void unknownEmail() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/div[2]/a")).click();
        driver.findElement(By.id("input-email")).sendKeys("qris@aze.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/button")).click();

        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]"));
            assertEquals("Warning: The E-Mail Address was not found in our records, please try again!", element.getText());
        } catch (NoSuchElementException e) {
            fail("Élément introuvable dans la page");
        }
    }

}
