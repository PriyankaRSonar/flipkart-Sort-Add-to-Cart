package testing;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCart {

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
		
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[2]")).click();	
        
        Set<String> s = driver.getWindowHandles();
       
        
        for(String string: s) {
        	driver.switchTo().window(string);
        }
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
        
        driver.findElement(By.xpath("//a[@class='_3SkBxJ']"));
        
        driver.get("https://www.flipkart.com/search?q=shoes&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off&sort=price_asc");
       
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]")).click();	
        
        Set<String> s1 = driver.getWindowHandles();
        
        
        for(String string: s1) {
        	driver.switchTo().window(string);
        }
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
      
        driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
       
        Set<String> s3 = driver.getWindowHandles();
        
        System.out.println("=====Cart Details=======");
        
        for(String string: s3) {
       	driver.switchTo().window(string);
        }
        
        String Total = "//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/div[2]";
    	WebElement cartPrice = driver.findElement(By.xpath(Total));
    	System.out.println("Total Amount:"+cartPrice.getText());
    	System.out.println("Product Details: ");
        
        for(int j=3;j<10;j++) {
        
		String Title = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div["+j+"]/div/div[1]/div[1]/div[1]/a";
		String Price="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div["+j+"]/div/div[1]/div[1]/span[2]";
			
		WebElement contentEle = driver.findElement(By.xpath(Price));
		WebElement contentEle1 = driver.findElement(By.xpath(Title));
	 	System.out.println(contentEle1.getText().toString()+"----"+contentEle.getText().toString());
        
	 	
		}
        
        
        
        
    	
  }
}
