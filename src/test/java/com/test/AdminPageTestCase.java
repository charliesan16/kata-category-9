package com.test;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Reports;
import com.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
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
    private static ExtentReports report = Reports.getInstance("Reporte_Case_User"); // Instancia única
    private ExtentTest test;


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
        test = report.startTest(caso);
        driver.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    /**
     * Create user admin.
     */
    @Test
    public void CreateUserAdmin() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("Admin",test);
            loginPage.inputPassWord("admin123",test);
            loginPage.clickLoginButton(test);
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin(test);
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAddUsers(test);
            utils.waitForPageLoad(driver.get());
            adminPage.validateTextAddUser(test);
            adminPage.selectUserRoleAdminDropDown(test);
            adminPage.selectUserStatusEnabledDropDown(test);
            adminPage.inputPasswordCreateUser("daniel123",test);
            adminPage.inputEmployeeNameCreateUser("isaa",test);
            adminPage.inputUserNameCreateUser("1daniel1234",test);
            adminPage.inputConfirmPasswordCreateUser("daniel123",test);
            adminPage.buttonSaveUser(test);
            utils.waitForPageLoad(driver.get());
            adminPage.validateSaveUser("1daniel1234",test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
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
            loginPage.inputUserName("Admin",test);
            loginPage.inputPassWord("admin123",test);
            loginPage.clickLoginButton(test);
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin(test);
            utils.waitForPageLoad(driver.get());
            adminPage.editUser("1daniel1234",test);
            utils.waitForPageLoad(driver.get());
            adminPage.validateTextEditUser(test);
            adminPage.selectUserRoleEssDropDown(test);
            adminPage.selectUserStatusDisabledDropDown(test);
            adminPage.buttonCheckBoxChangePassword(test);
            adminPage.inputPasswordCreateUser("098daniel12345",test);
            adminPage.inputConfirmPasswordCreateUser("098daniel12345",test);
            adminPage.buttonSaveUser(test);
            utils.waitForPageLoad(driver.get());
            adminPage.validateSaveUser("1daniel1234",test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
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
            loginPage.inputUserName("Admin",test);
            loginPage.inputPassWord("admin123",test);
            loginPage.clickLoginButton(test);
            utils.waitForPageLoad(driver.get());
            adminPage.selectOptionAdmin(test);
            utils.waitForPageLoad(driver.get());
            adminPage.deleteUser("1daniel1234",test);
            adminPage.confirmDeleteUser(test);
            utils.waitForPageLoad(driver.get());
            adminPage.validateDeleteUser("1daniel1234",test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
            throw e;
        }
    }

    /**
     * Tear down.
     */
    @AfterMethod
    @Parameters({"Caso"})
    public void tearDown(final ITestResult result, final String caso) {
        if (test != null) {
            report.endTest(test);
        }
        report.flush(); // Asegura que los cambios se reflejen en el reporte

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
