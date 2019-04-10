package NPMTest;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Test;
import perentTest.ParentTest;

public class AddNewCampaign extends ParentTest {
    final String campaignName = "testCampaign"; // Utils.getDateAndTimeFormated();
//    String networkName;
//    String cityName;
     String networkName = "Halmstads Stadsnät";
     String cityName = "Halmstad";

     @Severity(SeverityLevel.CRITICAL)
    @Test //("creating a new campaign with bredband category")
    public void addNewCampaignBB() throws InterruptedException {
        privatePage.loginInToCampaign();
        campaignsPage.createGeneralCampaign(campaignName);
        createGeneralPage.topInputs(campaignName);
        createGeneralPage.clickOnDDNetworks(networkName);
        createGeneralPage.clickOnDDCities(cityName);
        createGeneralPage.clickOnSwitchBB();
        createGeneralPage.InputsInCategoryBB();
//        createGeneralPage.clickOnButtonCreateCampaign();
        checkExpectedResult("Campaign was not added",campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignVPN()  {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchVPN();
        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignAntivirus() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchAntivirus();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignIPtelefoni() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchIPtelefoni();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignRouter() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchRouter();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignTv() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchTv();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignCmore() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchCmore();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignViaplay() throws InterruptedException {
        privatePage.createGeneralCampaign(campaignName, networkName, cityName);
        createGeneralPage.clickOnSwitchViaplay();

        checkExpectedResult("Campaign was not added", campaignsPage.isCampaignInList(campaignName));
    }

    @After
    public void deletingCampaign() throws InterruptedException {
        campaignsPage.deletingCampaignPresent(campaignName);}
}
