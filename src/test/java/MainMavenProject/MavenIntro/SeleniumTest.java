package MainMavenProject.MavenIntro;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void browserAutomation() {
	System.out.println("browserAutomation");
    }

    @Test
    public void elementUi() {
	System.out.println("elementUi");

    }

    @Test
    public void passDataFRomChild() {
	System.setProperty("webdriver.chrome.driver", "C:\\MyProjects\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	// WE WANT TO GET AN EMAIL FROM CHILD WINDOW AND PASS TO PARENT WINDOW.

	// Opening parent window.
	driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
	driver.findElement(By.cssSelector(".blinkingText")).click();

	// After clicking opens child window ----->

	// Getting info all opened windows
	Set<String> openedWindows = driver.getWindowHandles();
	Iterator<String> it = openedWindows.iterator(); // [ParentId, childId]
	String parentId = it.next(); // gets item zero --> ParentId
	String childId = it.next(); // gets item one --> childId

	// switch to child window
	driver.switchTo().window(childId);
	// Getting email address string
	String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4].trim(); // mentor@rahulshettyacademy.com

	// Switch scope to parent window.
	driver.switchTo().window(parentId);

	// Send email to input of Parent window
	driver.findElement(By.cssSelector("#username")).sendKeys(emailID);

	driver.quit();

    }

}
