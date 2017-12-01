import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DraggablePage {

    @FindBy(id = "ui-id-1")
    WebElement defaultFuncButton;
    @FindBy(id = "ui-id-2")
    WebElement constrainMoveButton;
    @FindBy(id = "ui-id-3")
    WebElement cursorStyleButton;
    @FindBy(id = "ui-id-4")
    WebElement eventsButton;
    @FindBy(id = "ui-id-5")
    WebElement draggableSortableButton;
    @FindBy(id = "draggable")
    WebElement draggableBox;
    @FindBy(id = "draggabl")
    WebElement contraintHorizontalBox;
    @FindBy(id = "draggabl2")
    WebElement contraintVerticalBox;
    @FindBy(id = "draggabl3")
    WebElement constraintContainedbox;
    @FindBy(id = "draggabl5")
    WebElement constraintContainedParentbox;
    @FindBy(id = "drag")
    WebElement cursorDrag1;
    @FindBy(id = "drag2")
    WebElement cursorDrag2;
    @FindBy(id = "drag3")
    WebElement cursorDrag3;
    @FindBy (id = "dragevent")
    WebElement dragEvent;
    @FindBy (id = "draggablebox")
    WebElement  dragMeDown;




    public void goToDefaultFunc()
    {
        defaultFuncButton.click();
    }

    public void useDefaultFunc(WebDriver webDriver) {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(draggableBox)
                .clickAndHold()
                .moveByOffset(100,
                          100)
                .release().perform();
    }
    public void useConstraintFuncDragHorizontal(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(contraintHorizontalBox)
                .clickAndHold()
                .moveByOffset(100,
                        0).release().perform();
    }
    public void useConstraintFuncDragVertical(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(contraintVerticalBox)
                .clickAndHold()
                .moveByOffset(0,
                        100).release().perform();
    }
    public void useConstraintFuncDragContained(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(constraintContainedbox)
                .clickAndHold()
                .moveByOffset(10,
                        10).release().perform();
    }
    public void useConstraintFuncDragParentContained(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(constraintContainedParentbox)
                .clickAndHold()
                .moveByOffset(10,
                        10).release().perform();
    }

    public void useCursorDrag1(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(cursorDrag1)
                .clickAndHold()
                .moveByOffset(100,
                        100).release().perform();
    }
    public void useCursorDrag2(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(cursorDrag2)
                .clickAndHold()
                .moveByOffset(100,
                        100).release().perform();
    }
    public void useCursorDrag3(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(cursorDrag3)
                .clickAndHold()
                .moveByOffset(100,
                        100).release().perform();
    }

    public void useDragEvent(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(dragEvent)
                .clickAndHold()
                .moveByOffset(100,
                        100).release().perform();
    }

    public void useDragButton(WebDriver webDriver)
    {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(dragMeDown)
                .clickAndHold()
                .moveByOffset(100,
                        100).release().perform();
    }



    public void goToConstraint()
    {
        constrainMoveButton.click();
    }
    public void goToCursorStyle()
    {
        cursorStyleButton.click();
    }
    public void goToEvents()
    {
        eventsButton.click();
    }
    public void goToDragAndSort()
    {
        draggableSortableButton.click();
    }
}
