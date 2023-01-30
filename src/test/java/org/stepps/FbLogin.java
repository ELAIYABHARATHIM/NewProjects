package org.stepps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FbLogin {
	 public static WebDriver driver;
	@Given("The user should be in homepage")
	public void the_user_should_be_in_homepage() {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.get("https://www.bigw.com/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
	}

	@When("The user has to search box to search")
	public void the_user_has_to_search_box_to_search() {
	  WebElement search= driver.findElement(By.xpath("(//div[@class='icon-row'])[1]"));
	  search.click();
	
	}

	@Then("The user should be search button click")
	public void the_user_should_be_search_button_click() {
		 WebElement clk= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
			clk.click();
	}

	

}
