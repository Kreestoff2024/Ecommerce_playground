package utilis;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Verify {
    public static void elementText(WebElement element, String expectedText){
        Assert.assertEquals(element.getText(), expectedText);
    }
}
