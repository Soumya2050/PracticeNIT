package tyss;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the brand name:- ");
		String brandName=sc.next();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement el = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",el);
		wait.until(ExpectedConditions.visibilityOf(el)).click();
		driver.findElement(By.xpath("//div[@id='brandsRefinements']/descendant::span[.='See more']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='brandsRefinements']/descendant::span[@class=\"a-size-base a-color-base\"]"));
		for(int i=0 ; i<elements.size();i++)
		{
			if(elements.get(i).getText().equalsIgnoreCase(brandName))
			{
				elements.get(i).click();
				System.out.println("clicked");
				break;
				
			}
		}

		Thread.sleep(10000);
		driver.quit();
		
	}

}
