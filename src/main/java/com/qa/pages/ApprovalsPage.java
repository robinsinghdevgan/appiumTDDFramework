package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class ApprovalsPage extends BaseTest {
    @AndroidFindBy(xpath = "(//ancestor::*[*[contains(@text,'Time')]])")
    private List<MobileElement> worklist;

    @AndroidFindBy(xpath = "//*[contains(@text,'Approve')]")
    private MobileElement approveBtn;
    String approveBtnXpath = "/following-sibling::*//*[contains(@text,'Approve')]";

    @AndroidFindBy(xpath = "//*[contains(@text,'etail')]")
    private MobileElement detailsBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'nfirm')]")
    private MobileElement confirmButton;

    @AndroidFindBy(xpath = "//ancestor::*[android.widget.Button[contains(@text,'nfirm')]]//android.widget.ImageButton")
    private MobileElement crossButton;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    private MobileElement progressBar;

    @AndroidFindBy(xpath = "//*[contains(@text,'otes')]")
    private MobileElement notesTxtField;

    @AndroidFindBy(xpath = "//*[contains(@text,'Sort')]")
    private MobileElement sortButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'Filter')]")
    private MobileElement filterButton;

    @AndroidFindBy(accessibility = "OK")
    private MobileElement hamburgerMenuButton;

    @AndroidFindBy(id = "sortname")
    private MobileElement sortNameButton;

    @AndroidFindBy(id = "filtername")
    private MobileElement filterNameButton;

    public ApprovalsPage(){
        waitForInvisibility(progressBar, 30, 5);
        waitForVisibility(sortButton);
        waitForVisibility(filterButton);
        waitForClickablity(sortButton);
        waitForClickablity(filterButton);
    }

    public List<MobileElement> getWorklist()
    {
        return worklist;
    }

    public void tapWorklistItem(MobileElement worklistItem){
        click(worklistItem, "Tapped on worklist item");
    }

    public void clickonApproveButton() {
        waitForVisibility(approveBtn);
        click(approveBtn, "Clicked on Approve Button");
    }

    public DetailsPage clickOnDetailButton(){
        waitForClickablity(detailsBtn);
        click(detailsBtn, "Clicked on Details Button");
        return new DetailsPage();
    }

    public void clickonConfirmButton() {
        click(confirmButton, "Clicked on Confirm Button");
    }

    public void addComments(String cmt){
        sendKeys(notesTxtField, cmt, "Adding comments");
    }

    public void clickOnCrossButton(){
        click(crossButton, "Clicked on Cross Button");
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
}
