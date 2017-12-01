import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivateNumberPlatePage extends BasePageContents{

    @FindBy (name = "s")
    WebElement bcrBox;
    @FindBy (name = "search_key")
    WebElement nnBox;
    @FindBy (name = "criteria")
    WebElement regtransfersBox;
    @FindBy (css = "body > div.private-number-plates > div.js-parallax-front > section.plates-section.section-light > div > section:nth-child(2) > form > button")
    WebElement bcrSubmit;
    @FindBy (css = "body > div.private-number-plates > div.js-parallax-front > section.plates-section.section-light > div > section:nth-child(3) > form > button")
    WebElement nnSubmit;
    @FindBy (css = "body > div.private-number-plates > div.js-parallax-front > section.plates-section.section-light > div > section:nth-child(4) > form > button")
    WebElement regtransfersSubmit;
}
