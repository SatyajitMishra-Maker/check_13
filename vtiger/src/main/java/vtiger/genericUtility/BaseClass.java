package vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import vtiger.pomClasses.HomePage;
import vtiger.pomClasses.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
	}
	public WebDriver driver;
	public ExcelUtility eUtil=new ExcelUtility();
	public FileUtility fUtil=new FileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public static WebDriver sdriver;
	public HomePage homePage;

	@BeforeSuite(groups = {"SmokeTest" , "RegressionTest"})
	public void configBt()
	{
		//connect to database
	}

	@BeforeTest(groups = {"SmokeTest" , "RegressionTest"})
	public void conifgTb()
	{
		//Parallel execution
	}
	@BeforeClass(groups = {"SmokeTest" , "RegressionTest"})
	public void openBrowser() throws Throwable
	{
		String browser=fUtil.getDataFromProperty("browser");

		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		wUtil.waitUntilPageLoad(driver);

	}
	@BeforeMethod(groups = {"SmokeTest" , "RegressionTest"})
	public void login() throws Throwable
	{
		driver.get(fUtil.getDataFromProperty("url"));
		String username = fUtil.getDataFromProperty("un");
		String password = fUtil.getDataFromProperty("pwd");
		//login to application
		LoginPage loginPage=new LoginPage(driver);
		homePage=loginPage.login(username, password);
	}
	@AfterMethod(groups = {"SmokeTest" , "RegressionTest"})
	public void logout() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.signout();
	}
	@AfterClass(groups = {"SmokeTest" , "RegressionTest"})
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterTest(groups = {"SmokeTest" , "RegressionTest"})
	public void configAt()
	{
		//Closing browser parallel	
	}
	@AfterSuite(groups = {"SmokeTest" , "RegressionTest"})
	public void configAs()
	{
		//Disconnecting Database
	}

}
