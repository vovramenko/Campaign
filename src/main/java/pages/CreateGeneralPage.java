package pages;

import io.qameta.allure.Step;
import libs.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateGeneralPage extends ParentPage{

    @FindBy (xpath = ".//button[contains(@name,'create-campaign-button')]")
    private WebElement buttonCreateCampaign;
    @FindBy (xpath = ".//input[contains(@placeholder,'Campaign name')]")
    private WebElement inputCampaignName;

//    @FindBy (xpath = ".//div[@data-category-name= 'BB']//div[@class = 'b2']")
//    private WebElement switchBB;

    @FindBy (xpath = ".//div[@data-category-name= 'BB']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountBB;
    @FindBy (xpath = ".//div[@data-category-name= 'VPN']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountVPN;
    @FindBy (xpath = ".//div[@data-category-name= 'AB']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountAntivirus;
    @FindBy (xpath = ".//div[@data-category-name= 'TELEPHONY']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountIPtelefoni;
    @FindBy (xpath = ".//div[@data-category-name= 'ROUTER']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountRouter;
    @FindBy (xpath = ".//div[@data-category-name= 'BTV']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountTv;
    @FindBy (xpath = ".//div[@data-category-name= 'CMORE']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountCmore;
    @FindBy (xpath = ".//div[@data-category-name= 'VIAPLAY']//label[@data-name= 'has-discount-checkbox-invalid-feedback']")
    private WebElement checkBoxDiscountViaplay;

    @FindBy (xpath = "//div[contains(@class,'active')]//input[contains(@name,'discount-percentage')]")
    private WebElement inputPercentField;

    @FindBy (xpath = "//div[contains(@class,'active')]//input[contains(@name,'discount-period')]")
    private WebElement inputMonthField;

    @FindBy (xpath =".//div[@data-vv-name = 'networks-count']/div[@class = 'multiselect__select']") //".//*[@data-vv-name = 'networks-count']")
    private WebElement dropDownNetwork;

    @FindBy (xpath = ".//*[@data-vv-name = 'cities-count']")
    private WebElement dropDownCity;

    @FindBy (xpath = ".//*[@id= 'networks-select']")
    private WebElement inputNetworkName;

//    @FindBy (xpath = ".//*[@class= 'multiselect__option multiselect__option--highlight'][@xpath = '1']") // Halmstad
//    private WebElement firstCheckBoxCities;

    @FindBy (xpath = ".//*[@id= 'cities-select']")
    private WebElement inputCityName;

    @FindBy (xpath = ".//input[@id='campaign-start-date']")
    private WebElement buttonStartDate;

    @FindBy (xpath = ".//input[@id='campaign-end-date']")
    private WebElement buttonEndDate;

    @FindBy (xpath = ".//div[@class='flatpickr-calendar animate open arrowTop']//span[@class = 'flatpickr-day today']")
    private WebElement startDateDDType;

    @FindBy (xpath = ".//div[@class='flatpickr-calendar animate open arrowTop']//span[@aria-current='date']")    // .//div[contains(@class, 'flatpickr-calendar animate open ')]//span[@aria-current='date']")
    private WebElement endDateType;

    @FindBy (xpath = ".//button[@class ='btn btn-save' ]")
    private By buttonOk;
    @FindBy (xpath = ".//div[@data-category-name= 'BB']//div[@class = 'b2']")
    private WebElement switchBB;
//    @FindBy (xpath = ".//div[@data-category-name = 'VPN']//div[@class = 'b2']")
//    private By switchVPN;
//    @FindBy (xpath = ".//div[@data-category-name = 'AB']//div[@class = 'b2']")
//    private By switchAntivirus;
//    @FindBy (xpath = ".//div[@data-category-name = 'TELEPHONY']//div[@class = 'b2']")
//    private By switchIPtelefoni;
//    @FindBy (xpath = ".//div[@data-category-name = 'ROUTER']//div[@class = 'b2']")
//    private By switchRouter;
//    @FindBy (xpath = ".//div[@data-category-name = 'BTV']//div[@class = 'b2']")
//    private By switchTv;
//    @FindBy (xpath = ".//div[@data-category-name = 'CMORE']//div[@class = 'b2']")
//    private By switchCmore;
//    @FindBy (xpath = ".//div[@data-category-name = 'VIAPLAY']//div[@class = 'b2']")
//    private By switchViaplay;


    public CreateGeneralPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public void enterCampaignName(String campaignName) {
    actionsWithOurElements.enterTextInToElement(inputCampaignName, campaignName);
    }

    @Step
    public void chooseStartDate(String startDateType) {
        actionsWithOurElements.clickONElement(startDateDDType);
    }

    @Step
    public void chooseEndDate() {
        actionsWithOurElements.clickONElement(endDateType);
    }

    @Step
    public void clickOnDDNetworks(String networkName) {
              // нужно сделать проверку что выпадающий список подтянул данные
        actionsWithOurElements.clickONElement(dropDownNetwork);
        actionsWithOurElements.selectValueInNewtorkDD(inputNetworkName, networkName);
    }

    @Step
    public void clickOnDDCities(String cityName) {
        actionsWithOurElements.clickONElement(dropDownCity);
        actionsWithOurElements.selectValueInCitiesDD(inputCityName, cityName);
    }

    @Step
    public void enterPercentFild(String precentField) {
        actionsWithOurElements.enterTextInToElement(inputPercentField, precentField);
    }

    @Step
    public void enterMonthsField(String monthField) {
        actionsWithOurElements.enterTextInToElement(inputMonthField, monthField);
    }

    @Step
    public void clickOnButtonCreateCampaign() {
        actionsWithOurElements.clickONElement(buttonCreateCampaign);
    }

    @Step
    public void clickOnButtonStartDate() {
        actionsWithOurElements.clickONElement(buttonStartDate);
    }

    @Step
    public void clickOnButtonEndDate() {
        actionsWithOurElements.clickONElement(buttonEndDate);
    }

    @Step
    public void topInputs(String campaignName) {
        enterCampaignName(campaignName);
        clickOnButtonStartDate();
        chooseStartDate("carrent day");
        clickOnButtonEndDate();
        Utils.waitABit(500);
        chooseEndDate();
    }

    @Step
    public void InputsInCategories(){
        enterPercentFild("10");
        enterMonthsField("3");
    }

    @Step
    public void InputsInCategoryBB() {
        actionsWithOurElements.clickONElement(checkBoxDiscountBB);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchBB() {
        actionsWithOurElements.clickONElement(switchBB);
    }

    @Step
    public void weitStatusElement(){}

    @Step
    public void clickOnSwitchVPN() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(".//div[@data-category-name = 'VPN']//div[@class = 'b2']"))
                );

        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountVPN);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchAntivirus() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'AB']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountAntivirus);
        InputsInCategories();
        clickOnButtonCreateCampaign();

    }

    @Step
    public void clickOnSwitchIPtelefoni() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'TELEPHONY']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountIPtelefoni);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchRouter() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'ROUTER']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountRouter);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchTv() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'BTV']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountTv);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchCmore() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'CMORE']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountCmore);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }

    @Step
    public void clickOnSwitchViaplay() {
        WebElement checkbox = (new WebDriverWait(this.webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@data-category-name = 'VIAPLAY']//div[@class = 'b2']")));
        actionsWithOurElements.clickONElement(checkbox);
        actionsWithOurElements.clickONElement(checkBoxDiscountViaplay);
        InputsInCategories();
        clickOnButtonCreateCampaign();
    }
}
