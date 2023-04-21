package testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortByPrice {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		driver.findElement(By.name("q")).sendKeys("shoes");
		Thread.sleep(2000);
		driver.findElement(By.className("L0Z3Pu")).click();
		
		
		driver.get("https://www.flipkart.com/search?q=shoes&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off&sort=price_asc");
		
		System.out.println("=========Products available on Page 1 ========");
		
		for(int j=2;j<12;j++) {
			for(int i=1;i<5;i++)
			 {
			String Title = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+j+"]/div/div["+i+"]//a[@title]";
			String Price="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+j+"]/div/div["+i+"]/div/div/a[2]/div/div[1]";
			WebElement contentEle = driver.findElement(By.xpath(Price));
			WebElement contentEle1 = driver.findElement(By.xpath(Title));
	 		System.out.println(contentEle1.getText().toString()+"----"+contentEle.getText());
			}
		}
		driver.get("https://www.flipkart.com/search?q=shoes&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&sort=price_asc&page=2");
		System.out.println("=========Products available on Page 2 ========");
		
		for(int j=2;j<12;j++) {
			for(int i=1;i<5;i++)
			 {
			String Title = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+j+"]/div/div["+i+"]//a[@title]";
			String Price="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div["+j+"]/div/div["+i+"]/div/div/a[2]/div/div[1]";
			WebElement contentEle = driver.findElement(By.xpath(Price));
			WebElement contentEle1 = driver.findElement(By.xpath(Title));
	 		System.out.println(contentEle1.getText().toString()+"----"+contentEle.getText());
			}
		}
		
      
	}

}
