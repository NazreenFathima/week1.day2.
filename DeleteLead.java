package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		//Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("64838392947");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		//Capture lead ID of First Resulting lead
		WebElement leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		Thread.sleep(1000);
		String leadID2 = leadID.getText();
		System.out.println("First Lead ID1 = " +leadID2);
		
		Thread.sleep(2000);
		//Click First Resulting lead
		leadID.click();
		
		//Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		Thread.sleep(5000);
		
		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID2);
		
		//Click find leads button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		
		Thread.sleep(2000);
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		String text1 = "No records to display";
		if(text1.equals(text))
		{
			System.out.println("Successful deletion");
		}
		
		//Close the browser (Do not log out)
		
		driver.close();

	}

}
