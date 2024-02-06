package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurencePage extends basePage{

	public CarInsurencePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='shadowHandlerBox']//i[@class='icon-bg homeIconsBg car-insurance']")
	WebElement car_insurence_icon;
	
	@FindBy(id="regNoTextBox")
	WebElement car_reg_no;
	
	@FindBy(id="btnGetQuotes")
	WebElement car_insurence_plans;
	
	@FindBy(id="vahan_button_text_no")
	WebElement commercial_car;
	
	@FindBy(xpath="//b[text()='MARUTI']")
	WebElement car_brand;
	
	@FindBy(xpath="//b[text()='SWIFT DZIRE']")
	WebElement car_model;
	
	@FindBy(xpath="//b[text()='2017']")
	WebElement registration_year;
	
	@FindBy(xpath="//b[text()='Petrol']")
	WebElement fuel_type;
	
	@FindBy(xpath="//b[text()='Tour Petrol (1197 cc)']")
	WebElement car_variant;
	
	@FindBy(xpath="//div[@class='textinput']//input[@id='name']")
	WebElement full_name;
	
	@FindBy(xpath="//div[@class='textinput']//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//div[@class='textinput']//input[@id='mobileNo']")
	WebElement mobileNo;
	
	@FindBy(id="btnLeadDetails")
	WebElement view_prices;
	
//	@FindBy(xpath="//div[@class='msg-error show'][text()='Please enter a valid e-mail ID.']")
	@FindBy(xpath="(//div/input/following-sibling::div[2])[2]")
	WebElement invalid_email;
	
	@FindBy(xpath="(//div/input/following-sibling::div[2])[3]")
	WebElement invalid_mobileNo;
	
	
	
	public void car_insurence() {
		
		car_insurence_icon.click();
		
		sleep(1000);
		
		car_reg_no.sendKeys("KA-07-6785");
		
		sleep(1000);
		
		car_insurence_plans.click();
		
		sleep(1000);
		
		try
		{
			commercial_car.click();
		}
		catch(Exception e) {
			System.out.println("No commercial car alert!");
		}
		
		sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", car_brand);
		
		sleep(1000);
		
		car_model.click();
		
		sleep(1000);
		
		fuel_type.click();

		sleep(1000);
		
		car_variant.click();

		sleep(1000);
		
		registration_year.click();
	
		sleep(1000);
		
		full_name.sendKeys("gfgewyfgyiewgfyi");
		email.sendKeys("vcfyuhdgyiiywdgf");
		mobileNo.sendKeys("12");
		mobileNo.sendKeys(Keys.ENTER);
		view_prices.click();
		
		sleep(3000);
		
		System.out.println(invalid_email.getText());
//		mobileNo.sendKeys(Keys.ENTER);

		sleep(1000);
		
		System.out.println(invalid_mobileNo.getText());
		
	}
	
	@FindBy(xpath="//a[@class='pb-logo']")
	WebElement back_home;

	public void navigateBack() {
		jsClick(back_home);
	}

}
