package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 1 Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2 Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// 3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 5 Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		// 6 Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		// 7 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		// 8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		Thread.sleep(1000);
		
		// 9 Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("nafa@gmail.com");
		
		// 10 Click find leads button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(2000);
		
		// 11 Capture name of First Resulting lead
		WebElement Lead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String text = Lead.getText();
		//System.out.println("Lead name " +text);
		
		// 12 Click First Resulting lead
		Lead.click();
		Thread.sleep(3000);
		
		// 13 Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(4000);
		
		// 14 Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		//System.out.println("Title is "+title);
		String title1 = "Duplicate Lead | opentaps CRM";
		if(title1.equals(title))
		{
			System.out.println("Title is verified");
		}
		
		Thread.sleep(2000);
		
		// 15 Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		
		// 16 Confirm the duplicated lead name is same as captured name
		String duplicateLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(duplicateLead.equals(text))
		{
			System.out.println("Duplicated lead name is same as captured name");
		}
		Thread.sleep(1000);
		
		// 17 Close the browser (Do not log out)
		driver.close();
		 
		
	}

}
