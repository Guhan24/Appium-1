package sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Omr {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/apitestingtraininginchennaiomr/");
		
		WebElement btnlang = driver.findElement(By.id("languages"));
	
		Select s = new Select(btnlang);
		List<WebElement> options = s.getOptions();
		
		for (int i = 0; i < options.size(); i++) {
			
			WebElement A = options.get(i);
			String B = A.getText();
			System.out.println(B);
		}	
		File f = new File("C:\\Users\\Gowtham\\eclipse-workspace\\FrameWork\\ExcelSheeet\\Gowtham.xlsx");
		Workbook wrk = new XSSFWorkbook();
		Sheet createSheet = wrk.createSheet();
		for (int i = 0; i < options.size(); i++) {
			Row row = createSheet.createRow(i);
			Cell createCell = row.createCell(3);
			createCell.setCellValue(options.get(i).getText());
			FileOutputStream stream = new FileOutputStream(f);
			wrk.write(stream);
			
			
			
			
		}
		
	 	
		

	}

}

