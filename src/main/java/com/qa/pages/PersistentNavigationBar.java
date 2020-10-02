package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PersistentNavigationBar extends BaseTest {
    @AndroidFindBy(accessibility = "Home")
    @iOSXCUITFindBy(id = "homeButton")
    private MobileElement homeButton;

    @AndroidFindBy(accessibility = "Approvals")
    @iOSXCUITFindBy(id = "approvalsButton")
    private MobileElement approvalsButton;

    @AndroidFindBy(accessibility = "Support")
    @iOSXCUITFindBy(id = "supportButton")
    private MobileElement supportButton;

    public PersistentNavigationBar()
    {
        waitForVisibility(homeButton);
        waitForVisibility(approvalsButton);
        waitForVisibility(supportButton);
    }

    public ApprovalsPage clickApprovalsButton() {
        click(approvalsButton, "Click on Approvals Button in persistent navigation bar");
        return new ApprovalsPage();
    }

    public HomePage clickHomeButton() {
        waitForClickablity(homeButton);
        click(homeButton, "Click on Home Button in persistent navigation bar");
        return new HomePage();
    }

    public void clickHomeButtonReturnVoid() {
        waitForClickablity(homeButton);
        click(homeButton, "Click on Home Button in persistent navigation bar");
    }

    public void clickSupportButton() {
        waitForClickablity(supportButton);
        click(supportButton, "Click on Support Button in persistent navigation bar");
    }
}
