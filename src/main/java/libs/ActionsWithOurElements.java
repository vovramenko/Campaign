package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait15,wait10, wait20;

    public ActionsWithOurElements(WebDriver webDriver){

        this.webDriver = webDriver;
        wait15 = new WebDriverWait(webDriver,15);
        wait10 = new WebDriverWait(webDriver,10);
        wait20 = new WebDriverWait(webDriver,20);
    }
    public void enterTextInToElement(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }


    public void clickONElement(WebElement element) {
        try{
            wait20.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public boolean isElementPresent(WebElement webElement){
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed > " + isDisplayed);
            return isDisplayed;
        }catch (Exception e){
            logger.info("Element is displayed > false");
            return false;
        }
    }
    public void selectTextInDropDown(WebElement element, String text){
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop-down");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void selectValueInDropDown(WebElement element, String value){
        try{
            Select select = new Select(element);
            select.selectByVisibleText(value);
            logger.info(value + " was selected in drop-down");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(By xpath) {
        try{
            return isElementPresent(webDriver.findElement(xpath));
        }catch (Exception e){
            return false;
        }
    }
    public void selectValueInNewtorkDD(WebElement element, String networkName){
        try{
            element.clear();
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(networkName);
            element.sendKeys(Keys.ENTER);
            logger.info("Newtork was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
        public void selectValueInCitiesDD (WebElement element, String cityName){
        try{
            element.clear();
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(cityName);
            element.sendKeys(Keys.ENTER);
            logger.info("Cities was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }

    };

    public void clickONElement(By xpath) {
        try{
            clickONElement(webDriver.findElement(xpath));
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void setStatusToCheckBox(WebElement element, String neededState){
        if ("active-item".equals(neededState)|| "active-item error".equals(neededState)){
            try{
                if (element.isSelected() && "active-item".equals(neededState)){
                    logger.info("Already check");
                }else if (!element.isSelected() && "active-item".equals(neededState)){
                    element.click();
                    logger.info("check box checked");
                }else if (element.isSelected() && "active-item error".equals(neededState)){
                    element.click();
                    logger.info("check box deselected");

                }else if (!element.isSelected() && "active-item error".equals(neededState)){
                    logger.info("check box is already unchecked");
                }
            }catch (Exception e){
                printErrorAndStopTest(e);
            }

        }else {
            logger.error("State should be 'active-item' or 'active-item error'");
            Assert.fail("State should be 'active-item' or 'active-item error'");
        }
    }




}
