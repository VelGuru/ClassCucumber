package stepDefinition;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObject.AdminManagementPage;
import PageObject.AdminPage;
import PageObject.DashboardPage;
import PageObject.SuppliersManagementPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import util.DriverManager;

public class Login 
{
	
	public WebDriver driver;
	@Before
	public void preCondition(Scenario scenario)
	{
		String broswerName="chrome";
		driver = DriverManager.broswerType(broswerName); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://phptravels.net/api/admin");
	}
	
	@After
	public void postCondition(Scenario scenario) throws InterruptedException
	{
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.attach(screenshot, "image/png", "name");
		driver.quit();
	}
	
	@Given("Enter the valid Admin credentials")
	public void enter_the_valid_admin_credentials(DataTable table) {
		try{
			Map<String,String> data=table.asMap(String.class, String.class);
		AdminPage adminPage= new AdminPage(driver);
		//String username=ExcelData.getCellValue("Login", 1, 0);
		adminPage.Login(data.get("Username"), data.get("pwd"));
		
		//Assert.assertEquals(driver.getTitle(), "Dashboard");
		
		Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screen.getImage(), "PNG", new File("D:\\Booking.png"));
		Thread.sleep(2000);}
		catch (Exception e) {

		}
	}

	@Then("Validating the Home page")
	public void validating_the_home_page(DataTable table) {
		List<String> tables=table.asList();
	    for(String t:tables)
	    {
	    	System.out.println(t);
	    }
		Assert.assertEquals("Dashboard", driver.getTitle());
	}
	
	@Given("Enter the {string} and {string} credentials")
	public void Enter_the_username_pwd(String username,String pwd) {
	    
		try{
			AdminPage adminPage= new AdminPage(driver);
			//String username=ExcelData.getCellValue("Login", 1, 0);
			adminPage.Login(username, pwd);
			
			//Assert.assertEquals(driver.getTitle(), "Dashboard");
			
			Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
			ImageIO.write(screen.getImage(), "PNG", new File("D:\\Booking.png"));
			Thread.sleep(2000);}
			catch (Exception e) {

			}
	}
	
	@Then("Click on Account and navigate to Admin")
	public void Click_on_acooutn_admin()
	{
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.lnk_accounts.click();
		dashboardPage.lnk_Admins.click();
	}
	
	@And("Creating new Admin user")
	public void creating_new_admin()
	{
		AdminManagementPage adminManagementPage=new AdminManagementPage(driver);
		adminManagementPage.btn_add.click();
		adminManagementPage.txt_firstName.sendKeys("Sneha");
		adminManagementPage.txt_lastName.sendKeys("M");
		adminManagementPage.txt_email.sendKeys("sneha.m@gmail.com");
		adminManagementPage.txt_password.sendKeys("adsfasdfasdf");
	}
	
	@Then("Click on Account and navigate to suppliers")
	public void Click_on_acooutn_suppliers()
	{
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.lnk_accounts.click();
		dashboardPage.lnk_Suppliers.click();
	}
	
	@And("Creating new suppliers user")
	public void creating_new_suppliers()
	{
		SuppliersManagementPage suppliersManagementPage=new SuppliersManagementPage(driver);
		suppliersManagementPage.btn_add.click();
		suppliersManagementPage.txt_firstName.sendKeys("Hari");
		suppliersManagementPage.txt_lastName.sendKeys("U");
		suppliersManagementPage.txt_email.sendKeys("hari.u@gmail.com");
		suppliersManagementPage.txt_password.sendKeys("adsfasdfasdf");
		
	}
}
