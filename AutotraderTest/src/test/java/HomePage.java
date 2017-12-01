import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePageContents {

    @FindBy(id = "postcode")
    private WebElement searchPostcode;
    @FindBy (id = "radius")
    private WebElement searchDistance;
    @FindBy (id = "oneSearchAdUsed")
    private WebElement searchConditionUsed;
    @FindBy (id = "oneSearchAdNearlyNew")
    private WebElement searchConditionNearlyNew;
    @FindBy (id = "oneSearchAdBrandNew")
    private WebElement searchConditionNew;
    @FindBy (id = "searchVehiclesMake")
    private WebElement searchMake;
    @FindBy (id = "searchVehiclesModel")
    private WebElement searchModel;
    @FindBy (id = "searchVehiclesPriceFrom")
    private WebElement searchMinPrice;
    @FindBy (id = "searchVehiclesPriceTo")
    private WebElement searchMaxPrice;
    @FindBy (id = "js-search-button")
    private WebElement searchButton;
    @FindBy (id = "js-more-options")
    private WebElement moreSearchOptions;

    public void useSearchFunction()
    {
        searchPostcode.sendKeys("M1 5SX");
        Select distanceSelect = new Select(searchDistance);
        distanceSelect.selectByValue("1");
        searchConditionUsed.click();
        Select makeSelect = new Select(searchMake);
        makeSelect.selectByValue("BMW");
        Select modelSelect = new Select(searchModel);
        modelSelect.selectByValue("Z4M");
        Select minPriceSelect = new Select(searchMinPrice);
        minPriceSelect.selectByValue("0");
        Select maxPriceSelect = new Select(searchMaxPrice);
        maxPriceSelect.selectByValue("15000");
    }

}
