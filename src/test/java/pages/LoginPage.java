package pages;

import data.Globals;
import data.LoginData;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    public static String url = Globals.BASE_URL;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void fillForm(String email, String password) {
        getScrollingMenu().click();
        if (email != null) getEmailField().sendKeys(email);
        if (password != null) getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    public void fillForm() {
        getScrollingMenu().click();
        getEmailField().sendKeys(LoginData.Correct.email);
        getPasswordField().sendKeys(LoginData.Correct.password);
        getLoginButton().click();
    }

    public void logout() {
        getScrollingMenu().click();
        getEmailField().sendKeys(LoginData.Correct.email);
        getPasswordField().sendKeys(LoginData.Correct.password);
        getLoginButton().click();
        getLogoutButton().click();
    }

    public void navigateToPage(){ driver.navigate().to(url);}

    private WebElement getScrollingMenu() {return driver.findElement(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span")); }
    private WebElement getEmailField() {return driver.findElement(By.id("input-email")); }
    private WebElement getPasswordField() {return driver.findElement(By.id("input-password")); }
    private WebElement getLoginButton() {return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input"));}
    private WebElement getLogoutButton() {return driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[14]"));}

    public WebElement getLogoutWord() {return driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[14]"));}
    public String expectedWord = "Logout";

    public WebElement getAccountLogout() {return driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));}
    public String logoutMessage = "Account Logout";

    public WebElement getPasswordError() {return driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));}
    public String expectedMessage1 = "Warning: No match for E-Mail Address and/or Password.";

    public WebElement getEmailError() {return driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));}
    public String expectedMessage2 = "Warning: No match for E-Mail Address and/or Password.";

    public WebElement getEmptyError() {return driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));}
    public String emptyError = "Warning: No match for E-Mail Address and/or Password.";

}
