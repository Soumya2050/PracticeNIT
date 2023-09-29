package tyss;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Earphones");
		List<WebElement> autosugesstion=driver.findElements(By.xpath("//div[contains(text(),'earphones')]"));
		for (WebElement webElement : autosugesstion) {
			System.out.println(webElement.getText());
		}
		test1(autosugesstion);
		Thread.sleep(2000);
		driver.quit();
		
	}
	public static void test1(List<WebElement> autosugesstion) {
		boolean WirelessBluetoothDisplayed = false;
		 for (WebElement suggestion : autosugesstion) {
	            if (suggestion.getText().contains("wireless bluetooth")) {
	                WirelessBluetoothDisplayed = true;
	                break;
	            }
	        }

	        if (WirelessBluetoothDisplayed) {
	            System.out.println("Wireless Bluetooth earphones are displayed in the auto-suggestions.");
	        } else {
	            System.out.println("Wireless Bluetooth earphones are not displayed in the auto-suggestions.");
	        }
	}

}
