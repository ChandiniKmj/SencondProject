package TestCases;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC_001_Login extends BaseClass {
	@Test
	public void logintest() throws InterruptedException, IOException {
    driver.get("https://swayamsikkim.com/auth/signin");
		log.info("url is entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(1000);
	
		lp.setemail(username);
		
		log.info("email is entered");

		lp.setpassbutton();
		lp.setpassword(password);
		log.info("password is eneterd");
		lp.setlogin();
		String actual_res=driver.getTitle();
		System.out.println(actual_res);
		String exp_res="Buy the best organic products, spices, handlooms and more at reasonable prices. Order directly from producers through Swayam Sikkim.";
		if(actual_res.equals(exp_res)) {
			Assert.assertTrue(true);
			log.info("Test Case is Passed");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertFalse(true);
			log.info("Test Case is Failed");
		}
    }
}