package com.selenium.weekend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class April12_Selenium {
	
	static WebDriver driver  = null;
	
	
	
	public static void main(String[] args) throws Exception {
		runcommands();
		
		
	}
	
	public static void runcommands() throws IOException
	{
		//String[] cmd = {"notepad.exe","sample.txt"};
		//Runtime.getRuntime().exec(cmd);
		
		String[] cmd1 = {"sample1.bat"};
		Runtime.getRuntime().exec(cmd1);
		
	}
	
	public static void killprocess() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /IM firefox.exe");
		
	}
	public  static void actionsExamplemoveToElement() throws IOException, InterruptedException
	{
		
		launchActitime();
		
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_js_dropdown_hover");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement dropdown = driver.findElement(By.className("dropdown"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(dropdown).build().perform();
		
		
		
		
			
	}
	
	
	public  static void actionsExampleContextClick() throws IOException, InterruptedException
	{
		
		launchActitime();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
			
		WebElement conclick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver);
		
		//action.doubleClick(conclick).build().perform();
		
		action.contextClick(conclick).build().perform();
		
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		driver.close();
			
	}
	
	
	
	public  static void dragAndDropExample() throws IOException, InterruptedException
	{
		
		launchActitime();
		
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		
		WebElement drag = driver.findElement(By.id("div1"));
		
		WebElement drop = driver.findElement(By.id("div2"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(drag, drop).build().perform();
		
		action.clickAndHold(drag).build().perform();
		
		action.moveToElement(drop).build().perform();
		
		action.release();
	
	}
	
	public  static void actionsExample1() throws IOException, InterruptedException
	{
		
		launchActitime();
		
		driver.findElement(By.name("username")).sendKeys("admin");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).clear();
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		
		driver.findElement(By.name("username")).click();
		
		actions.keyDown(Keys.SHIFT).sendKeys("admin").build().perform();
		
		Thread.sleep(2000);
		
		actions.keyUp(Keys.SHIFT).build().perform();
		
		actions.sendKeys(Keys.TAB).build().perform();
		
		actions.sendKeys("manager");
		
		actions.sendKeys(Keys.TAB).build().perform();
		
		actions.sendKeys(Keys.SPACE).build().perform();
		
		actions.sendKeys(Keys.TAB).build().perform();
		
		
		actions.sendKeys(Keys.ENTER).build().perform();
		
		closeBrowser();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void threadsleepExample() throws Exception
	{
		launchActitime();
		
	
		loginToActitime();		
		
		//driver.findElement(By.className("logout")).click();
		
		
	}
	
	
	
	
	
	public static void launchActitime() throws IOException
	{
		
		String browser = getConfigData("browser");
		
			
		
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput","true");
			System.setProperty("webdriver.chrome.driver", "./utilities/chromedriver.exe");
			driver = new ChromeDriver();
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./utilities/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(getConfigData("url"));
		
		
		
	}
	
	
	
	public static String getConfigData(String keyname) throws IOException
	{
		String value = "";
				
		File f = new File("./data/config.properties");	
		FileInputStream fis = new FileInputStream(f);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		value = prop.getProperty(keyname);
					
		return value;
		
		
	}
	
	
	public static void closeBrowser()
	{
		driver.close();
	}
	
	
	public static void loginToActitime()
	{
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.id("loginButton")).click();
		
		//JavascriptExecutor je = (JavascriptExecutor)driver;
		
		//je.executeScript("alert('welcome')");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("Logout")));
		*/
		
		
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[text()='Logout']"))));
		//wait.until(ExpectedConditions.alertIsPresent());
		
		
		
		
		
	}

}
