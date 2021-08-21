package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 //2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		 
		 //3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		 
		 //4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		 
		 //5. Click on contacts Button
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		 
		 //6. Click on Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		  
		 //7. Enter FirstName Field Using id Locator
		 driver.findElement(By.id("firstNameField")).sendKeys("Nazreen");
		
		 //8. Enter LastName Field Using id Locator
		 driver.findElement(By.id("lastNameField")).sendKeys("Fathima");
		 
		 //9. Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Nafa");
		 
		 //10. Enter LastName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Fana");
		 
		 //11. Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Quality Assurance");
		 
		 //12. Enter Description Field Using any Locator of your choice 
		 driver.findElement(By.id("createContactForm_description")).sendKeys("Decription is very important");
		 
		 //13. Enter your email in the E-mail address Field using the locator of your choice
		 driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("nafa@gmail.com");
		 
		 //14. Select State/Province as NewYork Using Visible Text
		 WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		 Select stateDD = new Select(state);
		 stateDD.selectByVisibleText("New York");
		 
		 //15. Click on Create Contact
		 driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		 
		 //16. Click on edit button 
		 driver.findElement(By.xpath("//a[text()='Edit']")).click();
		 
		 //17. Clear the Description Field using .clear
		 driver.findElement(By.xpath("//textarea[@class='inputBox']")).clear();
		 
		 //18. Fill ImportantNote Field with Any text
		 driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Important Note");
		 
		 //19. Click on update button using Xpath locator
		 driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		 
		 //20. Get the Title of Resulting Page.
		 String title = driver.getTitle();
		 System.out.println("Title of the resulting Page : "+title);


	}

}
