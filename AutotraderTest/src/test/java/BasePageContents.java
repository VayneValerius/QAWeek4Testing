import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePageContents {

    @FindBy(css = ".header__logo > svg:nth-child(1)")
    private WebElement autoTraderLogo;
    @FindBy (css = "li.header__nav-listing:nth-child(1) > a:nth-child(1)")
    private WebElement buyingNewAndUsed;
    @FindBy (css = "li.header__nav-listing:nth-child(2) > a:nth-child(1)")
    private WebElement sellYourCar;
    @FindBy (css = "li.header__nav-listing:nth-child(3) > a:nth-child(1)")
    private WebElement carReviewsAndMore;
    @FindBy (css = "li.header__nav-listing:nth-child(4) > a:nth-child(1)")
    private WebElement financeInsuranceAndMore;
    @FindBy (css = "a.c-btn--primary")
    private WebElement signIn;
    @FindBy (id = ".other-vehicles__item--active")
    private WebElement cars;
    @FindBy (id = ".other-vehicles__list > li:nth-child(2) > a:nth-child(1)")
    private WebElement prestigeCars;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
    private WebElement vans;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")
    private WebElement bikes;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")
    private WebElement motorhomes;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")
    private WebElement caravans;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(7) > a:nth-child(1)")
    private WebElement trucks;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(8) > a:nth-child(1)")
    private WebElement farm;
    @FindBy (id = ".site-header__other-vehicles > ul:nth-child(1) > li:nth-child(9) > a:nth-child(1)")
    private WebElement plant;
    @FindBy (id = ".site-header__other-links > li:nth-child(1) > a:nth-child(1)")
    private WebElement safteyAdvice;

    public void goTo(WebElement webElement)
    {
        webElement.click();
    }
}
