package login;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import perentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnvalidLoginWithDataFromExcel extends ParentTest {
    String login;
    String pass;


    public UnvalidLoginWithDataFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void invalidLogin() {

        loginPage.login(login, pass);

        checkExpectedResult(
                "Avatar should not be present",
                !privatePage.isAvatarPresent());
    }
}
