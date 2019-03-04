package login;

import org.junit.Test;
import perentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void valideLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("admin@kntele.com");
        loginPage.enterTextInToInputPass("kntelecom");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar is not present",
                homePage.isAvatarPresent())
        ;
    }
    @Test
    public  void  invalidLogin(){
        loginPage.login("xxxx", "kntelecom");
        checkExpectedResult("Avatar shold not present",
                !homePage.isAvatarPresent());
    }
}
