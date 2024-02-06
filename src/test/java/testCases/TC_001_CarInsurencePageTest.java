package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.CarInsurencePage;
import testBase.baseClass;

public class TC_001_CarInsurencePageTest extends baseClass{
  @Test(priority=2)
  public void verify_carInsurence() {
	  
	  CarInsurencePage cp = new CarInsurencePage(driver);

	  cp.car_insurence();
	 
	  try {
		captureScreen("car details");
	} catch (IOException e) {
		e.printStackTrace();
	}
	  cp.navigateBack();
  }
}
