package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;		//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"os" , "browser"})
	public void setup(String os,String br) throws IOException {
		//loading Properties file
		FileReader file=new FileReader(".//src/test/resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		//loading log4j2 xml file
		logger=LogManager.getLogger(this.getClass());   //log4j
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capablities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capablities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capablities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("not matching os...");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capablities.setBrowserName("chrome"); break;
			case "edge": capablities.setBrowserName("edge"); break;
			default:System.out.println("no matching browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capablities);
		}
		else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			//launching browser base on condition
			switch (br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default: System.out.println("Not matching browser name...");
						return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups = {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber() {
		String generateString=RandomStringUtils.randomNumeric(10);
		return generateString;
	}
	
	public String randomAlphaNumeric() {
		String generateString=RandomStringUtils.randomAlphabetic(10);
		String geneString2=RandomStringUtils.randomNumeric(3);
		return (generateString+"@"+geneString2);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
