package com.test;

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

public class LoginPageTestCase {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Utils utils;
    private LoginPage loginPage;
    private static ExtentReports report = Reports.getInstance("Reporte_Case_Login"); // Instancia única
    private ExtentTest test;

    @BeforeMethod
    @Parameters({"Caso"})
    public void beforeMethod(final String caso) {
        utils = new Utils();
        driver.set(utils.createRemoteDriver(caso));
        loginPage = new LoginPage(driver.get());
        test = report.startTest(caso);
        driver.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void LoginInvalidCredentials() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("123",test);
            loginPage.inputPassWord("123",test);
            loginPage.clickLoginButton(test);
            utils.waitForPageLoad(driver.get());
            loginPage.compareTextInvalidCredential(test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
            throw e;
        }
    }

    @Test
    public void LoginUserNameRequired() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputPassWord("123",test);
            loginPage.clickLoginButton(test);
            loginPage.compareTextInputUserNameRequired(test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
            throw e;
        }
    }

    @Test
    public void LoginInputsEmptyRequired() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.clickLoginButton(test);
            loginPage.compareTextInputUserNameRequired(test);
            loginPage.compareTextInputPassWordRequired(test);
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
            test.log(LogStatus.PASS, "Test Exitoso!");
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            test.log(LogStatus.FAIL, "Test Fallido!");
            throw e;
        }
    }

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
