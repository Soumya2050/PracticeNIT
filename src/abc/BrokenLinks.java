package abc;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		ArrayList<String> list = new ArrayList<>();
		System.out.println("Total links are:- " + allLinks.size());
		for (WebElement webElement : allLinks) {
			String linkUrl = webElement.getAttribute("href");
			list.add(linkUrl);
		}
		long intTime = System.currentTimeMillis();
		list.parallelStream().forEach(e -> brokenLinks(e));
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-intTime+" :- Occures");
		driver.quit();
	}

	public static void brokenLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpconnection = (HttpURLConnection) urlConnection;
			httpconnection.setConnectTimeout(2000);

			if (httpconnection.getResponseCode() >= 400) {
				System.out.println(linkUrl + "---->" + httpconnection.getResponseMessage() + "--->"
						+ httpconnection.getResponseCode());
			}
		} catch (Exception e) {}
	}
}
