package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ExcelDriver;
import org.junit.Test;
import perentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithDataFromExcel extends ParentTest {
    @Issue("1")  //bug number
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void valideLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPage.enterTextInToInputPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar is not present",
                privatePage.isAvatarPresent())
        ;
    }
}
