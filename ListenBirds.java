import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ListenBirds {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://coneixelriu.museudelter.cat/ocells.php");
		
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		
		List<WebElement> oList = driver.findElements(By.xpath("//a[starts-with(@id,'o-')]"));
		
		for(WebElement el : oList) {
			
			if (el.getAttribute("id").toString().equals("o-blauet")){
				ListenBirds.clickFirstBird(driver,el.getAttribute("id"));
			}else {
				ListenBirds.clickRestAllBirds(driver, builder, el.getAttribute("id"));
			}
			
		}
		
		System.out.println("Enjoy your Day !!!");
		driver.close();

	}
	
	
	public static void clickFirstBird(WebDriver driver, String id) throws InterruptedException {
		
		WebElement target1 = driver.findElement(By.id(id));
		
		target1.click();
		
		Thread.sleep(10000);
		
		
	}

	public static void clickRestAllBirds(WebDriver driver,Actions builder, String id) throws InterruptedException {
		
		WebElement target2 = driver.findElement(By.id(id));	
		
		builder.moveToElement(target2).build().perform();
		
		Thread.sleep(10000);
		
		
	}
	
}
