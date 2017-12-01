import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;


public class AccountsPage {

    String lastEmailSetup = "";

    @FindBy (id = "email_create")
    private WebElement emailFieldCreate;
    @FindBy (id = "email")
    private WebElement emailLogin;
    @FindBy (id = "passwd")
    private WebElement passwordField;
    @FindBy (id = "SubmitCreate")
    private WebElement submitNewAccountButton;
    @FindBy (id = "SubmitLogin")
    private WebElement submitLoginButton;
    @FindBy (css = "#id_gender1")
    private WebElement genderOptionMr;
    @FindBy (css = "#id_gender2")
    private WebElement genderOptionMrs;
    @FindBy (id = "customer_firstname")
    private WebElement firstName;
    @FindBy (id = "customer_lastname")
    private WebElement lastName;
    @FindBy (id = "days")
    private WebElement dobDays;
    @FindBy (id = "months")
    private WebElement dobMonths;
    @FindBy (id = "years")
    private WebElement dobYears;
    @FindBy (id = "newsletter")
    private WebElement newsletterTickBox;
    @FindBy (id = "optin")
    private WebElement specialOffersTickBox;
    @FindBy (id = "firstname")
    private WebElement addressFirstName;
    @FindBy (id = "lastname")
    private WebElement addressLastName;
    @FindBy (id = "company")
    private WebElement companyName;
    @FindBy (id = "address1")
    private WebElement addressLine1;
    @FindBy (id = "address2")
    private WebElement addressLine2;
    @FindBy (id = "city")
    private WebElement addressLineCity;
    @FindBy (id = "id_state")
    private WebElement stateDropDownBox;
    @FindBy (id = "postcode")
    private WebElement postcodeField;
    @FindBy (id = "id_country")
    private WebElement countryDropDownBox;
    @FindBy (id = "other")
    private WebElement additionalInfo;
    @FindBy (id = "phone")
    private WebElement homePhoneField;
    @FindBy (id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy (id = "alias")
    private WebElement addressAlias;
    @FindBy (id = "submitAccount")
    private WebElement submitAccountButton;

    private void enterNewEmail(String email)
    {
        emailFieldCreate.sendKeys(email);
        submitNewAccountButton.click();
    }

    public void enterLogin (String email, String password)
    {
        emailLogin.sendKeys(email);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    private void enterGender (boolean isMale)
    {
        if (isMale)
        {
            genderOptionMr.click();
        }
        else
        {
            genderOptionMrs.click();
        }
    }

    private void enterName (String firstname, String secondname)
    {
        firstName.sendKeys(firstname);
        lastName.sendKeys(secondname);
        addressFirstName.sendKeys(firstname);
        addressLastName.sendKeys(secondname);
    }

    private void enterPassword (String password)
    {
        passwordField.sendKeys(password);
    }

    private void enterDOB (String optionDay, String optionMonth, String optionYear)
    {
        Select selectDay = new Select(dobDays);
        selectDay.selectByValue(optionDay);
        Select selectMonth = new Select(dobMonths);
        selectMonth.selectByValue(optionMonth);
        Select selectYear = new Select(dobYears);
        selectYear.selectByValue(optionYear);
    }

    private void enterOptional(Boolean optNewsletter, Boolean optSpecialOffers)
    {
        if (optNewsletter) { newsletterTickBox.click(); }
        else { }
        if (optSpecialOffers) { }
        else { specialOffersTickBox.click(); }
    }

    private void enterCompany(String company)
    {
        companyName.sendKeys(company);
    }

    private void enterAddress(String address, String address2, String city, String postcode)
    {
        addressLine1.sendKeys(address);
        addressLine2.sendKeys(address2);
        addressLineCity.sendKeys(city);
        postcodeField.sendKeys(postcode);
    }

    private void enterStateAndCountry(String state, String country)
    {
        Select stateSelect = new Select(stateDropDownBox);
        stateSelect.selectByVisibleText(state);
        Select countrySelect = new Select(countryDropDownBox);
        countrySelect.selectByVisibleText(country);
    }

    private void enterAdditionalInfo(String info)
    {
        additionalInfo.sendKeys(info);
    }

    private void enterPhoneNumbers(String home, String mobile)
    {
        homePhoneField.sendKeys(home);
        mobilePhoneField.sendKeys(mobile);
    }

    private void enterAddressAlias(String alias)
    {
        addressAlias.sendKeys(alias);
    }


    public void createAnAccount(WebDriver webDriver)
    {
        Random rand = new Random();
        int emailNumbers = rand.nextInt(20000);
        lastEmailSetup = "HawkeyePierce" + emailNumbers +"@gmail.com";
        enterNewEmail(lastEmailSetup);
        //webDriver.navigate().refresh();
        try {                                       // Replace this with a FluentWait when possible ---> DO NOT REMOVE
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterGender(true);
        enterName("Benjamin", "Pierce");
        enterPassword("Hawkeye");
        enterDOB("1","3","1919");
        enterOptional(true, true);
        enterAddress("21 Main Street", "", "Crabapple Cove", "04009");
        enterCompany("M*A*S*H 4077th");
        enterStateAndCountry("Maine", "United States");
        enterAdditionalInfo("");
        enterPhoneNumbers("01086 112345","07740498121");
        enterAddressAlias("Korea, Somewhere");
        submitAccountButton.click();
    }

    public void loginToExistingAccount(WebDriver webDriver, String email, String password)
    {
        enterLogin(email, password);
    }
}
