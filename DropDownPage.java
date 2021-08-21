package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select training program using Index
		WebElement usingIndex = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select usingIndexDD = new Select(usingIndex);
		usingIndexDD.selectByIndex(1);
		
		//Select training program using Text
		WebElement usingText = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select usingTextDD = new Select(usingText);
		usingTextDD.selectByVisibleText("Appium");
		
		//Select training program using Value
		WebElement usingValue = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select usingValueDD = new Select(usingValue);
		usingValueDD.selectByValue("3");
		
		//Get the number of dropdown options
		WebElement noOfDropdownOption = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select noOfDropdownOptionDD = new Select(noOfDropdownOption);
		int size = noOfDropdownOptionDD.getOptions().size();
		System.out.println("Number of dropdown options : "+size);
		
		//You can also use sendKeys to select
		driver.findElement(By.xpath("//option[contains(text(),'sendKeys')]/..")).sendKeys("Loadrunner");
		
		//Select your program
		driver.findElement(By.xpath("//option[contains(text(),'programs')]//following-sibling::option[3]")).click();

	}

}
