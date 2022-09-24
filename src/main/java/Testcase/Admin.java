package Testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AdminPage;

public class Admin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\c\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://phptravels.net/api/admin");
		
		AdminPage adminpage=new AdminPage(driver);
		adminpage.Login("admin@phptravels.com", "demoadmin");
		adminpage.getalltext();
	}
}
