package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test
            public  void validLogIn() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    webDriver.get("http://bahnhof-backend.dev02.st/login");
        System.out.println("Site was opened");

        webDriver.findElement(By.name("email")).sendKeys("admin@kntele.com");
        webDriver.findElement(By.name("password")).sendKeys("kntelecom");
        webDriver.findElement(By.xpath(".//button[@type = 'submit']")).click();

        Assert.assertTrue("Avatar is not present", webDriver.findElement(By.xpath(".//img[@class= 'avatar']")).isDisplayed());
        webDriver.quit();
    }
}
