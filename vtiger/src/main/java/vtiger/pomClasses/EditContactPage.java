package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPage {
	
	public EditContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="firstname")
	private WebElement firstNameTF;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getFirstNameTF() {
		return firstNameTF;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
   public void enterToTF(String firstName)
   {
	   firstNameTF.sendKeys(firstName);
	   saveButton.click();
   }
}
