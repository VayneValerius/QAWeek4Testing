import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageContent {
    @FindBy(css = "#menu-item-140 > a:nth-child(1)")
    WebElement draggablePageButton;
    @FindBy(css ="#menu-item-142 > a:nth-child(1)")
    WebElement selectablePageButton;
    @FindBy(css = "#menu-item-151 > a:nth-child(1)")
    WebElement sortablePageButton;
    @FindBy(css = "#menu-item-99 > a:nth-child(1)")
    WebElement tooltipPageButton;
    @FindBy(css = "#menu-item-97 > a:nth-child(1)")
    WebElement sliderPageButton;
    @FindBy(css = "#menu-item-146 > a:nth-child(1)")
    WebElement datepickerPageButton;

    public void goToDraggable()
    {
        draggablePageButton.click();
    }

    public void goToSelectable()
    {
        selectablePageButton.click();
    }

    public void goToSortable()
    {
        sortablePageButton.click();
    }

    public void goToTooltip()
    {
        tooltipPageButton.click();
    }

    public void goToSlider()
    {
        sliderPageButton.click();
    }

    public void goToDatepicker()
    {
        datepickerPageButton.click();
    }

    public String getCurrentPage(WebDriver webDriver)
    {
        return webDriver.getCurrentUrl();
    }
}
