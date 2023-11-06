package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.XLUtils;

public class TC_DataDriven_002 extends BaseClass{

	@Test(dataProvider="datareports")
	public void logintest() {
	//	driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(username);
		log.info("user name is entered");
		lp.setpassword(password);
		log.info("password is entered");
		lp.setlogin();
		log.info("clicking activity is completed");
		
		}
	
	@DataProvider(name="datareports")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/logindata.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String Logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				Logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}

		}
		return Logindata;
	}
}

