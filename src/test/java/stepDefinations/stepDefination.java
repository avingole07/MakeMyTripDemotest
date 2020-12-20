package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)

public class stepDefination {
	WebDriver driver;               

    @Given("^open chrome browser $")
    public void open_chrome_browser() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "E://Chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")).click();
		//driver.findElement(By.xpath("//div[@class='login__card makeFlex hrtlCenter cursorPointer appendBottom10']")).click();
			//if alert window
	//	Alert alertCancel = driver.switchTo().alert();
	//	alertCancel.dismiss();			
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
       
    }

    @When("^User enters credentials and logs in$")
    public void user_enters_and_and_logs_in(String email, String password) throws Throwable {
    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("avi.fort@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Flight@203");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
        
    }

    @Then("^Verify that user is succesfully logged in to application homepage$")
    public void verify_that_user_is_succesfully_logged_in_to_application_homepage() throws Throwable {
       Assert.assertEquals(driver.getTitle(), "Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip");
    }

    
    @Given("^user login and is on HomePage $")
    public void user_login_and_is_on_homepage() throws Throwable {
    	 Assert.assertEquals(driver.getTitle(), "Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip");
    }

    @When("^User select From and To Destinagtion$")
    public void user_select_from_and_to_destinagtion() throws Throwable {
    	driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Ahmedabad");
		Thread.sleep(2000);
		List<WebElement> from = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div //ul/li"));
		for(WebElement option:from )
		{
			if(option.getText().equalsIgnoreCase("Ahmedabad"));
			{		
			option.click();
			break;
		
			}
		}
			driver.findElement(By.xpath("//span[contains(text(),'To')]")).click();
			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
			Thread.sleep(2000);
			List<WebElement> to = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div //ul/li"));
			for(WebElement opt:to )
			{
				if(opt.getText().equalsIgnoreCase("Mumbai"));
				{		
				opt.click();
				break;
			
				}	
		}
    }
		  @And("^Select Departure date$")
		    public void select_departure_date() throws Throwable {
			  driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
			  driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Thu Dec 31 2020']")).click();
		    }

		    @And("^Select Traveller and Class$")
		    public void select_traveller_and_class() throws Throwable {
		    	driver.findElement(By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']")).click(); 
		    	driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//li[contains(text(),'Business')]")).click();
		    	driver.findElement(By.xpath("//button[contains(text(),'APPLY')]")).click();
		    }
    

    @Then("^It display list of Fights availabe$")
    public void it_display_list_of_lights_availabe() throws Throwable {
    	driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
    	
    	Thread.sleep(2000);
    	
    	List<WebElement> flight = driver.findElements(By.xpath("//div[@class='dept-options']/div"));
		for(WebElement optf:flight )
		{
			if(optf.getText().equalsIgnoreCase("IndiGo"));
			{	
				Assert.assertEquals(optf, "IndiGo");						
			optf.click();
				
			break;
			}
			
		}
		System.out.println("Total flights found in Search : "+flight.size());		

    }

  
    @And("^close browser$")
    public void close_browser() throws Throwable {
    	driver.close();
        
    }


}
