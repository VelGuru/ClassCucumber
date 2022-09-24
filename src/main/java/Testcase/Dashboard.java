package Testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import PageObject.AdminPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import util.BaseTest;
import util.DriverManager;
import util.ExcelData;

public class Dashboard extends BaseTest
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
	public void validLogin() throws IOException, InterruptedException
	{
		AdminPage adminPage= new AdminPage(driver);
		/*String username=ExcelData.getCellValue("Login", 1, 0);
		adminPage.Login(username, ExcelData.getCellValue("Login", 1, 1));*/
		adminPage.Login("admin@phptravels.com", "demoadmin");
		//Assert.assertEquals(driver.getTitle(), "Dashboard");
		
		Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screen.getImage(), "PNG", new File("D:\\Booking.png"));
		Thread.sleep(2000);
	}
	
//	public void invalidLogin()
//	{
//		AdminPage adminPage= new AdminPage(driver);
//		adminPage.Login("adm@phptravels.com", "demoadmin");
//		
//		try {
//			File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshotFile, new File("D:\\image.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		adminPage.verfiyErrorMessage();
//	}
//	
//	@Test
//	public void booking()
//	{
//		AdminPage adminPage= new AdminPage(driver);
//		adminPage.Login("admin@phptravels.com", "demoadmin");
//		Reporter.log("Login succesful",true);
//		//Assert.assertEquals(driver.getTitle(), "Dashboard");
//		Reporter.log("Dashboard page displayed");
//		
//		DashboardPage dashboardPage=new DashboardPage(driver);
//		dashboardPage.clickOnBooking();
//		//Assert.assertEquals(driver.getTitle(), "All Bookings View");
//	}
}
