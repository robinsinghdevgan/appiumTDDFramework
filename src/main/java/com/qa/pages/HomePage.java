package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BaseTest {
    @AndroidFindBy(id = "worklist_count_button")
    @iOSXCUITFindBy(id = "worklist_count_button")
    private MobileElement workListCountButton;

    private PersistentNavigationBar pnBar;

    public ApprovalsPage gotoApprovalsPage(){
        pnBar.clickApprovalsButton();
        return new ApprovalsPage();
    }

    public SupportPage gotoSupportPage(){
        pnBar.clickSupportButton();
        return new SupportPage();
    }
}
