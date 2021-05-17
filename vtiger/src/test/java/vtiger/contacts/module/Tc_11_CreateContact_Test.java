package vtiger.contacts.module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vtiger.genericUtility.BaseClass;
import vtiger.pomClasses.ContactsPage;
import vtiger.pomClasses.CreateContactPage;

public class Tc_11_CreateContact_Test extends BaseClass{

	@Test(groups ="SmokeTest")
	public void createContactTest() throws Throwable
	{
		//Navigate to Contacts.
		homePage.clickContactLink().createContactImg();
		//Navigate create contact.
		String name = eUtil.getExcelData("ContactsModule",1,2)+jUtil.getRandomNumber();
		CreateContactPage createContact=new CreateContactPage(driver);
		createContact.createContact(name);
		//Assign group
		String groupName =eUtil.getExcelData("ContactsModule", 1, 3);
		createContact.selectDropDown(groupName);
	}


	@Test(groups="SmokeTest")
	public void deleteContactTest() throws Throwable
	{
		//Navigate to Contacts.
		homePage.clickContactLink();
		//Enter name to delete.
		String searchName=eUtil.getExcelData("ContactsModule", 5, 2);
		String x = "//table[@class='lvt small']//tr[./td/a[contains(text(),'"+searchName+"')]]//input";
		List<WebElement> allContacts = driver.findElements(By.xpath(x));
		for(WebElement w:allContacts)
		{
			w.click();	
		}
		ContactsPage contactPage=new ContactsPage(driver);
		contactPage.clickOnDelete();
		homePage.clickContactLink();
		
	}
}

