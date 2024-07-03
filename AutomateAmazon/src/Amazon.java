

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
	
	  driver.get("https://www.Amazon.in");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  //Enter item in search box
	  
	 WebElement searchbox=  driver.findElement(By.id("twotabsearchtextbox"));

      searchbox.sendKeys("dairy milk");
      //click on search button
      driver.findElement(By.id("nav-search-submit-button")).click();
      Thread.sleep(1000);

	  JavascriptExecutor executor= (JavascriptExecutor) driver;
	  executor.executeScript("window.scrollBy(0,"+ 300 +")");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[normalize-space()='Cadbury Dairy Milk Chocolate Home Treats, 119 gram']")).click();
	  
	  
	  //Move to parent window to child window
	
	//a[normalize-space()='Amazon miniTV']
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
       String parentid=it.next();	
       String childid=it.next();
       
       System.out.println(parentid);
       System.out.println(childid);
       
       driver.switchTo().window(childid);
       Thread.sleep(2000);
       
       driver.close();
//move to parent window
       
       
       driver.switchTo().window(parentid);
       driver.findElement(By.xpath("//a[normalize-space()='Amazon miniTV']")).click();
  
     driver.close();
     
 	  
}
}