package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WorkListItem extends BaseTest {
    @AndroidFindBy(id = "expand")
    @iOSXCUITFindBy(id = "expand")
    private MobileElement expandButton;

    @AndroidFindBy(id = "//*[contains(@text,'Approve')]")
    @iOSXCUITFindBy(id = "approve")
    private MobileElement approveButton;

    @AndroidFindBy(id = "rej")
    @iOSXCUITFindBy(id = "rej")
    private MobileElement rejButton;

    @AndroidFindBy(id = "info")
    @iOSXCUITFindBy(id = "info")
    private MobileElement infoButton;


    public DetailsPage clickInfoButton(){
        click(infoButton, "Clicked on InfoButton under expanded view");
        return new DetailsPage();
    }
}
