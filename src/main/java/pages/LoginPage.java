package pages;

import io.qameta.allure.Step;
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

    @FindBy (xpath = ".//button[@type = 'submit']")
    private WebElement button;
    @FindBy (xpath = ".//div[@class='alert alert-danger']")
    private  WebElement InvalidCredentials;

    @Step
    public void openPage() {
        try {
            webDriver.get("http://bahnhof-backend.dev02.st/login");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }
    @Step
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
    @Step
    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }
    @Step
    public void clickOnButtonSubmit(){
        actionsWithOurElements.clickONElement(button);
    }
    @Step
    public void login(String login, String password) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(password);
        clickOnButtonSubmit();
    }
    public void checkError (){
        actionsWithOurElements.isElementPresent(InvalidCredentials);
    }


}
