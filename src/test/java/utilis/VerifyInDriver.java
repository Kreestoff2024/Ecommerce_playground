package utilis;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class VerifyInDriver {
    private final WebDriver driver;
    private final WebDriverWait longWait;
    private final WebDriverWait shortWait;

    public VerifyInDriver(WebDriver driver) {
        this.driver = driver;
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    // ✅ Vérifie que l'élément est visible
    public void elementIsPresent(By locator) {
        try {
            longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail("Element was not found: " + locator);
        }
    }

    // ✅ Vérifie que le texte exact correspond
    public void elementTextEquals(By locator, String expectedText) {
        try {
            WebElement element = longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualText = element.getText().trim().replaceAll("\\s+", " ");
            Assert.assertEquals("Text does not match for: " + locator, expectedText, actualText);
        } catch (TimeoutException e) {
            Assert.fail("Element not visible for text check: " + locator);
        }
    }

    // ✅ Vérifie que le texte contient une valeur
    public void elementTextContains(By locator, String expectedPartialText) {
        try {
            WebElement element = longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualText = element.getText().trim().replaceAll("\\s+", " ");
            Assert.assertTrue(
                    "Expected text to contain: " + expectedPartialText + " but was: " + actualText,
                    actualText.contains(expectedPartialText)
            );
        } catch (TimeoutException e) {
            Assert.fail("Element not visible for text contains check: " + locator);
        }
    }
}

