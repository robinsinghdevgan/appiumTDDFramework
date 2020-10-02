package com.qa.pages;

import org.openqa.selenium.Keys;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.support.MethodOverride;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseTest {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "spinner")
	protected MobileElement spinner;

	@AndroidFindBy (xpath = "(//android.widget.EditText)[1]")
	@iOSXCUITFindBy (id = "test-Username")
	private MobileElement usernameTxtFld;

	@AndroidFindBy (xpath = "(//android.widget.EditText)[2]")
	@iOSXCUITFindBy (id = "test-Password")
	private MobileElement passwordTxtFld;
	
	@AndroidFindBy (xpath ="//*[contains(@text, 'Login')]")
	@iOSXCUITFindBy (id = "test-LOGIN")
	private MobileElement loginBtn;
	
	@AndroidFindBy (id = "android:id/message")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement errTxt;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement errOk;

	public void clearUName()
	{
		clear(usernameTxtFld);
	}

	public void clearPwd()
	{
		clear(passwordTxtFld);
	}

	public LoginPage()
	{
		waitForVisibility(loginBtn);
		waitForClickablity(usernameTxtFld);
	}

public LoginPage enterUserName(String username) {
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username, "login with " + username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public void pressLoginBtnButReturnVoid()
{
	click(loginBtn, "press login button");
}

public HomePage pressLoginBtn() throws InterruptedException{
	click(loginBtn, "press login button");
	TimeUnit.SECONDS.sleep(20);
	return new HomePage();
}

public HomePage login(String username, String password) throws InterruptedException {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

public String getErrTxt() {
	waitForVisibility(errTxt);
	String err = getText(errTxt, "error text is - ");
	return err;
}

public void clickOk()
{
	waitForVisibility(errOk);
	click(errOk, "Clicked Ok button");
}

}
