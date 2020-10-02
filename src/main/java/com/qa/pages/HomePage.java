package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import jdk.nashorn.internal.objects.NativeMath;

public class HomePage extends BaseTest {
    @AndroidFindBy(id = "worklist_count_button")
    @iOSXCUITFindBy(id = "worklist_count_button")
    private MobileElement workListCountButton;

    @AndroidFindBy(accessibility = "EarndTile")
    private MobileElement reqApprovalCountButton;

    @AndroidFindBy(accessibility = "OK")
    private MobileElement hamburgerMenuButton;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    private MobileElement progressBar;

    public HomePage()
    {
        /*if(progressBar.isDisplayed()) {
            try {
                waitForInvisibility(progressBar);
            } catch (org.openqa.selenium.NoSuchElementException e)// || org.openqa.selenium.TimeoutException e)
            {
                TestUtils utils = new TestUtils();
                utils.log().error("ProgressBar not found");
            }
        }*/
        waitForInvisibility(progressBar,12,3);
        waitForVisibility(reqApprovalCountButton);
    }

    public HamburgerMenu openHamburgerMenu()
    {
        click(hamburgerMenuButton, "Clicking on hamburger menu button");
        return new HamburgerMenu();
    }

    public PersistentNavigationBar getPersistentNavBar()
    {
        return new PersistentNavigationBar();
    }

    public String getTitle()
    {
        return null;
    }
}
