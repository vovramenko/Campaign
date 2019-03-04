package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath=".//img[@class= 'avatar']")
    private WebElement avatar;

    public boolean isAvatarPresent() {
//        try{
//        return avatar.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
        return actionsWithOurElements.isElementPresent(avatar);
    }
}
