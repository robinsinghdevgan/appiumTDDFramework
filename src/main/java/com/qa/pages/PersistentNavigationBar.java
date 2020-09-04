package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PersistentNavigationBar extends BaseTest {
    @AndroidFindBy(id = "homeButton")
    @iOSXCUITFindBy(id = "homeButton")
    private MobileElement homeButton;

    @AndroidFindBy(id = "approvalsButton")
    @iOSXCUITFindBy(id = "approvalsButton")
    private MobileElement approvalsButton;

    @AndroidFindBy(id = "supportButton")
    @iOSXCUITFindBy(id = "supportButton")
    private MobileElement supportButton;


    public void clickApprovalsButton() {
        click(approvalsButton, "Click on Approvals Button in persistent navigation bar");
    }

    public void clickHomeButton() {
        click(homeButton, "Click on Approvals Button in persistent navigation bar");
    }

    public void clickSupportButton() {
        click(supportButton, "Click on Approvals Button in persistent navigation bar");
    }
}
