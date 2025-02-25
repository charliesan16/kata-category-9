package com.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.InteractionLocators;
import com.utilities.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * The type Login page.
 */
@SuppressWarnings("checkstyle:LineLength")
public class LoginPage {
    /**
     * Variable WebDriver.
     */
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    /**
     * Instancia Clase interactionLocator.
     */
    private InteractionLocators interactionLocators;

    /**
     * Instantiates a new Login page.
     *
     * @param newWebDriver the driver
     */
    public LoginPage(final WebDriver newWebDriver) {
        driverSetup(newWebDriver);
        this.interactionLocators = new InteractionLocators(newWebDriver);
        PageFactory.initElements(new AjaxElementLocatorFactory(newWebDriver, 5), this);
    }

    private static void driverSetup(final WebDriver webDriver) {
        if (driver.get() == null) {
            driver.set(webDriver);
        }
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Input UserName.
     *
     * @param username the username
     * @param test     the test
     */
    public void inputUserName(final String username, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Digita valor en el input USERNAME");
            interactionLocators.findElementJavascriptSendKeys(Locators.LoginPage.LOCATOR_INPUT_USERNAME, username);
            test.log(LogStatus.INFO, "Termino de ingresar valor en el input USERNAME");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input UserName : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Input PassWord.
     *
     * @param password the password
     * @param test     the test
     */
    public void inputPassWord(final String password, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Digita valor en el input PASSWORD");
            interactionLocators.findElementJavascriptSendKeys(Locators.LoginPage.LOCATOR_INPUT_PASSWORD, password);
            test.log(LogStatus.INFO, "Termino de ingresar valor en el input PASSWORD");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input PassWord : " + e.getMessage());
            throw e;
        }

    }

    /**
     * Click login button.
     *
     * @param test the test
     */
    public void clickLoginButton(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Se intenta dar click en el botón Login");
            interactionLocators.findElementJavascriptClick(Locators.LoginPage.LOCATOR_BUTTON_LOGIN);
            test.log(LogStatus.INFO, "Dio Click en el botón Login");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo dar click en el botón : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Compare text invalid credential.
     *
     * @param test the test
     */
    public void compareTextInvalidCredential(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Se intenta comparar el texto esperado con el texto que se localiza Invalid Credential.");
            interactionLocators.findElementJavascriptGetText(Locators.LoginPage.LOCATOR_TEXT_INVALID_CREDENTIALS, Locators.LoginPage.TEXT_INVALID_CREDENTIALS);
            test.log(LogStatus.INFO, "Se logró comparar los dos textos y concuerdan.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo comparar los textos : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Compare text input UserName required.
     *
     * @param test the test
     */
    public void compareTextInputUserNameRequired(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Se intenta comparar el texto esperado con el texto que se localiza Required.");
            interactionLocators.findElementJavascriptGetText(Locators.LoginPage.LOCATOR_USERNAME_TEXT_REQUIRED, Locators.LoginPage.TEXT_REQUIRED);
            test.log(LogStatus.INFO, "Se logró comparar los dos textos y concuerdan.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo comparar los textos : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Compare text input PassWord required.
     *
     * @param test the test
     */
    public void compareTextInputPassWordRequired(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Se intenta comparar el texto esperado con el texto que se localiza Required.");
            interactionLocators.findElementJavascriptGetText(Locators.LoginPage.LOCATOR_PASSWORD_TEXT_REQUIRED, Locators.LoginPage.TEXT_REQUIRED);
            test.log(LogStatus.INFO, "Se logró comparar los dos textos y concuerdan.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo comparar los textos : " + e.getMessage());
            throw e;
        }
    }
}

