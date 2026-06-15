package testcases;


import utilis.Verify;
import utilis.VerifyInDriver;
import data.BaseTest;
import data.RegisterData;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.testng.Assert;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.RegisterPage;
import java.time.Duration;
import java.util.*;

public class Register extends  BaseTest {

    private RegisterPage registerPage;
    private VerifyInDriver verify;

    @Before
    public void setup() {
        super.setUp();
        registerPage = new RegisterPage(driver);
        verify = new VerifyInDriver(driver);
    }

    //Test passant

    @Test
    public void allFieldsCorrect() {
        registerPage.navigateToPage();
        registerPage.fillForm();
        Verify.elementText(registerPage.getAccountCreated(), registerPage.expectedMessage);
    }

    //Tests non passants - champs vides

    @Test
    public void emptyFirstname() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Empty.firstname, RegisterData.Correct.lastname, RegisterData.Correct.email, RegisterData.Correct.telephone, RegisterData.Correct.password, RegisterData.Correct.passwordConfirm);
        Verify.elementText(registerPage.getBlankFirstname(), registerPage.expectedMissingFirstname);
    }
}
