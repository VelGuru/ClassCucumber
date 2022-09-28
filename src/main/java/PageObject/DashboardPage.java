package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(linkText="Bookings")
	private WebElement lnk_Booking;
	
	@FindBy(partialLinkText="Accounts")
	public WebElement lnk_accounts;
	
	@FindBy(linkText="Admins")
	public WebElement lnk_Admins;
	
	@FindBy(partialLinkText="Suppliers")
	public WebElement lnk_Suppliers;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBooking()
	{
		lnk_Booking.click();
	}
	
	public void verfiyBookingPage()
	{
		
	}
}
