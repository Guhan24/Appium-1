package org.pom;

import java.io.IOException;

import org.combine.Login;
import org.combine.SearchHotel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitAdactinHotel extends BaseClass{
	 public static WebDriver driver;
	 
	 @BeforeClass
	public static void beforeClass() {
	//WebDriverManager.chromedriver().setup();
	 //driver = new ChromeDriver();
		 getdriver();
	geturl("https://adactinhotelapp.com/");
	maximizewindow();
}
	@Test
public void testcase01() throws IOException {
		Login login = new Login();
		login.logIn(readCellData("Dask", 1,0), readCellData("Dask", 1, 1));
		
		SearchHotel searchHotel = new SearchHotel();
		WebElement welcomeMsg = searchHotel.getTextWelcomeMsg();
		String attribute = getAttribute(welcomeMsg);
		Assert.assertEquals("verify", "Hello Akilan1008!",attribute);
		
		searchHotel.searchHotels(readCellData("Dask", 1, 2), readCellData("Dask", 1, 3), readCellData("Dask", 1, 4),
				readCellData("Dask", 1, 5), readCellData("Dask", 1, 6), 
				readCellData("Dask", 1, 7),readCellData("Dask", 1,8) , readCellData("Dask", 1, 9));
		
		
		
}
	
}
