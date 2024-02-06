package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HealthInsurencePage extends basePage{

	public HealthInsurencePage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//p[text()='Health']")
	WebElement healthInsurence;
	
	@FindBy(xpath="//a[text()='More members']")
	WebElement more_members;
	
	@FindBy(xpath="//label//span[text()='Female']")
	WebElement female;
	
	@FindAll(@FindBy(xpath="//label/p"))
	List<WebElement> familyMembers;
	
	
	public void members_print() {
		
		healthInsurence.click();
		
		sleep(1000);
		
		more_members.click();
		
		sleep(1000);
		
		for(int i=0;i<familyMembers.size();i++) {
//			System.out.println(family.getText());
			try {
				eu.setCellData("male_family", i, 0, familyMembers.get(i).getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sleep(1000);
		
		female.click();
		
		sleep(1000);
		
		for(int i=0;i<familyMembers.size();i++) {
//			System.out.println(family.getText());
			try {
				eu.setCellData("female_family", i, 0, familyMembers.get(i).getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
