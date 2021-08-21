package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//div[@class='row']//img")).click();
		
		driver.navigate().back();

		//Am I Broken Image?
		String attribute = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).getAttribute("src");
		System.out.println(attribute);
		
		//Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//label[contains(text(),'Keyboard')]/following-sibling::img")).click();
	}

}
