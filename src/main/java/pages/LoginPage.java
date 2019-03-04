package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

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
        try{
            webDriver.findElement(By.name("email")).clear();
            webDriver.findElement(By.name("email")).sendKeys(login);
            System.out.println(login + "was input");
        }catch (Exception e){
            System.out.println("Can not work element" + e);
            Assert.fail("Can not work element" + e);
        }
    } public void enterTextInToInputPass(String pass) {
        try{
            webDriver.findElement(By.name("password")).clear();
            webDriver.findElement(By.name("password")).sendKeys(pass);
            System.out.println(pass + "was input");
        }catch (Exception e){
            System.out.println("Can not work element" + e);
            Assert.fail("Can not work element" + e);
        }
    }
    public void clickOnButtonSubmit(){
        try{
            webDriver.findElement(By.xpath(".//button[@type = 'submit']")).click();
            System.out.println("Button Submit was clicked");

        }catch (Exception e){
            System.out.println("Can not work element" + e);
            Assert.fail("Can not work element" + e);
        }
    }
}
