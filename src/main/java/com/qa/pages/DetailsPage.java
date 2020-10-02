package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class DetailsPage extends BaseTest {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Approve')]")
    private MobileElement approveBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Other')]")
    private MobileElement otherActionsBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'nfirm')]")
    private MobileElement confirmButton;

    @AndroidFindBy(xpath = "//ancestor::*[android.widget.Button[contains(@text,'nfirm')]]//android.widget.ImageButton")
    private MobileElement crossButton;

    @AndroidFindBy(xpath = "//android.widget.ProgressBar")
    private MobileElement progressBar;

    @AndroidFindBy(xpath = "//*[contains(@text,'otes')]")
    private MobileElement notesTxtField;

    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "(//ancestor::*[*[contains(@text,'nfirm')]]//android.widget.Button)[1]")
    private MobileElement dropDown;

    @AndroidFindBy(xpath = "(//ancestor::*[*[contains(@text,'nfirm')]])//*[contains(@text, 'Reject')]")
    private MobileElement rejectBtn;

    public DetailsPage(){
        waitForInvisibility(progressBar,12,4);
        waitForVisibility(otherActionsBtn);
        waitForClickablity(approveBtn);
    }

    public void clickonApproveButton() {
        waitForVisibility(approveBtn);
        click(approveBtn, "Clicked on Approve Button");
    }

    public void clickOnOtherActionsButton(){
        waitForClickablity(otherActionsBtn);
        click(otherActionsBtn, "Clicked on Other Actions Button");
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

    public ApprovalsPage clickOnBackButton() {
        click(backButton, "Clicked on Back button");
        return new ApprovalsPage();
    }

    public void clickOnDropDown(){
        click(dropDown, "Clicked on Drop Down");
        waitForClickablity(rejectBtn);
    }

    public void clickOnRejectButton(){
        click(rejectBtn, "Clicked on Reject Button");
    }
}
