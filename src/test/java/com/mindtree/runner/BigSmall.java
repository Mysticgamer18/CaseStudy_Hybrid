package com.mindtree.runner;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.AddToCart;
import com.mindtree.pageobjects.AllItem;
import com.mindtree.pageobjects.ContactUs;
import com.mindtree.pageobjects.GiftCard;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.Login;
import com.mindtree.pageobjects.NewsLetter;
import com.mindtree.pageobjects.OfficialMerchandise;
import com.mindtree.pageobjects.SearchItem;
import com.mindtree.pageobjects.SortItem;
import com.mindtree.pageobjects.Wishlist;
import com.mindtree.reusablecomponent.Base;
import com.mindtree.utilities.ReadProperty;

public class BigSmall extends Base{

	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeMethod

	public void BeforeTest() throws Exception {

		log.info("Accessing the property file");

		rp = new ReadProperty();

		log.info("Initializing Browser");

		WebDriver driver = Base.initializeDriver();

		log.info("Invoking the website");

		driver.get(rp.getUrl());

		log.info("Maximizing the window");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void homePage() {

		HomePage hp=new HomePage(driver);

		log.info("Validating Title Image");
		test.info("Verifiying Logo");

		Assert.assertTrue(hp.getTitleImg().isDisplayed());

		log.info("Validating Navigation Bar");
		test.info("Validating Navigation Bar");

		Assert.assertTrue(hp.getNavBar().isDisplayed());

	}

	@Test(priority=10)
	public void loginTest() throws Exception {

		Login l = new Login(driver);

		log.info("CLicking on sign in button");
		test.info("CLicking on sign in button");

		l.getLogin().click();

		FileInputStream fis1=new FileInputStream(rp.getExcelSheetPath());

		XSSFWorkbook workbook=new XSSFWorkbook(fis1);

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> row=sheet.iterator();

		Row firstRow = row.next();

		Row secondRow= row.next();

		Iterator<Cell> cell=firstRow.cellIterator();

		cell.next();

		String name=cell.next().getStringCellValue();

		Iterator<Cell> cell1=secondRow.cellIterator();

		cell1.next();

		String pass=cell1.next().getStringCellValue();

		log.info("Entering username");
		test.info("Entering username");

		l.getUserElement().sendKeys(name);

		log.info("Entering Password");
		test.info("Entering Password");

		l.getUserPass().sendKeys(pass);

		log.info("Click on login");
		test.info("Click on login");

		l.getSignin().click();

		Thread.sleep(5000);

		log.info("Entered username= "+name);
		log.info("Entered password= "+pass);

		Assert.assertTrue(l.getMyAccount().isDisplayed());

		log.error("Sign in failed");

		workbook.close();
	}

	@Test(priority=2)
	public void SearchItem() throws InterruptedException {

		SearchItem si=new SearchItem(driver);

		log.info("Entering text into the search bar");
		test.info("Entering text into the search bar");

		si.getSearchBar().click();

		Thread.sleep(2000);

		si.getSearchBar().sendKeys("Iron Man",Keys.ENTER);

		Thread.sleep(2000);

		log.info("Product displayed");

		Assert.assertTrue(si.getSearchItem().isDisplayed());
	}

	@Test(priority=3)
	public void GiftCard() throws InterruptedException {

		GiftCard gc=new GiftCard(driver);

		test.info("Clicking on GiftCard");
		log.info("Clicking on GiftCard");

		gc.getGiftCard().click();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		test.info("Enter post code in post code column");
		log.info("Enter post code in post code column");

		gc.getPostCode().click();

		gc.getPostCode().sendKeys("400014");

		log.info("Desired Message is displayed");

		gc.getCodeCheck().click();

		WebDriverWait wait=new WebDriverWait(driver,5);

		wait.until(ExpectedConditions.visibilityOf(gc.getCodeText()));

		Assert.assertEquals(gc.getCodeText().getText(),"Cash on Delivery is available.");

		test.info("PostCode check");

	}

	@Test(priority=4)
	public void OfficialMerch() throws InterruptedException {

		OfficialMerchandise om=new OfficialMerchandise(driver);

		Actions a=new Actions(driver);

		log.info("Hovered over Official Merchandise Tab");
		test.info("Hovered over Official Merchandise Tab");

		a.moveToElement(om.getOfficialMerchandise()).build().perform();

		Thread.sleep(2000);

		log.info("Hovered to Marvel Merchandise in subsection and clicked on it");
		test.info("Hovered to Marvel Merchandise in subsection and clicked on it");

		a.moveToElement(om.getMarvelMerch()).click().build().perform();

		Thread.sleep(2000);

		Assert.assertEquals(om.getVerifiedTitle().getText(),"Marvel Merchandise");

		log.info("Title Verified");

	}


	@Test(priority = 5)
	public void Wishlist() throws InterruptedException {

		Wishlist wl=new Wishlist(driver);

		WebDriverWait wait=new WebDriverWait(driver, 5);

		log.info("Searching an item from the search bar");
		test.info("Searching an item from the search bar");

		wl.getSearchResult().sendKeys("gifts",Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(wl.selectWishlistItem()));

		log.info("Clicked on the desired product");
		test.info("Clicked on the desired product");

		wl.selectWishlistItem().click();

		log.info("Clicked on the Add to wishlist");
		test.info("Clicked on the Add to wishlist");

		wait.until(ExpectedConditions.visibilityOf(wl.addToWishlist()));

		wl.addToWishlist().click();

		log.info("Clicked on View product in wishlist link and naviagated to the page");
		test.info("Clicking on view product link and navigating to wishlist");

		wl.viewWishList().click();

		Thread.sleep(3000);

		wl.closePopup().click();

		Assert.assertTrue(wl.getWishlist().isDisplayed());

		log.info("Product verified");

	}

	@Test(priority = 6, dataProvider = "data")
	public void ContactUs(String Name, String Email, String Message) throws InterruptedException {

		ContactUs cu=new ContactUs(driver);

		test.info("Click on contact us");
		log.info("Click on contact us");

		cu.getContact().click();

		test.info("Name: "+Name+ "entered" );
		log.info("Name entered");

		cu.getContName().sendKeys(Name);

		Thread.sleep(2000);

		test.info("Email: "+Email+ "entered" );
		log.info("Email-id entered");

		cu.getContEmail().sendKeys(Email);

		Thread.sleep(2000);

		test.info("Message entered");
		log.info("Message entered");

		cu.getContMessage().sendKeys(Message);

		Thread.sleep(2000);

		test.info("Click on submit");
		log.info("Click on submit");

		cu.getContSubmit().click();

		Thread.sleep(3000);

		Assert.assertTrue(cu.getThanksMessage().isDisplayed());

		test.warning("May fail sometimes due to random captcha request");
		log.warn("Random Captcha Verification Request");
	}

	@Test(priority=7)
	public void AllofIt() {

		AllItem ai=new AllItem(driver);

		test.info("Clicking on All Of It section from Navigation Bar");
		log.info("Clicking on All Of It section from Navigation Bar");

		ai.getAllofIt().click();

		test.info("Clicking on next page button");
		log.info("Clicking on next page button");

		ai.getNextPage().click();

		log.info("Verifying Next Page is displayed");

		Assert.assertTrue(ai.getNewItem().isDisplayed());

	}

	@Test(priority=8)
	public void sortItem() {

		SortItem so=new SortItem(driver);

		test.info("Clicking on Secret Santa Gifts section from Navigation Bar");
		log.info("Clicking on  Secret Santa Gifts section from Navigation Bar");

		so.getSecretSantaGifts().click();

		WebElement sort=so.getSortItem();

		test.info("Clicking on Sort and choose the Best Selling option from the dropdown");
		log.info("Clicking on Sort and choose the Best Selling option from the dropdown");

		sort.click();

		sort.sendKeys(Keys.ARROW_DOWN);

		sort.sendKeys(Keys.ARROW_DOWN);

		sort.sendKeys(Keys.ENTER);

		Assert.assertEquals(so.getSortCheck().getText(),"Hot Seller");

		log.info("Best Selling Products displayed");	

	}

	@Test(priority=9)
	public void AddtoCart() throws InterruptedException {

		AddToCart ac=new AddToCart(driver);

		test.info("Clicking on cart");
		log.info("Clicked on cart");

		ac.clickCart().click();

		test.info("Selecting the item");
		log.info("Selecting the item");

		ac.getSelectedItem().click();

		test.info("Adding the item to cart");
		log.info("Adding the item to cart");

		ac.AddItem().click();

		test.info("Clicking on checkout");
		log.info("Click on checkout");

		ac.getCheckout().click();

		Thread.sleep(900);

		log.info("Closing the popup");

		ac.closeWAPopup().click();

		Thread.sleep(3000);

		Assert.assertTrue(ac.getSummary().isDisplayed());

		test.info("Product succesfully added to cart and checkout and Order Summary displayed");
		log.info("Order Summary displayed sucessfully");

	}

	@Test(priority=11)
	public void signupNewsLetter() throws InterruptedException {

		NewsLetter nl=new NewsLetter();

		test.info("Entering email-id in Newsletter text box");
		log.info("Entering email-id in Newsletter text box");

		nl.getNewsLetter().sendKeys("testbymanish@gmail.com");

		test.info("Click on Sign Up Now");
		log.info("Click on Sign Up Now");

		nl.getSignup().click();

		String newTab = null;

		String mainTab=driver.getWindowHandle();

		for(String handle : driver.getWindowHandles()) {

			if (!handle.equals(mainTab)) {

				driver.switchTo().window(handle);				

				newTab=driver.getTitle();

				WebDriverWait wait=new WebDriverWait(driver, 5);

				wait.until(ExpectedConditions.titleContains(newTab));

				driver.close();

			}

		}

		Thread.sleep(2000);

		driver.switchTo().window(mainTab);

		Assert.assertEquals(newTab, "Newsletter");

	}

	@AfterMethod

	public void teardown() throws InterruptedException {

		log.info("driver closed");

		driver.close();

	}


	@DataProvider
	public Object[][] data() {

		Object[][] data = new Object[1][3];

		data[0][0] = "testman";

		data[0][1] = "testman@gmail.com";

		data[0][2] = "Beautiful Website";

		return data;

	}

}
