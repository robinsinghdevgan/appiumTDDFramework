package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.*;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

public class ApproveTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    JSONObject loginUsers;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginUsers.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null) {
                datais.close();
            }
        }
        closeApp();
        launchApp();
    }

    @AfterClass
    public void afterClass() {
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        loginPage = new LoginPage();
    }

    @Test(enabled = false)
    public void loginAndGotoApprovalsScreen() throws InterruptedException {
        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
        HomePage h = loginPage.pressLoginBtn();
        PersistentNavigationBar pnb = h.getPersistentNavBar();
        ApprovalsPage ap = pnb.clickApprovalsButton();
        List<MobileElement> allWorklistItems = ap.getWorklist();
        if(allWorklistItems.size() < 1)
        {
            utils.log().error("Worklist empty, test failed exiting.");
            //assert
            return;
        }
        MobileElement firstItem = allWorklistItems.get(0);
        ap.tapWorklistItem(firstItem);
        ap.clickonApproveButton();
        ap.addComments("approving123!@#");
        ap.clickOnCrossButton();
        h = pnb.clickHomeButton();
        HamburgerMenu hm = h.openHamburgerMenu();
        hm.signOut();
    }
    @Test()
    public void PoC() throws InterruptedException {
        loginPage.pressLoginBtnButReturnVoid();
        utils.log().info(loginPage.getErrTxt());
        loginPage.clickOk();

        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.pressLoginBtnButReturnVoid();
        utils.log().info(loginPage.getErrTxt());
        loginPage.clickOk();

        loginPage.clearUName();
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtnButReturnVoid();
        utils.log().info(loginPage.getErrTxt());
        loginPage.clickOk();

        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtnButReturnVoid();
        try{
            utils.log().info(loginPage.getErrTxt());
            loginPage.clickOk();
        }catch(Exception e){
            utils.log().error(e.getMessage());
        }

        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));

        HomePage h = loginPage.pressLoginBtn();
        PersistentNavigationBar pnb = h.getPersistentNavBar();
        pnb.clickHomeButtonReturnVoid();
        pnb.clickSupportButton();
        pnb.clickHomeButtonReturnVoid();
        ApprovalsPage ap = pnb.clickApprovalsButton();
        List<MobileElement> allWorklistItems = ap.getWorklist();
        if(allWorklistItems.size() < 1)
        {
            utils.log().error("Worklist empty, test failed exiting.");
            //assert
            return;
        }

        MobileElement firstItem = allWorklistItems.get(0);
        ap.tapWorklistItem(firstItem);
        ap.clickonApproveButton();
        ap.addComments("approving123!@#");
        ap.clickOnCrossButton();

        DetailsPage dp = ap.clickOnDetailButton();
        dp.clickonApproveButton();
        dp.addComments("approving123!@#");
        dp.clickOnCrossButton();
        //ap = dp.clickOnBackButton();

        dp.clickOnOtherActionsButton();
        dp.clickOnDropDown();
        dp.clickOnRejectButton();
        dp.addComments("Rejection123234356647!@#!@##%^$%^*");
        dp.clickOnCrossButton();
        driver.get().navigate().back();
        ap = new ApprovalsPage(); // To Induce progress bar wait

        h = pnb.clickHomeButton();

        HamburgerMenu hm = h.openHamburgerMenu();
        hm.signOut();
    }
}
