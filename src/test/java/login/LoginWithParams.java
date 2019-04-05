package login;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import perentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithParams extends ParentTest {
    String login;
    String pass;

    public LoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"test.kntelecom@gmail.com","ergrteh65ytqrwert1"},
                {"test.kntelecom@gmail.com1","ergrteh65ytqrwert"},
                {"1","1"}
        });
    }

    @Test
    public void unvalidLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(login);
        loginPage.enterTextInToInputPass(pass);
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar shpud not be present", !privatePage.isAvatarPresent());

    }
}
