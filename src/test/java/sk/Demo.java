package sk;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Demo {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.facebook.com");
WebElement txtemail = driver.findElement(By.id("email"));
txtemail.sendKeys("greens");
WebElement txtpass = driver.findElement(By.id("pass"));
txtpass.sendKeys("123654");
TakesScreenshot t = (TakesScreenshot)driver;
File source = t.getScreenshotAs(OutputType.FILE);
File destination = new File("C:\\Users\\Gowtham\\eclipse-workspace\\FrameWork\\Screenshot\\fb.png");
org.openqa.selenium.io.FileHandler.copy(source, destination);    





	}

}
