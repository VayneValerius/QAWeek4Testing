import com.aventstack.extentreports.ExtentReports;
import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MainSeleniumTest {

    private String url = "http://demoqa.com/";
    private WebDriver webDriver;
    private static ExtentReports report;

    //@BeforeClass

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    String[] expectedURLList= {"http://demoqa.com/", "http://demoqa.com/draggable/", "http://demoqa.com/selectable/", "http://demoqa.com/sortable/", "http://demoqa.com/tooltip/", "http://demoqa.com/slider/", "http://demoqa.com/datepicker/"};

    @Test
    public void testGoToHome()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        ScreenShotTaker shotTaker = new ScreenShotTaker();
        webDriver.navigate().to(url);
        assertEquals("Not at the expected Page", basePage.getCurrentPage(webDriver), expectedURLList[0]);
    }

    @Test
    public void testGoToDraggable()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        DraggablePage dragPage = PageFactory.initElements(webDriver, DraggablePage.class);
        webDriver.navigate().to(url);
        basePage.goToDraggable();
        assertEquals("Not at the expected Page", expectedURLList[1], basePage.getCurrentPage(webDriver));

    }

    @Test
    public void testDraggableDefault()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        DraggablePage dragPage = PageFactory.initElements(webDriver, DraggablePage.class);
        webDriver.navigate().to(url);
        basePage.goToDraggable();
        dragPage.goToDefaultFunc();
        Point draggableBoxInitialLoc = dragPage.draggableBox.getLocation();
        dragPage.useDefaultFunc(webDriver);
        assertNotEquals("The box is not where it should be", draggableBoxInitialLoc, dragPage.draggableBox.getLocation());
        assertEquals("The box has not moved the amount it should have in the X (X+100)", draggableBoxInitialLoc.getX() + 100, dragPage.draggableBox.getLocation().getX() );
        assertEquals("The box has not moved the amount it should have in the Y (Y+100)", draggableBoxInitialLoc.getY() + 100, dragPage.draggableBox.getLocation().getY() );
        dragPage.goToConstraint();
        dragPage.useConstraintFuncDragHorizontal(webDriver);
        dragPage.useConstraintFuncDragVertical(webDriver);
        dragPage.useConstraintFuncDragContained(webDriver);
        dragPage.useConstraintFuncDragParentContained(webDriver);

        dragPage.goToCursorStyle();
        dragPage.useCursorDrag1(webDriver);
        dragPage.useCursorDrag2(webDriver);
        dragPage.useCursorDrag3(webDriver);
        dragPage.goToEvents();
        dragPage.useDragEvent(webDriver);
    }

    @Test
    public void testGoToSelectable()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        webDriver.navigate().to(url);
        basePage.goToSelectable();
        assertEquals("Not at the expected Page", expectedURLList[2], basePage.getCurrentPage(webDriver));
    }

    @Test
    public void testGoToSortable()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        webDriver.navigate().to(url);
        basePage.goToSortable();
        assertEquals("Not at the expected Page", expectedURLList[3], basePage.getCurrentPage(webDriver));
    }

    @Test
    public void testGoToTooltip()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        webDriver.navigate().to(url);
        basePage.goToTooltip();
        assertEquals("Not at the expected Page", expectedURLList[4], basePage.getCurrentPage(webDriver));
    }

    @Test
    public void testGoToSlider()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        webDriver.navigate().to(url);
        basePage.goToSlider();
        assertEquals("Not at the expected Page", expectedURLList[5], basePage.getCurrentPage(webDriver));
    }

    @Test
    public void testGoToDatePicker()
    {
        BasePageContent basePage = PageFactory.initElements(webDriver, BasePageContent.class);
        webDriver.navigate().to(url);
        basePage.goToDatepicker();
        assertEquals("Not at the expected Page", expectedURLList[6], basePage.getCurrentPage(webDriver));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    //@AfterClass

}
