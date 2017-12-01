import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(id = "contact-link")
    WebElement contactList;
    @FindBy(css = ".login")
    WebElement login;
    @FindBy(css = ".logout")
    WebElement logout;

    public void goTo(WebElement webElement)
    {
        webElement.click();
    }

}