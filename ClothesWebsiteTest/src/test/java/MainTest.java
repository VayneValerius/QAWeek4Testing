import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class MainTest {

    private String url = "http://automationpractice.com/index.php";
    private WebDriver webDriver;
    private String emailStorage = "";
    private static ExtentReports report;

    @BeforeClass
    public static void init() {
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
    public void createAccountTest()
    {
        ExtentTest test = report.createTest("CreateAccountTest");
        test.log(Status.INFO, "The account creation test is starting");
        BasePage basePage = PageFactory.initElements(webDriver, BasePage.class);
        AccountsPage accountsPage = PageFactory.initElements(webDriver, AccountsPage.class);
        test.log(Status.INFO, "Navigating to specified URL");
        webDriver.navigate().to(url);
        test.log(Status.PASS, "Navigated to URL");
        test.log(Status.INFO, "Navigating to Sign in page");
        basePage.goTo(basePage.login);
        test.log(Status.PASS, "Navigated to Sign in page");
        test.log(Status.INFO, "Begin Creating account");
        accountsPage.createAnAccount(webDriver);
        test.log(Status.PASS, "Account creation successful");
        test.log(Status.INFO, "Storing used email");
        emailStorage = accountsPage.lastEmailSetup;
        assertEquals("You have not created an account", "http://automationpractice.com/index.php?controller=my-account", webDriver.getCurrentUrl());
        test.log(Status.INFO, "The account creation test is ending ");
    }

    @Test
    public void testSignInAndOut()
    {
        ExtentTest test = report.createTest("SignInAndOutTest");
        test.log(Status.INFO, "The sign in and out test is starting ");
        BasePage basePage = PageFactory.initElements(webDriver, BasePage.class);
        AccountsPage accountsPage = PageFactory.initElements(webDriver, AccountsPage.class);
        test.log(Status.INFO, "Navigating to specified URL");
        webDriver.navigate().to(url);
        test.log(Status.PASS, "Navigated to URL");
        test.log(Status.INFO, "Navigating to Sign in page");
        basePage.goTo(basePage.login);
        test.log(Status.PASS, "Navigated to Sign in page");
        test.log(Status.INFO, "Begin signing in with details");
        test.log(Status.DEBUG, "Email:  (ddaaddaa@rere.com)   Password:  (dadada)");
        accountsPage.loginToExistingAccount(webDriver, "ddaaddaa@rere.com", "dadada");

        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"))
        {
            basePage.goTo(basePage.logout);
            assertEquals("This has not logged in and out correctly", "http://automationpractice.com/index.php?controller=authentication&back=my-account", webDriver.getCurrentUrl());
            test.log(Status.INFO, "The sign in and out test is ending");
        }
        else
        {
            Assert.fail("You have failed to log in");
            test.log(Status.ERROR, "The sign in and out test is not running correctly, check input data");
        }
    }

    @After
    public void tearDown()
    {
        webDriver.quit();

    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }
}
