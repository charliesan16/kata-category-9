package com.test;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
            adminPage.inputEmployeeNameCreateUser("HENRY");
            adminPage.inputUserNameCreateUser("1daniel1234");
            adminPage.inputConfirmPasswordCreateUser("daniel123");
            adminPage.buttonSaveUser();
            utils.waitForPageLoad(driver.get());
            adminPage.validateSaveUser("1daniel1234");
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    /**
     * edit user admin.
     */
    @Test
    public void ModifyUser() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("Admin");
            loginPage.inputPassWord("admin123");
            loginPage.clickLoginButton();
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin();
            utils.waitForPageLoad(driver.get());
            adminPage.editUser("1daniel1234");
            utils.waitForPageLoad(driver.get());
            adminPage.validateTextEditUser();
            adminPage.selectUserRoleEssDropDown();
            adminPage.selectUserStatusDisabledDropDown();
            adminPage.buttonCheckBoxChangePassword();
            adminPage.inputPasswordCreateUser("098daniel12345");
            adminPage.inputConfirmPasswordCreateUser("098daniel12345");
            adminPage.buttonSaveUser();
            utils.waitForPageLoad(driver.get());
            adminPage.validateSaveUser("1daniel1234");
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    /**
     * Remove user.
     */
    @Test
    public void RemoveUser() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("Admin");
            loginPage.inputPassWord("admin123");
            loginPage.clickLoginButton();
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin();
            utils.waitForPageLoad(driver.get());
            adminPage.deleteUser("1daniel1234");
            adminPage.confirmDeleteUser();
            utils.waitForPageLoad(driver.get());
            adminPage.validateDeleteUser("1daniel1234");
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
