package tyss;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> country=driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for (WebElement webElement : country) {
			System.out.println(webElement.getText());
		}
		System.out.println("<-------------------------------------------------------->");
		test1(country);
		Thread.sleep(2000);
		driver.quit();
	}
	public static void test1(List<WebElement>country) {
		boolean india = false;
		 for (WebElement ind : country) {
	            if (ind.getText().contains("India")) {
	                india = true;
	                break;
	            }
	        }

	        if (india) {
	            System.out.println("India is present in the list");
	        } else {
	            System.out.println("india is not present in the list");
	        }
	}
}
