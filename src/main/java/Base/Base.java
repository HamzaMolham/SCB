package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    protected static WebDriver driver;
    protected FileInputStream inputStream;
    protected static Properties prop = new Properties();
    protected static SoftAssert soft;
public Base() {
    PageFactory.initElements(driver,this);
}
    @BeforeClass
    public void BeforeClass() throws IOException {
        soft = new SoftAssert();
        File propFile = new File("src/main/resources/config/config.properties");
        inputStream = new FileInputStream(propFile);
        prop.load(inputStream);
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
        }

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass

    public void afterClass(){
    driver.quit();
    }

    @BeforeSuite
    public void BeforeSuite(){
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);
    }

    @AfterSuite
    public void AfterSuite(){
        extent.flush();
    }

    @BeforeMethod
    public void BeforeMethod(Method method){
        logger = extent.createTest(method.getName());
    }

    @AfterMethod
    public void AfterMethod(Method method, ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            logger.log(Status.PASS,"TestPassed");
        } else if (result.getStatus()==ITestResult.FAILURE) {
            logger.log(Status.FAIL,"TestFailed");
        }
    }
}
