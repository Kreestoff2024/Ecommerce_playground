package utilis;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Verify {
    public static void elementText(WebElement element, String expectedText){
        Assertions.assertEquals(element.getText(), expectedText);
    }
}
