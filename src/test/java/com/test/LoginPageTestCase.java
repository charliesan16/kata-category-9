package com.test;

import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.utilities.Utils;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestCase {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Utils utils;
    private LoginPage loginPage;
    private ExtentReports report;

    @BeforeMethod
    @Parameters({"Caso"})
    public void beforeMethod(final String caso) {
        utils = new Utils();
        driver.set(utils.createRemoteDriver(caso));
        loginPage = new LoginPage(driver.get());
        driver.get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void LoginInvalidCredentials() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputUserName("123");
            loginPage.inputPassWord("123");
            loginPage.clickLoginButton();
            utils.waitForPageLoad(driver.get());
            loginPage.compareTextInvalidCredential();
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    @Test
    public void LoginUserNameRequired() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.inputPassWord("123");
            loginPage.clickLoginButton();
            loginPage.compareTextInputUserNameRequired();
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    @Test
    public void LoginInputsEmptyRequired() {
        try {
            utils.waitForPageLoad(driver.get());
            loginPage.clickLoginButton();
            loginPage.compareTextInputUserNameRequired();
            loginPage.compareTextInputPassWordRequired();
            utils.markTestStatusBrowserStack("passed", "Resultado esperado", driver.get());
        } catch (Exception e) {
            utils.markTestStatusBrowserStack("failed", "Resultado inesperado", driver.get());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
