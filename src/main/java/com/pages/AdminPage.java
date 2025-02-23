package com.pages;

import com.utilities.InteractionLocators;
import com.utilities.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * The type Admin page.
 */
@SuppressWarnings("checkstyle:LineLength")
public class AdminPage {

    /**
     * Variable WebDriver.
     */
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    /**
     * Instancia Clase interactionLocator.
     */
    private InteractionLocators interactionLocators;

    /**
     * Instantiates a new Admin page.
     *
     * @param newWebDriver the new web driver
     */
    public AdminPage(final WebDriver newWebDriver) {
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
     * Select option admin.
     */
    public void selectOptionAdmin() {
        try {
            //test.log(LogStatus.INFO, "Intenta seleccionar la opción admin.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_ADMIN);
            //test.log(LogStatus.INFO, "Ingresó a la ventana de admin.");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Admin : " + e.getMessage());
        }
    }

    /**
     * Select option add users.
     */
    public void selectOptionAddUsers() {
        try {
            //test.log(LogStatus.INFO, "Intenta seleccionar la opción agregar usuarios.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_ADD_USER);
            //test.log(LogStatus.INFO, "Ingresó a la ventana de agregar usuarios.");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo seleccionar la opción agregar usuarios : " + e.getMessage());
        }
    }

    /**
     * Validate text add user.
     */
    public void validateTextAddUser() {
        try {
            //test.log(LogStatus.INFO, "Intenta validar el texto de add user, despues de a ver dado click en la opción.");
            interactionLocators.findElementJavascriptGetText(Locators.AdminPage.LOCATOR_ADD_USER_TEXT, Locators.AdminPage.TEXT_ADD_USER);
            //test.log(LogStatus.INFO, "Se validó el texto add user");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo validar el texto Add User : " + e.getMessage());
        }
    }

    /**
     * Select user role admin drop down.
     */
    public void selectUserRoleAdminDropDown() {
        try {
            //test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Role.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_ROLE);
            //test.log(LogStatus.INFO, "Se desplego el dropdwon Role.");
            //test.log(LogStatus.INFO, "Intenta dar click en la opcion Admin.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_ROLE_ADMIN);
            //test.log(LogStatus.INFO, "Selecciono la opción Admin");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Admin : " + e.getMessage());
        }
    }

    /**
     * Select user status enabled drop down.
     */
    public void selectUserStatusEnabledDropDown() {
        try {
            //test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Status.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_STATUS);
            //test.log(LogStatus.INFO, "Se desplego el dropdwon Status.");
            //test.log(LogStatus.INFO, "Intenta dar click en la opcion Enabled.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_STATUS_ENABLED);
            //test.log(LogStatus.INFO, "Selecciono la opción Enabled");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Enabled : " + e.getMessage());
        }
    }

    /**
     * Input password create user.
     *
     * @param password the password
     */
    public void inputPasswordCreateUser(final String password) {
        try {
            //test.log(LogStatus.INFO, "Digita valor en el input password");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_PASSWORD_CREATE_USER, password);
            //test.log(LogStatus.INFO, "Termino de ingresar valor en el input password");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input password : " + e.getMessage());
        }
    }

    /**
     * Input confirm password create user.
     *
     * @param password the password
     */
    public void inputConfirmPasswordCreateUser(final String password) {
        try {
            //test.log(LogStatus.INFO, "Digita valor en el input confirm password");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_CONFIRM_PASSWORD_CREATE_USER, password);
            //test.log(LogStatus.INFO, "Termino de ingresar valor en el input confirm password");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input confirm password : " + e.getMessage());
        }
    }


    public void inputEmployeeNameCreateUser(final String name) {
        try {
            //test.log(LogStatus.INFO, "Intenta dar click en el dropdwon EmployeeName.");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_EMPLOYEE_NAME_CREATE_USER, name);
            //test.log(LogStatus.INFO, "Se desplego el dropdwon EmployeeNames.");
            //test.log(LogStatus.INFO, "Intenta dar click en la opcion EmployeeName.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_INPUT_EMPLOYEE_NAME_OPTION_CREATE_USER);
            //test.log(LogStatus.INFO, "Selecciono la opción EmployeeName");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "No se pudo seleccionar la opción EmployeeName : " + e.getMessage());
        }
    }
    public void inputUserNameCreateUser(final String name) {
        try {
            //test.log(LogStatus.INFO, "Digita valor en el input username");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_USERNAME_CREATE_USER, name);
            //test.log(LogStatus.INFO, "Termino de ingresar valor en el input username");
        } catch (AssertionError e) {
            //test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input username : " + e.getMessage());
        }
    }

}
