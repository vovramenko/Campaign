package pages;

import io.qameta.allure.Step;
import libs.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignsPage extends ParentPage{
    WebDriver webDriver;
    WebDriverWait wait5;

    @FindBy (xpath = ".//*[@data-name='common-tab']")
    private WebElement tabCampaigns;
    @FindBy (xpath = ".//*[@class='campaigns-action-top-row']/div/button[@data-name='create-campaign-button']")
    private WebElement buttonCreateNewCampaign;
    @FindBy (xpath = ".//*[@class='campaigns-action-top-row']//*[@href ='/npm/campaigns/common/create-general']")
    private WebElement subButtonCreateGeneralCampaign;

    public CampaignsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public void clickOnTabCampaigns() {
        actionsWithOurElements.clickONElement(tabCampaigns);
    }
    @Step
    public void clickOnButtonCreateNewCampaign() {
        actionsWithOurElements.clickONElement(buttonCreateNewCampaign);
    }
    @Step
    public void clickOnSubButtonCreateGeneralCampaign() {
        actionsWithOurElements.clickONElement(subButtonCreateGeneralCampaign);
    }
    @Step
    public boolean isCampaignInList(String campaignName) {

        return  actionsWithOurElements.isElementPresent(By.xpath(".//*[text()='"+campaignName+"']"));
    }
    @Step
    public void deletingCampaignPresent(String campaignName)  {
        int counter = 0;
//        CreateGeneralPage createGeneralPage = new CreateGeneralPage(webDriver);
        while (isCampaignInList(campaignName)){
            actionsWithOurElements.isElementPresent(By.xpath(".//a[contains(text(),'"+campaignName+"')]"));
            actionsWithOurElements.clickONElement(By.xpath(".//div[@id='campaigns']//tr[.//a[contains(text(),'"+campaignName+"')]]//i [@data-name = 'actions-cell-delete-button']"));
            clickOnButtonOk();
            Utils.waitABit(1000);

            counter ++;
            if (counter > 100){
                Assert.fail("There are more than 100 spare");
            }
        }
    }
    @Step
    private void clickOnButtonOk() {
        try{
//        actionsWithOurElements.isElementPresent(By.xpath(".//main[@class='modal-body' and contains(text(),'"+campaignName+"')]"));
        actionsWithOurElements.isElementPresent(By.xpath(".//div[@class = 'modal-dialog']//button[@class ='btn btn-save']"));
        actionsWithOurElements.clickONElement(By.xpath(".//div[@class = 'modal-dialog']//button[@class ='btn btn-save']"));
        logger.info("Campain was deleted");
    }catch (Exception e){
            logger.error("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);}
    }

    @Step
    public void createGeneralCampaign(String campaignName)  {
        clickOnTabCampaigns();
        deletingCampaignPresent(campaignName);
        clickOnButtonCreateNewCampaign();
        clickOnSubButtonCreateGeneralCampaign();
    }
}
