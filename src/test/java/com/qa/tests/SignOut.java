package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.HamburgerMenu;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SignOut extends BaseTest {
    TestUtils utils = new TestUtils();
    HomePage hp;

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        hp = new HomePage();
    }

    @Test(priority = 6)
    public void signOutFromHomeScreen()
    {
        HamburgerMenu hm = hp.openHamburgerMenu();
        hm.signOut();
    }
}
