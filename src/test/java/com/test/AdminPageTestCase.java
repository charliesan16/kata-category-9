package com.test;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.utilities.InteractionLocators;
import com.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.logging.Logger;

/**
 * The type Admin page test case.
 */
public class AdminPageTestCase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Utils utils;
    private LoginPage loginPage;
    private AdminPage adminPage;


    /**
     * Before method.
     *
     * @param caso the caso
     */
    @BeforeMethod
    @Parameters({"Caso"})
    public void beforeMethod(final String caso) {
        utils = new Utils();
        driver.set(utils.createRemoteDriver(caso));
        loginPage = new LoginPage(driver.get());
        adminPage = new AdminPage(driver.get());
        driver.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    /**
     * Create user admin.
     */
    @Test
    public void CreateUserAdmin() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("Admin");
            loginPage.inputPassWord("admin123");
            loginPage.clickLoginButton();
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin();
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAddUsers();
            utils.waitForPageLoad(driver.get());
            adminPage.validateTextAddUser();
            adminPage.selectUserRoleAdminDropDown();
            adminPage.selectUserStatusEnabledDropDown();
            adminPage.inputPasswordCreateUser("daniel123");
            adminPage.inputEmployeeNameCreateUser("Orange");
            adminPage.inputUserNameCreateUser("1daniel1234");
            adminPage.inputConfirmPasswordCreateUser("daniel123");
            adminPage.buttonSaveUser();
            utils.waitForPageLoad(driver.get());
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    /**
     * Tear down.
     */
    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
