package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuppliersManagementPage 
{
	@FindBy(xpath="//button[contains(text(),'Add')]")
	public WebElement btn_add;
	
	@FindBy(name="fname")
	public WebElement txt_firstName;
	
	@FindBy(name="lname")
	public WebElement txt_lastName;
	
	@FindBy(name="email")
	public WebElement txt_email;
	
	@FindBy(name="password")
	public WebElement txt_password;
	
	public SuppliersManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
