package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Go to Home Page
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		
		driver.navigate().back();
		
		//Find where am supposed to go without clicking me?
		String link = driver.findElement(By.xpath("//a[contains(text(), 'clicking')]")).getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me? : " +link);
		
		//Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		if(title.contains("Not Found"))
		{
			System.out.println("Clicked link is broken");
		}
		else
		{
			System.out.println("CLicked link is not broken");
		}
		
		driver.navigate().back();
		
		
		//Go to Home Page (Interact with same link name)
		/*
		We will be considering the first and the fourth Link.
		1. Get the href of the first Link. Store as a String 
		2. Get the href of the fourth link. Store as a String
		3. Compare both the Strings.
		4. If they are the same, then click the first link and reach the link as given in the href.
		*/
		
		String attribute1 = driver.findElement(By.xpath("//div[@class='example'][4]//following::a")).getAttribute("href");
		String attribute2 = driver.findElement(By.xpath("//a[text()='Go to Home Page']")).getAttribute("href");
		if (attribute1.equals(attribute2))
		{
			driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		}
		
		//How many links are available in this page? - for more than one element - findElements
		List<WebElement> links = driver.findElements(By.tagName("a"));
	     System.out.println("The number of links is " + links.size());

	}

}
