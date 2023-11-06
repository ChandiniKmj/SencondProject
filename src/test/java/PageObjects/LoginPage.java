package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="mat-input-1")
	WebElement email;
	@FindBy(xpath="//span[normalize-space()='Login with password']")
	WebElement passbutton;
	@FindBy(id="mat-input-4")
	WebElement textpass;
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginbutton;
	public void setemail(String ename)
	{
		
		email.sendKeys(ename);
	}
	public void setpassbutton()
	{
		
		passbutton.click();
	}
	public void setpassword(String pass)

	{
		
		textpass.sendKeys(pass);
	}
	public void setlogin()

	{
		loginbutton.click();
	}
}