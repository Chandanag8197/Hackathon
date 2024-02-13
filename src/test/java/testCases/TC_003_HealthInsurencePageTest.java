package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.HealthInsurencePage;
import testBase.baseClass;

public class TC_003_HealthInsurencePageTest extends baseClass{
  @Test(priority=3)
  public void verify_health() {
	  
	  HealthInsurencePage hip = new HealthInsurencePage(driver);
	  hip.members_print();
	 
	  try {
		captureScreen("family members list");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  hip.health_menu();

  }
}
