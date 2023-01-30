package org.stepdefanition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class LoginSteps {
	
	static WebDriver driver;
	@Given("The user should be in facebook loginpage")
	public void the_user_should_be_in_facebook_loginpage() {
		
		WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get("https://www.facebook.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
}

	@When("The user has to fill the user name and password")
	public void the_user_has_to_fill_the_user_name_and_password() {
		
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("Bharathi");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("56789");
		
	    
	}

	@When("The user have to click the login button")
	public void the_user_have_to_click_the_login_button() {
		WebElement btnclick = driver.findElement(By.name("login"));
		btnclick.click(); 
	}

	@SuppressWarnings("deprecation")
	@Then("The user should be in invalid login page")
	public void the_user_should_be_in_invalid_login_page() {
		
		WebDriverWait w= new WebDriverWait(driver,20);
		w.until(ExpectedConditions.urlContains("privacy"));
		Assert.assertTrue("Verify type url", driver.getCurrentUrl().contains("privacy"));
		System.out.println("user in Invalid page");
		driver.quit();
	   
		
	}


	
	
}