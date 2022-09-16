
//This is a Testing code for the Website SuperiorPOD, In this code almost all the browser actions which we can perform using selenium are performend.

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserActionsTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//This Code is for Functional Testing of Website SuperiorPOD
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		//river.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.navigate().to("https://www.superiorpod.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
		String orgWindow=driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.close();
		
		driver.switchTo().window(orgWindow);
		System.out.println(driver.manage().window().getSize().getHeight());
		System.out.println(driver.manage().window().getSize().getWidth());
		
		driver.manage().window().setSize(new Dimension(600,400));
		Thread.sleep(1000);

		Point position= driver.manage().window().getPosition();
		System.out.println(position.getX());
		System.out.println(position.getY());
		
		
		driver.manage().window().fullscreen();
		Thread.sleep(1000);
		driver.manage().window().minimize();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().window().setPosition(new Point(200,30));
		
		
		
		File scrShoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrShoot,new File("./image1.png"));
		
		
		File scrshoot2 = driver.findElement(By.className("img-responsive")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshoot2,new File("./image2.png"));
		driver.close();
		driver.quit();
		//This Code is just for practice to moving to different iframes and perform actions on them.
				/*
				driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
				driver.switchTo().frame("packageListFrame");
				driver.findElement(By.linkText("org.openqa.selenium.bidi.log")).click();
				Thread.sleep(1000);
				driver.switchTo().frame("packageFrame");
				driver.findElement(By.linkText("StackTrace")).click();
				*/
		//System.out.println("this is me..!");
	}

}
