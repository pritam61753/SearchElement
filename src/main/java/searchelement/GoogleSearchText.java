package searchelement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchText {

	public static void main(String[] args)  {
		
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\win8\\eclipse-workspace\\Chromedriver\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\win8\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	
	
	
	WebDriver driver = new ChromeDriver();  //Launch the browser
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	//dynamic wait
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.google.com/");
//	driver.get("https://www.amazon.com/");	
	
	
	driver.findElement(By.className("gLFyf")).sendKeys("java");
	
	List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox]//li/descendant::div[@class='wM6W7d WggQGd']"));	
	
	System.out.println("total no. of suggestion in search box:::=======> "+ list.size());
	
	for (int i=0; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().contains("java compiler")) {
			list.get(i).click();
			break;
		}
	}

	}

}
