package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public static Properties p;
		
		@BeforeTest
		@Parameters({"os","browser"})
		public void setup(String os,String br) throws IOException
		{
			
			FileReader file =new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			logger=LogManager.getLogger(this.getClass());
			
			String Browser=br.toLowerCase();
			
			switch (Browser) {
			case "chrome":driver=new ChromeDriver();
						break;
			case "edge": driver=new EdgeDriver();
						break;
			default:System.out.println("no matchings!");
						return;
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
			
			
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
		
		public static void sleep(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		public static String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenShots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}	

}
