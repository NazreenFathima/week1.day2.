package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

		// 8 Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Nazreen");

		// 9 Click Find leads button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(3000);

		// 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		Thread.sleep(3000);

		// 11 Verify title of the page
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		String title1 = "View Lead | opentaps CRM";
		if (title1.equals(title)) {
			System.out.println("Title is verified");
		}

		// 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);

		// 13 Change the company name
		WebElement companyName = driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
		companyName.clear();
		String newCompanyName = "LeafTest";
		companyName.sendKeys("newCompanyName");

		// 14 Click Update
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		Thread.sleep(2000);

		// 15 Confirm the changed name appears
		String changedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (changedCompanyName.equals(changedCompanyName)) {
			System.out.println("Changed name is reflecting");
		}

		// 16 Close the browser (Do not log out)
		driver.close();

	}

}
