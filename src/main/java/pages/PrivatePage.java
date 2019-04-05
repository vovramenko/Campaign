package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivatePage extends ParentPage {
    WebDriverWait wait15, wait10;

    @FindBy(xpath = "//div[@class='dropdown d-none d-md-block']//span[@class='topbar-btn']")
    private WebElement menuTopBarButton;

    @FindBy(xpath = ".//a[@class = 'dropdown-item'][@href='http://bahnhof-backend.dev02.st/npm/campaigns']")
    private WebElement buttonNPM;

    public PrivatePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//img[@class= 'avatar']")
    private WebElement avatar;
    @Step
    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    @Step
    public void openThisPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("test.kntelecom@gmail.com", "ergrteh65ytqrwert");
        Assert.assertEquals("Avatar is not present", true, isAvatarPresent());
    }

    @Step
    public void clickOnMenuTopBarButton() {
        actionsWithOurElements.clickONElement(menuTopBarButton);
    }

    @Step
    public void clickOnButtonNPM() {
        actionsWithOurElements.clickONElement(buttonNPM);
    }

    @Step
    public void loginInToCamoaign() {
        openThisPage();
        clickOnMenuTopBarButton();
        clickOnButtonNPM();
    }

    @Step
    public void createGeneralCampaign(String campaignName, String networkName, String cityName) {
        CampaignsPage campaignsPage = new CampaignsPage(webDriver);
        CreateGeneralPage createGeneralPage = new CreateGeneralPage(webDriver);
        loginInToCamoaign();
        campaignsPage.createGeneralCampaign(campaignName);
        createGeneralPage.topInputs(campaignName);
        createGeneralPage.clickOnDDNetworks(networkName);
        createGeneralPage.clickOnDDCities(cityName);
    }
}
