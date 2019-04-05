package login;

import org.junit.Test;
import perentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void valideLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("test.kntelecom@gmail.com");
        loginPage.enterTextInToInputPass("ergrteh65ytqrwert");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar is not present",
                privatePage.isAvatarPresent())
        ;
    }
//    @Test
//    public  void  invalidLogin(){
//        loginPage.login("xxxx", "kntelecom");
//                checkExpectedResult("Avatar shold not present",
//                !privatePage.isAvatarPresent());
//
//    }
//    @Test
//    public  void  invalidPass(){
//        loginPage.login("test.kntelecom@gmail.com", "1");
//        loginPage.checkError();
//        checkExpectedResult("Avatar shold not present",
//                !privatePage.isAvatarPresent());
//
//    }
}
