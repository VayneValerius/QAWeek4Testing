import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.PendingException;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private String url = "http://autotrader.co.uk/";
    private WebDriver webDriver;
    private static ExtentReports report;

    @BeforeClass
    public static void init()
    {
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp()
    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void testSearch()
    {
        ExtentTest test = report.createTest("Search For Car Test");
        test.log(Status.INFO, "The Search for car test is starting");
        BasePageContents basePageContents = PageFactory.initElements(webDriver, BasePageContents.class);
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        test.log(Status.INFO, "Navigating to specified URL");
        webDriver.navigate().to(url);
        test.log(Status.INFO, "The search information is being written");
        test.log(Status.DEBUG, "Looking for a BMW Z4M of £0-£15000, new or close to new");
        homePage.useSearchFunction();
        //assertEquals("The search function has not worked", page numbers = 1, checkPageNumbers);
    }

    @Test
    public void createAccount()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void getValuation()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void createAdvert()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void getReviewOnMake()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void lookForLocalCarDealer()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void writeReviewForCarDealer()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void switchWebsiteVersion()
    {
        throw new PendingException("Not yet Implemented");
    }

    @Test
    public void testVehicleHistory()
    {
        throw new PendingException("Not yet Implemented");
    }
    @Test
    public void testOutsideNumberPlateService()
    {
        //throw new PendingException("Not yet Implemented");
        ExtentTest test = report.createTest("Search For Car Test");
        test.log(Status.INFO, "The Search for car test is starting");
        webDriver.navigate().to("https://www.autotrader.co.uk/private-number-plates");
        //BasePageContents basePageContents = PageFactory.initElements(webDriver, BasePageContents.class);
        PrivateNumberPlatePage privateNumberPlatePage = PageFactory.initElements(webDriver, PrivateNumberPlatePage.class);
        privateNumberPlatePage.bcrBox.sendKeys("BingoBangoBongo");
        privateNumberPlatePage.bcrSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("This hasn't gone to the correct page", "https://britishcarregistrations.co.uk/search/BINGOBANGOBONGO", webDriver.getCurrentUrl());
        webDriver.navigate().to("https://www.autotrader.co.uk/private-number-plates");
        privateNumberPlatePage.nnBox.sendKeys("DownWith");
        privateNumberPlatePage.nnSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("This hasn't gone to the correct page", "https://www.nationalnumbers.co.uk/search.php", webDriver.getCurrentUrl());
        webDriver.navigate().to("https://www.autotrader.co.uk/private-number-plates");
        privateNumberPlatePage.regtransfersBox.sendKeys("R2D2");
        privateNumberPlatePage.regtransfersSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("This hasn't gone to the correct page", "https://www.regtransfers.co.uk/search/searchresults/r2d2/0", webDriver.getCurrentUrl());



    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp()
    {
        report.flush();
    }
}
