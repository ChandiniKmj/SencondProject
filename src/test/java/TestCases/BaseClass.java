package TestCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadingData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadingData rd=new ReadingData();
	public String baseURL=rd.getapplicationurl();
	public String username=rd.getemail();
	public String password=rd.getpassword();
	
	public static Logger log;
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openApplication() {
		
		log=Logger.getLogger("SwayamSikkim");
		PropertyConfigurator.configure("log4j.properties");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		
	    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\91967\\eclipse-workspace\\SwayamSikkim\\Drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("--remote-allow-origins=*");

	    
	    
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(option);
		
		//driver.get(baseURL);
		
	}
	
	@AfterClass
	public void closeApplication() {
		driver.close();
	}
	
	public void captureScreen(WebDriver driver,String name) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;//initialization
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+name+ ".png");
		
		
		FileUtils.copyFile(src, target);
		log.info("screenshot is taken");
		
	}
	

}