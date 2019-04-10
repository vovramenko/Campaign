package NPMTest;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ExcelDriver;
import org.junit.Test;
import perentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class AddNewCapmainWithDataFromExcel extends ParentTest {
//    final String campaignName = "testCampaign";

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewCampaignBB() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataFromCampaignName = excelDriver.getData(configProperties.CampaignName(), "campaing");
        Map dataFromNetworkCity = excelDriver.getData(configProperties.NetworkCities(),"networkscitiesData");
        privatePage.loginInToCampaign();
        campaignsPage.createGeneralCampaign(dataFromCampaignName.get("name").toString());
        createGeneralPage.topInputs(dataFromCampaignName.get("name").toString());
        createGeneralPage.clickOnDDNetworks(dataFromNetworkCity.get("network").toString());
        createGeneralPage.clickOnDDCities(dataFromNetworkCity.get("city").toString());
        createGeneralPage.clickOnSwitchBB();
        createGeneralPage.InputsInCategoryBB();
//        createGeneralPage.clickOnButtonCreateCampaign();
        checkExpectedResult("Campaign was not added",campaignsPage.isCampaignInList("name"));
    }
}
