package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static org.openqa.selenium.By.xpath;

public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "email")
    private WebElement inputEmail;

    @FindBy (name = "password")
    private WebElement inputPass;

    @FindBy (xpath = (".//button[@type = 'submit']"))
    private WebElement button;

    public void openPage() {
        try {
            webDriver.get("http://bahnhof-backend.dev02.st/login");
            System.out.println("Lofin page was opened");
        }catch (Exception e){
            System.out.println("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    public void enterTextInToInputLogin(String login) {
//        try{
//            inputEmail.clear();
//            inputEmail.sendKeys(login);
//            System.out.println(login + "was input");
//        }catch (Exception e){
//            System.out.println("Can not work element" + e);
//            Assert.fail("Can not work element" + e);
//        }
        actionsWithOurElements.enterTextInToElement(inputEmail, login);
    }
    public void enterTextInToInputPass(String pass) {
//        try{
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            System.out.println(pass + "was input");
//        }catch (Exception e){
//            System.out.println("Can not work element" + e);
//            Assert.fail("Can not work element" + e);
//        }
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }
    public void clickOnButtonSubmit(){
//        try{
//            button.click();
//            System.out.println("Button Submit was clicked");
//
//        }catch (Exception e){
//            System.out.println("Can not work element" + e);
//            Assert.fail("Can not work element" + e);
//        }
        actionsWithOurElements.clickONElement(button);
    }
}
