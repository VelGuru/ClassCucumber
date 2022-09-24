package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(linkText="Bookings")
	private WebElement lnk_Booking;
	
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
