package vtiger.contacts.module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.genericUtility.BaseClass;
import vtiger.pomClasses.ContactInformationPage;
import vtiger.pomClasses.CreateContactPage;
import vtiger.pomClasses.EditContactPage;

public class Tc_15_EditContact_Test extends BaseClass{
	
	@Test(groups="RegressionTest")
	public void createAndEditContactTest() throws Throwable
	{
		//Navigate to Contacts.
		homePage.clickContactLink().createContactImg();
		String name = eUtil.getExcelData("ContactsModule",1,2)+jUtil.getRandomNumber();
		CreateContactPage createContact=new CreateContactPage(driver);
		createContact.createContact(name);
		//Navigate to Contacts.
		homePage.clickContactLink();
		driver.findElement(By.linkText(name)).click();
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		contactInfoPage.clickOnEditButton();
		//edit contact
		String firstName = eUtil.getExcelData("ContactsModule", 9, 3);
		EditContactPage editContact=new EditContactPage(driver);
		editContact.enterToTF(firstName);
		homePage.clickContactLink();
		//Validating
		boolean validate = driver.getPageSource().contains(firstName);
		Assert.assertTrue(validate);
	}
	@Test(groups="RegressionTest")
	public void CreateAndDeleteContactTest() throws Throwable
	{
		//Navigate to Contacts.
		homePage.clickContactLink().createContactImg();
		//Navigate create contact.
		String name = eUtil.getExcelData("ContactsModule",1,2)+jUtil.getRandomNumber();
		CreateContactPage createContact=new CreateContactPage(driver);
		createContact.createContact(name);
		//Navigate to Contacts.
		homePage.clickContactLink();
		//Selecting and deleting contact
		driver.findElement(By.linkText(name)).click();
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		contactInfoPage.clickOnDeleteButton();
		homePage.clickContactLink();
		//validating
		boolean validate = driver.getPageSource().contains(name);
		Assert.assertFalse(validate);
	}
}
