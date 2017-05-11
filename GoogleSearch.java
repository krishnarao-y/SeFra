package com.cucumber.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleSearch{
	
	  private final WebDriver driver = new FirefoxDriver();

	  @Given("^Open the google india application$")
	  public void openGoogle() {
		  driver.get("http://www.google.co.in");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @When("^Enter (.*) in google search text box$")
	  public void search(String keyword){
		  WebElement gSearch = driver.findElement(By.name("q"));
		  gSearch.sendKeys(keyword);
		  gSearch.submit();
	  }
	  
	  @Then("^Get the results text from the page$")
	  public void getResults(){
		 String res = driver.findElement(By.id("resultStats")).getText();
		 System.out.println(res);
	  }
	  
	  @Then("^Closes the google application$")
	  public void closeApp(){
		  driver.close();
		  driver.quit();
	  }

}
