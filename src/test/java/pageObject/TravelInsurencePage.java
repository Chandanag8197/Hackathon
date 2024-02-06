package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TravelInsurencePage extends basePage {

	public TravelInsurencePage(WebDriver driver) {
		
		super(driver);
		
	}

	@FindBy(xpath = "//p[text()='Travel']")
	WebElement TravelInsurence;

	@FindBy(xpath = "//div[@class='selectedCountryWrap']//input")
	WebElement destination_input;

	@FindAll(@FindBy(xpath = "//ul[@class='search-list']//li"))
	List<WebElement> destination_list;

	public void enter_destination(String destination) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", TravelInsurence);

		sleep(1000);

		destination_input.sendKeys(destination);
		destination_input.click();

		sleep(1000);

		for (WebElement des : destination_list) {
			String des_name = des.getText();
			if (des_name.equals(destination)) {
				des.click();
			}
		}
	}

	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement nextButton;

	@FindBy(xpath = "//label[text()='Start date']")
	WebElement datePickerStart;

	@FindBy(xpath = "//h6")
	WebElement selectMonthYear;

	@FindBy(xpath = "(//button[@data-mui-test = 'next-arrow-button'])[2]")
	WebElement nextMonth;

	@FindAll(@FindBy(xpath = "//span[@class='MuiPickersDay-dayLabel']"))
	List<WebElement> allDates;

	public void pick_start_date() {
		try {
			nextButton.click();
		} catch (StaleElementReferenceException e) {
//			explicitWait(nextButton);
//			nextButton.click();

			nextButton = driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button"));
			nextButton.click();
		}

		System.out.println("nextButton is clicked!!!!!");

		sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		datePickerStart = driver.findElement(By.xpath("//label[text()='Start date']"));

		js.executeScript("arguments[0].click();", datePickerStart);

		sleep(1000);

		String start_month_year = "March 2024";
		String start_date = "2";

		while (true) {
			sleep(2000);
			String mon_year = selectMonthYear.getText();
			System.out.println(mon_year);
			if (mon_year.equals(start_month_year)) {
				break;
			} else {
				sleep(1000);
				nextMonth.click();
				sleep(1000);
			}
		}
		for (WebElement dt : allDates) {
			if (dt.getText().equals(start_date)) {
				dt.click();
				break;
			}
		}
	}

	public void pick_end_date() {

		String end_Month_Year = "March 2024";
		String end_date = "20";

		while (true) {
			String end_mon_year = selectMonthYear.getText();
			System.out.println(end_mon_year);
			if (end_mon_year.equals(end_Month_Year)) {
				break;
			} else {
				sleep(1000);
				nextMonth.click();
				sleep(1000);
			}
		}
		for (WebElement dt : allDates) {
			if (dt.getText().equals(end_date)) {
				dt.click();
				break;
			}
		}

		nextButton.click();

	}

	@FindBy(xpath = "//label[@for=\"traveller_2\"]")
	WebElement two_people;

	@FindBy(xpath = "(//div[@class='customDropdown__select  '])[1]")
	WebElement age_1;

	@FindBy(xpath = "//div[@class=\"options_box_wrapper__option\"]//label[text()='22 years']")
	WebElement age_yrs_1;

	@FindBy(xpath = "(//div[@class='customDropdown__select  '])[2]")
	WebElement age_2;

	@FindBy(xpath = "//div[@class='options_box_wrapper__option']//label[text()='21 years']")
	WebElement age_yrs_2;

	@FindBy(xpath = "//button[@class=\"travel_main_cta\"]")
	WebElement next3;

	public void age_select() {
		sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", two_people);

		age_1.click();
		sleep(1000);
		age_yrs_1.click();

		age_2.click();
		sleep(1000);
		age_yrs_2.click();

		sleep(1000);

		next3.click();

	}

	@FindBy(xpath = "//label[text()='No']")
	WebElement medical_condition;

	@FindBy(xpath = "//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement next4;

	@FindBy(xpath = "//label[text()='Mobile number']")
	WebElement mobile_no_1;

	@FindBy(xpath = "//input[@id='mobileNumber']")
	WebElement mobile_no;

	@FindBy(xpath = "//button[@class='travel_main_cta']")
	WebElement next_mobileNo;

	public void medical_mobile() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", medical_condition);

		explicitWait(next4);

		js.executeScript("arguments[0].click();", next4);

		sleep(2000);

		js.executeScript("arguments[0].click();", mobile_no_1);
		sleep(1000);
		mobile_no.sendKeys("8767857654756");

		sleep(1000);

		next_mobileNo.click();

	}

	@FindBy(xpath = "//input[@id='studentTrip']")
	WebElement stu_plans;

	@FindBy(xpath = "//input[@id='Traveller_1']")
	WebElement visa_1;

	@FindBy(xpath = "//input[@id='Traveller_2']")
	WebElement visa_2;

	@FindBy(xpath = "//select[@id='feet']")
	WebElement duration;

	@FindBy(xpath = "//button[@class=\"travel_main_cta\"]")
	WebElement next_visa_button;

	@FindBy(xpath = "//section[@class='newFilterSection sort']")
	WebElement sortBy;

	@FindBy(xpath = "//label[text()='Premium low to high']")
	WebElement low_high;

	public void student_plans() {
//		stu_plans.click();
		
		jsClick(stu_plans);
		sleep(3000);

		visa_1.click();
		visa_2.click();
		Select select = new Select(duration);
		select.selectByValue("1");

		next_visa_button.click();

		sleep(2000);

		jsClick(sortBy);

		sleep(1000);
		try {
			low_high.click();
		} catch (Exception e) {
			sortBy.click();
			sleep(1000);
			low_high.click();
		}
		sleep(3000);

	}
	
	@FindAll(@FindBy(xpath="//div[@class='quotesCard']//div[@class='quotesCard__cta familyPlanPriceContainer']//span"))
	List<WebElement> lowPricePlans;
	
	
	public void planResults() {
		
		sleep(2000);
		for(int i=0;i<lowPricePlans.size();i++) {
			try {
				eu.setCellData("low_price_student_plans", i, 0, lowPricePlans.get(i).getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sleep(2000);
		
	}

	@FindBy(xpath = "//a[text()='Policybazaar']")
	WebElement back_home;

	public void navigateBack() {
		jsClick(back_home);
	}
}
