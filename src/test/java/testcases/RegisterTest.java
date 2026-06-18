package testcases;

import utilis.Verify;
import utilis.VerifyInDriver;
import data.BaseTest;
import data.RegisterData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import pages.RegisterPage;

public class RegisterTest extends  BaseTest {

    private RegisterPage registerPage;
    private VerifyInDriver verify;

    @BeforeEach
    void setup() {
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

    @Test
    public void emptyLastname() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Correct.firstname, RegisterData.Empty.lastname, RegisterData.Correct.email, RegisterData.Correct.telephone, RegisterData.Correct.password, RegisterData.Correct.passwordConfirm);
        Verify.elementText(registerPage.getBlankLastname(),registerPage.expectedMissingLastname);
    }

    @Test
    public void emptyEmail() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Correct.firstname, RegisterData.Correct.lastname, RegisterData.Empty.email, RegisterData.Correct.telephone, RegisterData.Correct.password, RegisterData.Correct.passwordConfirm);
        Verify.elementText(registerPage.getBlankEmail(),registerPage.expectedMissingEmail);
    }

    @Test
    public void emptyTelephone() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Correct.firstname, RegisterData.Correct.lastname, RegisterData.Correct.email, RegisterData.Empty.telephone, RegisterData.Correct.password, RegisterData.Correct.passwordConfirm);
        Verify.elementText(registerPage.getBlankTelephone(),registerPage.expectedMissingTelephone);
    }

    @Test
    public void emptyPassword() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Correct.firstname, RegisterData.Correct.lastname, RegisterData.Correct.email, RegisterData.Correct.telephone, RegisterData.Empty.password, RegisterData.Correct.passwordConfirm);
        Verify.elementText(registerPage.getBlankPassword(),registerPage.expectedMissingPassword);
    }

    @Test
    public void emptyConfirmPassword() {
        registerPage.navigateToPage();
        registerPage.fillForm(RegisterData.Correct.firstname, RegisterData.Correct.lastname, RegisterData.Correct.email, RegisterData.Correct.telephone, RegisterData.Correct.password, RegisterData.Empty.passwordConfirm);
        Verify.elementText(registerPage.getBlankConfirmPassword(),registerPage.expectedMissingConfirmPassword);
    }

}
