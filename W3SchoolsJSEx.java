package com.wd.programs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3SchoolsJSEx {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Drivers.getDriver("firefox");
		driver.get("https://www.w3schools.com/");
		
		//Taking the screenshot of the driver
		Drivers.takeScreenshotOfDriver(driver, "W3SchoolsHomePage", "png");
		
		WebElement jsElement = driver.findElement(By.xpath("//h1[text()='JavaScript']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", jsElement);
		
		Thread.sleep(2000);
		//Taking the screenshot of javascript element
		Drivers.takeScreenshotOfElement(driver, jsElement, "JSElement", "png");
		
		WebElement learnJS = driver.findElement(By.xpath("//*[text()='LEARN JAVASCRIPT']"));
		
		js.executeScript("arguments[0].click();", learnJS);
		
	}
}
