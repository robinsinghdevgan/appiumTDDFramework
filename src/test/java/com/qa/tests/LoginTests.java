package com.qa.tests;

import com.qa.pages.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
public class LoginTests extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	JSONObject loginUsers;
	TestUtils utils = new TestUtils();
	
	  @BeforeClass
	  public void beforeClass() throws Exception {
			InputStream datais = null;
		  try {
			  String dataFileName = "data/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  loginUsers = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		  closeApp();
		  launchApp();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		  loginPage = new LoginPage();
	  }

	  @AfterMethod
	  public void afterMethod() {		  
	  }

	  @Test(priority = 0)
	  public void emptyFieldsLogin(){
	  	loginPage.pressLoginBtnButReturnVoid();
	  	utils.log().info(loginPage.getErrTxt());
	  	loginPage.clickOk();
	  }

	@Test(priority = 1)
	public void justUserNameLogin(){
		loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginPage.pressLoginBtnButReturnVoid();
		utils.log().info(loginPage.getErrTxt());
		loginPage.clickOk();
	}

	@Test(priority = 2)
	public void justPasswordLogin(){
	  	loginPage.clearUName();
		loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
		loginPage.pressLoginBtnButReturnVoid();
		utils.log().info(loginPage.getErrTxt());
		loginPage.clickOk();
	}

	  @Test(priority = 3)
	  public void invalidUserName() {
		  loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
		  loginPage.pressLoginBtnButReturnVoid();
		  utils.log().info(loginPage.getErrTxt());
		  loginPage.clickOk();
	  }
	  
	  @Test(priority = 4)
	  public void invalidPassword() {
		  loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
		  loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
		  loginPage.pressLoginBtnButReturnVoid();
		  utils.log().info(loginPage.getErrTxt());
		  loginPage.clickOk();
	  }

	@Test(priority = 5)
	public void successfulLogin() throws InterruptedException {
		loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
		HomePage h = loginPage.pressLoginBtn();
		//waitForVisibility(spinner);
		//return h;
	}
}
