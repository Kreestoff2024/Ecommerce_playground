package pages;

import data.Globals;
import data.RegisterData;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL;
    public RegisterPage(WebDriver driver) { this.driver = driver; }

    public void fillForm(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm) {
        getScrollingMenu().click();
        getContinueButton().click();
        if (firstname != null) getFirstnameField().sendKeys(firstname);
        if (lastname != null) getLastnameField().sendKeys(lastname);
        if (email != null) getEmailField().sendKeys(email);
        if (telephone != null) getTelephoneField().sendKeys(telephone);
        if (password != null) getPasswordField().sendKeys(password);
        if (passwordConfirm != null) getPasswordConfirm().sendKeys(passwordConfirm);
        getPrivacyElement().click();
        getContinue2Button().click();
    }

    public void fillForm() {
        getScrollingMenu().click();
        getContinueButton().click();
        getFirstnameField().sendKeys(RegisterData.Correct.firstname);
        getLastnameField().sendKeys(RegisterData.Correct.lastname);
        getEmailField().sendKeys(RegisterData.Correct.email);
        getTelephoneField().sendKeys(RegisterData.Correct.telephone);
        getPasswordField().sendKeys(RegisterData.Correct.password);
        getPasswordConfirm().sendKeys(RegisterData.Correct.passwordConfirm);
        getPrivacyElement().click();
        getContinue2Button().click();
    }

    public void navigateToPage(){ driver.navigate().to(url);}

    private WebElement getScrollingMenu() {return driver.findElement(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span")); }
    private WebElement getContinueButton() {return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a"));}
    private WebElement getFirstnameField() {return driver.findElement(By.id("input-firstname"));}
    private WebElement getLastnameField() {return driver.findElement(By.id("input-lastname"));}
    private WebElement getEmailField() {return driver.findElement(By.id("input-email"));}
    private WebElement getTelephoneField() {return driver.findElement(By.id("input-telephone"));}
    private WebElement getPasswordField() {return driver.findElement(By.id("input-password"));}
    private WebElement getPasswordConfirm() {return driver.findElement(By.id("input-confirm"));}
    private WebElement getPrivacyElement() {return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/div/label"));}
    private WebElement getContinue2Button() {return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input"));}

    public WebElement getAccountCreated() {return driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));}
    public String expectedMessage = "Your Account Has Been Created!";

    public WebElement getBlankFirstname() {return driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div"));}
    public String expectedMissingFirstname = "First Name must be between 1 and 32 characters!";
}
