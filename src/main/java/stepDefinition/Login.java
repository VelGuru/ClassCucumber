package stepDefinition;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import PageObject.AdminPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	public void preCondition()
	{
		String broswerName=DriverManager.getProperty("broswer");
		driver = DriverManager.broswerType(broswerName); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://phptravels.net/api/admin");
	}
	
	@After
	public void postCondition()
	{
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
}
