package testcases;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilis.VerifyInDriver;
import data.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import pages.RegisterPage;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterInvalidEmailsTest extends BaseTest {

    private RegisterPage registerPage;
    private VerifyInDriver verify;

    @BeforeEach
    void setup() {
        registerPage = new RegisterPage(driver);
        verify = new VerifyInDriver(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    //Test non passant - formats d'email non valides

    static Stream<Arguments> invalidEmails() {
        return Stream.of(
                Arguments.of("chris@", false, true),
                Arguments.of("@tof.com", false, true),
                Arguments.of("chris.com", false, true),
                Arguments.of("chris@.com", false, true),
                Arguments.of("chris@tof", false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmails")
    void testInvalidEmails(String email,
                           boolean expectedValueMissing,
                           boolean expectedTypeMismatch) {
        registerPage.navigateToPage();
        WebElement emailField = driver.findElement(By.id("input-email"));

        emailField.clear();
        emailField.sendKeys(email);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Boolean valueMissing = (Boolean) js.executeScript(
                "return arguments[0].validity.valueMissing;",
                emailField);

        Boolean typeMismatch = (Boolean) js.executeScript(
                "return arguments[0].validity.typeMismatch;",
                emailField);

        assertEquals(expectedValueMissing, valueMissing);
        assertEquals(expectedTypeMismatch, typeMismatch);
    }
}
