package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter your email address
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nafa@gmail.com");
		
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Appended", Keys.TAB);
		
		//Get default text entered
		String defaultText = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
		System.out.println("Default Text entered is "+defaultText);
		
		//Clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		//Confirm that edit field is disabled
		boolean editField = driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled();
		System.out.println("Edit field is enabled = " +editField);
	}

}
