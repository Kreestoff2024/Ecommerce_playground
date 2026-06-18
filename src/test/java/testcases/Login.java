package testcases;

import utilis.Verify;
import utilis.VerifyInDriver;
import data.BaseTest;
import data.LoginData;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import pages.LoginPage;
import java.util.*;


public class Login extends BaseTest {
    private LoginPage loginPage;
    private VerifyInDriver verify;

    @Before
    public void setup() {
        super.setUp();
        loginPage = new LoginPage(driver);
        verify = new VerifyInDriver(driver);
    }

    //Tests passants

    @Test
    public void allFieldsCorrect() {
        loginPage.navigateToPage();
        loginPage.fillForm();
        Verify.elementText(loginPage.getLogoutWord(), loginPage.expectedWord);
    }

    @Test
    public void logout() {
        loginPage.navigateToPage();
        loginPage.logout();
        Verify.elementText(loginPage.getAccountLogout(), loginPage.logoutMessage);
    }

    //Tests non passants - champs incorrects

    @Test
    public void wrongPassword() {
        loginPage.navigateToPage();
        loginPage.fillForm(LoginData.WrongPassword.email, LoginData.WrongPassword.password);
        Verify.elementText(loginPage.getPasswordError(), loginPage.expectedMessage1);
    }

    @Test
    public void wrongEmail() {
        loginPage.navigateToPage();
        loginPage.fillForm(LoginData.WrongEmail.email, LoginData.WrongEmail.password);
        Verify.elementText(loginPage.getEmailError(), loginPage.expectedMessage2);
    }

    //Test non passant - champs vides

    @Test
    public void emptyEmail() {
        loginPage.navigateToPage();
        loginPage.fillForm(LoginData.Empty.email, LoginData.Correct.password);
        Verify.elementText(loginPage.getEmptyError(), loginPage.emptyError);
    }

    @Test
    public void emptyPassword() {
        loginPage.navigateToPage();
        loginPage.fillForm(LoginData.Correct.email, LoginData.Empty.password);
        Verify.elementText(loginPage.getEmptyError(), loginPage.emptyError);
    }

    @Test
    public void allEmptyFields() {
        loginPage.navigateToPage();
        loginPage.fillForm(LoginData.Empty.email, LoginData.Empty.password);
        Verify.elementText(loginPage.getEmptyError(), loginPage.emptyError);
    }
}
