package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Find position of button (x,y)
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("Position of Button : "+location);
		
		//Find button color
		String buttonColor = driver.findElement(By.xpath("//button[contains(text(),'color')]")).getCssValue("color");
		System.out.println("Button Colour : "+buttonColor);
		
		//Find the height and width
		Dimension size = driver.findElement(By.xpath("//button[contains(text(),'size')]")).getSize();
		System.out.println("Height and Width" +size);
		
		//Click button to travel home page
		driver.findElement(By.xpath("//button[text()='Go to Home Page'] ")).click();
		
	}

}
