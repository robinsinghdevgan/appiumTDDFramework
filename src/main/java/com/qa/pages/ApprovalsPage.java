package com.qa.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ApprovalsPage {
    @AndroidFindBy(id = "worklist")
    @iOSXCUITFindBy(id = "worklist")
    private WorkListItem[] worklist;

    @AndroidFindBy(id = "sort")
    @iOSXCUITFindBy(id = "sort")
    private MobileElement sortButton;

    @AndroidFindBy(id = "filter")
    @iOSXCUITFindBy(id = "filter")
    private MobileElement filterButton;

    @AndroidFindBy(id = "sortname")
    @iOSXCUITFindBy(id = "sortname")
    private MobileElement sortNameButton;

    @AndroidFindBy(id = "filtername")
    @iOSXCUITFindBy(id = "filtername")
    private MobileElement filterNameButton;



}
