package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.TravelInsurencePage;
import testBase.baseClass;

public class TC_001_TravelInsurencePageTest extends baseClass {
  @Test(priority=1)
  public void verify_Travel() throws InterruptedException {
	  
	  logger.info("Starting of Travel Insurence");
	  TravelInsurencePage tip = new TravelInsurencePage(driver);
	  tip.enter_destination("United Kingdom");
	  sleep(1000);
	  try {
		captureScreen("destination");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  logger.info("destination completed!");
	  
	  tip.pick_start_date();
	  tip.pick_end_date();
	  sleep(1000);
	  try {
		captureScreen("travel date pick");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  logger.info("date picked!");
	  tip.age_select();
	  sleep(1000);
	  try {
		captureScreen("age selection");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  tip.medical_mobile();
	  tip.student_plans();
	  sleep(1000);
	  try {
		captureScreen("student plans");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  tip.planResults();
	  
	  logger.info("plan results displayed successfully!");
	  tip.navigateBack();
	
  }
}
