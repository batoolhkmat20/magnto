package magento;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.MemberSubstitution.AllArguments;

public class test1 {
	String websit = "https://magento.softwaretestingboard.com/";
	String logout = "https://magento.softwaretestingboard.com/customer/account/logout/\"";
	String shoping = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";
	WebDriver driver = new ChromeDriver();
	String[] firstna = { "batool", "lar", "sawsan" };
	String[] lastna = { "hikat", "aid", "hussan" };
	Random rand = new Random();
	int ndomname = rand.nextInt(3);
	int eailid = rand.nextInt(9999);
	String first = firstna[ndomname];
	String last = lastna[ndomname];
	String eee = first + last + eailid + "@gmali.om";
	String pasword = "batool_5";

	@BeforeTest
	public void sutup() {
		driver.get(websit);
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = false)
	public void singnup() throws InterruptedException {
		WebElement reat = driver.findElement(By.partialLinkText("Create an Account"));
		reat.click();
		WebElement nae1 = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		WebElement nae2 = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		WebElement ee = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement pass2 = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		WebElement onfor = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
		nae1.sendKeys(first);
		nae2.sendKeys(last);
		ee.sendKeys(eee);
		pass.sendKeys(pasword);
		pass2.sendKeys(pasword);
		onfor.click();
		Thread.sleep(3000);

		WebElement see = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
		Assert.assertEquals(see.getText(), "Thank you for registering with Main Website Store.");
		driver.get(logout);
	}

	@Test(priority = 2, enabled = false)
	public void login() throws InterruptedException {

		WebElement Login = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
		Login.click();
		WebElement e = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement p = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		e.sendKeys(eee);
		p.sendKeys(pasword);
		WebElement s = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
		s.click();
		Thread.sleep(3000);

		WebElement welo = driver.findElement(By.className("logged-in"));
		Assert.assertEquals(welo.getText().contains("Welcome,"), true);
		// Assert.assertEquals(welo.getText().contains("Welcome"), true);//,"this test
		// hek wole aseeg "
	}

	@Test(priority = 3, enabled = false)
	public void logout() {
		driver.get(logout);
		WebElement logg = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span\r\n"));
//Assert.assertEquals(logg.getText(), "You are signed out");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(true, "You are signed out");
		softassert.assertEquals("You are signed out", "You are signed out");
		softassert.assertAll();

	}

	@Test(priority = 1)
	public void addite() throws InterruptedException {
		driver.get(shoping);
//	WebElement itenontena=driver.findElement(By.cssSelector(".products.list.items.product-items"))	;
//	List<WebElement> ites=itenontena.findElements(By.tagName("li"));
//	ites.get(0).click();
//	Thread.sleep(3000);
//	WebElement sie=driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"))	;
//List<WebElement> allsai=sie.findElements(By.tagName("div"));
//	int randoofsie=rand.nextInt(allsai.size());
//	allsai.get(randoofsie).click();
////	System.out.println(allsai.get(randoofsie).getText());
//	String abeted=allsai.get(randoofsie).getText();	
//	String aual=driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']")).getText();
//	Assert.assertEquals(atual, abeted);
		WebElement TheITemsContainer = driver.findElement(By.cssSelector(".products.list.items.product-items"));
		List<WebElement> allITems = TheITemsContainer.findElements(By.tagName("li"));

		allITems.get(0).click();
		Thread.sleep(2000);

		WebElement SizeContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));

		List<WebElement> AllSized = SizeContainer.findElements(By.tagName("div"));

		int RandomSizeToSelect = rand.nextInt(AllSized.size());
		AllSized.get(ndomname).click();
		String ExpectedSized = AllSized.get(ndomname).getText();
		Thread.sleep(1000);
		String ActualSized = driver.findElement(
				By.cssSelector("div[class='swatch-attribute size'] span[class='swatch-attribute-selected-option']"))
				.getText();
		Assert.assertEquals(ActualSized, ExpectedSized);
	}
@Test (priority = 2)
public void hoieolor() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebElement olorContainer=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
	List <WebElement> Allolor=olorContainer.findElements(By.tagName("div"));//3shan edor bkl aloan oehqh b list
	int Randomolor = rand.nextInt(Allolor.size());
	Allolor.get(Randomolor).click();Thread.sleep(3000);
	String Expectedolor=Allolor.get(Randomolor).getAttribute("option-label");
	String Actualolor=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] span[class='swatch-attribute-selected-option']")).getText();
Assert.assertEquals(Actualolor, Expectedolor);
	
	//WebElement lorContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
	WebElement lik=driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
	lik.click();
	
	
	WebElement sg=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
	String suess=sg.getText();
	Assert.assertEquals(suess.contains("add"), true);
}

	@AfterTest
	public void enftest() {
	}
}
