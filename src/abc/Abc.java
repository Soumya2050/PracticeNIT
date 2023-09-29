package abc;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author srjen
 *unicorn actively hiring
 */
public class Abc {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/mnjuser/profile");
//		WebElement ele = driver.findElement(By.xpath("//div[@class='abc']"));
//		ele.click();
//		Set<String> wa = driver.getWindowHandles();
//		for (String string : wa) {
		System.out.println();
//			driver.switchTo().window(string);
//			String title = driver.getTitle();
//			if (title.contains("unicorn actively hiring")) {
//				driver.close();
//			}
//		}
		
	}
}
