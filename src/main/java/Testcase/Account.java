package Testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PageObject.AdminPage;
import util.BaseTest;

public class Account extends BaseTest
{

	/*public void AcountDetails()
	{
		AdminPage adminPage= new AdminPage(driver);
		adminPage.Login("admin@phptravels.com", "demoadmin");
	
		//Assert.assertEquals(driver.getTitle(), "Dashboard");
	
		
		driver.findElement(By.xpath("//*[@id='drawerAccordion']/div/div/a[6]")).click();
		driver.findElement(By.xpath("//div[@id='collapseLayouts']/nav/a[1]")).click();
	
		driver.findElement(By.xpath("//form[@class='add_button']")).click();
		driver.findElement(By.name("fname")).sendKeys("sneha");
		driver.findElement(By.name("lname")).sendKeys("k");
		driver.findElement(By.name("email")).sendKeys("snehaks@gmail.com");
		driver.findElement(By.name("password")).sendKeys("snehaks");
		driver.findElement(By.name("mobile")).sendKeys("9656280980");
		
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(1);
		
		driver.findElement(By.xpath("//div[text()='Add']//following::label[normalize-space(text())='Cars'][1]")).click();
		
		List<WebElement> ele=driver.findElements(By.xpath("//label[normalize-space(text())='Tours']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		for(WebElement e:ele)
		{
		executor.executeScript("arguments[0].click();", e);
		}
	}*/
}
