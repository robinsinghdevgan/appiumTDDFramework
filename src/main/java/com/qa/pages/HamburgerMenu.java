package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HamburgerMenu extends BaseTest {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Out')]")
    private MobileElement signOutBtn;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Set')]")
    private MobileElement settingsBtn;

    public LoginPage signOut()
    {
        waitForVisibility(signOutBtn);
        waitForClickablity(signOutBtn);
        signOutBtn.click();
        return new LoginPage();
    }

}
