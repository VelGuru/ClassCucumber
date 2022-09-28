package PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class AdminPage 
{
	
	@FindBy(name="email")
	private WebElement txtUsername;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='card-text']")
	private List<WebElement> alltext;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement errorMessage;
	
	public AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String username,String password)
	{
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
		
	}
	
	public void getalltext()
	{
		System.out.println(alltext.size());
	}
	
	public void verfiyErrorMessage()
	{
		Assert.assertEquals(errorMessage.getText(), "Invalid Login Credentials");
	}
}
