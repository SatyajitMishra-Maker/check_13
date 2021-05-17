package vtiger.genericUtility;

import java.util.Date;
import java.util.Random;
/*
 * This class contains java generic methods
 * @Satyajit
 * 
 */

public class JavaUtility {
	/*
	 * This method generate random numbers
	 * 
	 */
	public String getRandomNumber()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}

  /*
   *This method generate current date
   *  
   */
public String getCurrentDate()
{
	Date date= new Date();
	String currentDate = date.toString();
	return currentDate;
	
}


}
