package week2.day2;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1.Go to https://www.redbus.in/ in chrome
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2.Type Chennai in From textBox and ENTER
		WebElement fromLocation = driver.findElement(By.id("src"));
		fromLocation.sendKeys("Chennai");
		Thread.sleep(1000);
		fromLocation.sendKeys(Keys.ENTER);
		
		//3.Type Bengaluru in Destination textBox and ENTER 
		WebElement toLocation = driver.findElement(By.id("dest"));
		toLocation.sendKeys("Bengaluru");
		Thread.sleep(1000);
		toLocation.sendKeys(Keys.ENTER);
		
		//4.Choose any date in JULY
		driver.findElement(By.id("onward_cal"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='we day'])[1]")).click();
		
		//5.Click Search Buses
		driver.findElement(By.id("search_btn")).click();
		
		Thread.sleep(2000);
		
		//6.Close the popup using the X button at the right corner
		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		Thread.sleep(1000);
		
		//7.Print the number of search results
		String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of buses : " +text);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
		
		//8.Choose only Sleeper Bus
		WebElement sleeperBus = driver.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
		sleeperBus.click();
		Thread.sleep(2000);
		
		//9.Print the number of search results
		String text1 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of sleeper bus : " +text1);
		Thread.sleep(1000);
		
		//10.Deselect the sleeper Bus and select the AC bus alone
		sleeperBus.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='bt_AC']")).click();
		Thread.sleep(2000);
		
		//11.Print the number of search results
		String text2 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of AC bus : " +text2);
		Thread.sleep(2000);
		
		//12.Choose also Non AC buses
		driver.findElement(By.xpath("//label[@for='bt_NONAC']")).click();
		Thread.sleep(1000);
		
		//13.Print the number of search results
		String text3 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of AC and non-AC bus : " +text3);
		
		
	}

}
