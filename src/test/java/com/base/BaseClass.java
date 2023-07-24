package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void getDriver(String browserName) {
		switch (browserName) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
	}

	public void launchURL(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void click(WebElement element) {
		element.click();
	}

	public void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public String getText(WebElement element) {
		String txt = element.getText();
		return txt;
	}

	public void moveCursor(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public File takeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public void unconditionalWait(int msecs) throws InterruptedException {
		Thread.sleep(msecs);
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(getProjectPath() + "\\src\\test\\resources\\PropertyFiles\\Datas.properties"));
		String value = (String) p.get(key);
		return value;
	}

	public byte[] cucumberScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	public void clickByEnterKey() {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}

}
