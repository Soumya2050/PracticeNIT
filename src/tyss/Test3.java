package tyss;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test3 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement>mobile=driver.findElements(By.xpath("//span[contains(text(),'Samsung Galaxy')]"));
		List<WebElement>price=driver.findElements(By.xpath("//span[contains(text(),'Samsung Galaxy')]/ancestor::h2/../following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		for(int i=0;i<price.size();i++)
		{
			System.out.print(mobile.get(i).getText());
			System.out.println("----------------->");
			System.out.print(price.get(i).getText());
			System.out.println();
			
		}
		Thread.sleep(2000);
		driver.close();
		
	}

}
