package com.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
     *
     * @param test the test
     */
    public void selectOptionAdmin(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta seleccionar la opción admin.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_ADMIN);
            test.log(LogStatus.INFO, "Ingresó a la ventana de admin.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Admin : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select option add users.
     *
     * @param test the test
     */
    public void selectOptionAddUsers(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta seleccionar la opción agregar usuarios.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_ADD_USER);
            test.log(LogStatus.INFO, "Ingresó a la ventana de agregar usuarios.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción agregar usuarios : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Validate text add user.
     *
     * @param test the test
     */
    public void validateTextAddUser(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta validar el texto de add user, despues de a ver dado click en la opción.");
            interactionLocators.findElementJavascriptGetText(Locators.AdminPage.LOCATOR_ADD_USER_TEXT, Locators.AdminPage.TEXT_ADD_USER);
            test.log(LogStatus.INFO, "Se validó el texto add user");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo validar el texto Add User : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Validate text Edit user.
     *
     * @param test the test
     */
    public void validateTextEditUser(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta validar el texto de edit user, despues de a ver dado click en la opción.");
            interactionLocators.findElementJavascriptGetText(Locators.AdminPage.LOCATOR_EDIT_USER_TEXT, Locators.AdminPage.TEXT_EDIT_USER);
            test.log(LogStatus.INFO, "Se validó el texto edit user");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo validar el texto edit User : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select user role admin drop down.
     *
     * @param test the test
     */
    public void selectUserRoleAdminDropDown(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Role.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_ROLE);
            test.log(LogStatus.INFO, "Se desplego el dropdwon Role.");
            test.log(LogStatus.INFO, "Intenta dar click en la opcion Admin.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_ROLE_ADMIN);
            test.log(LogStatus.INFO, "Selecciono la opción Admin");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Admin : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select user role ess drop down.
     *
     * @param test the test
     */
    public void selectUserRoleEssDropDown(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Role.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_ROLE);
            test.log(LogStatus.INFO, "Se desplego el dropdwon Role.");
            test.log(LogStatus.INFO, "Intenta dar click en la opcion ESS.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_ROLE_ESS);
            test.log(LogStatus.INFO, "Selecciono la opción ESS");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción ESS : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select user status enabled drop down.
     *
     * @param test the test
     */
    public void selectUserStatusEnabledDropDown(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Status.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_STATUS);
            test.log(LogStatus.INFO, "Se desplego el dropdwon Status.");
            test.log(LogStatus.INFO, "Intenta dar click en la opcion Enabled.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_STATUS_ENABLED);
            test.log(LogStatus.INFO, "Selecciono la opción Enabled");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Enabled : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select user status disabled drop down.
     *
     * @param test the test
     */
    public void selectUserStatusDisabledDropDown(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el dropdwon Status.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_BUTTON_DROPDOWN_LIST_STATUS);
            test.log(LogStatus.INFO, "Se desplego el dropdwon Status.");
            test.log(LogStatus.INFO, "Intenta dar click en la opcion Disabled.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_OPTION_LIST_STATUS_DISABLED);
            test.log(LogStatus.INFO, "Selecciono la opción Disabled");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción Disabled : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Input password create user.
     *
     * @param password the password
     * @param test     the test
     */
    public void inputPasswordCreateUser(final String password, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Digita valor en el input password para editar");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_PASSWORD_CREATE_USER, password);
            test.log(LogStatus.INFO, "Termino de ingresar valor en el input password para editar");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input password : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Input confirm password create user.
     *
     * @param password the password
     * @param test     the test
     */
    public void inputConfirmPasswordCreateUser(final String password, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Digita valor en el input confirm password");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_CONFIRM_PASSWORD_CREATE_USER, password);
            test.log(LogStatus.INFO, "Termino de ingresar valor en el input confirm password");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input confirm password : " + e.getMessage());
            throw e;
        }
    }


    /**
     * Input employee name create user.
     *
     * @param name the name
     * @param test the test
     */
    public void inputEmployeeNameCreateUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el dropdwon EmployeeName.");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_EMPLOYEE_NAME_CREATE_USER, name);
            test.log(LogStatus.INFO, "Se desplego el dropdwon EmployeeNames.");
            test.log(LogStatus.INFO, "Intenta dar click en la opcion EmployeeName.");
            interactionLocators.findElementJavascriptClickDropDown(Locators.AdminPage.LOCATOR_INPUT_EMPLOYEE_NAME_OPTION_CREATE_USER);
            test.log(LogStatus.INFO, "Selecciono la opción EmployeeName");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No se pudo seleccionar la opción EmployeeName : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Input user name create user.
     *
     * @param name the name
     * @param test the test
     */
    public void inputUserNameCreateUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Digita valor en el input username");
            interactionLocators.findElementJavascriptSendKeys(Locators.AdminPage.LOCATOR_INPUT_USERNAME_CREATE_USER, name);
            test.log(LogStatus.INFO, "Termino de ingresar valor en el input username");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El valor no se pudo digitar en el input username : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Button save user.
     *
     * @param test the test
     */
    public void buttonSaveUser(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el botón save.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_SAVE_CREATE_USER);
            test.log(LogStatus.INFO, "Termino de dar click en el botón save.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón save : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Validate save user.
     *
     * @param name the name
     * @param test the test
     */
    public void validateSaveUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta validar que el usuario se guardo.");
            interactionLocators.isElementPresent(Locators.AdminPage.LOCATOR_VALIDATE_CREATE_USER, name);
            //interactionLocators.isUserPresentAndStatusCorrect(Locators.AdminPage.LOCATOR_VALIDATE_CREATE_USER, name,  status);
            test.log(LogStatus.INFO, "Termino de valdiar que el usuario se guardo.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón save : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Validate delete user.
     *
     * @param name the name
     * @param test the test
     */
    public void validateDeleteUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta validar que el usuario se elimino.");
            interactionLocators.isElementNotPresent(Locators.AdminPage.LOCATOR_VALIDATE_CREATE_USER, name);
            //interactionLocators.isUserPresentAndStatusCorrect(Locators.AdminPage.LOCATOR_VALIDATE_CREATE_USER, name,  status);
            test.log(LogStatus.INFO, "Termino de validar que el usuario se elimino.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "El usuario aun esta en la lista : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Edit user.
     *
     * @param name the name
     * @param test the test
     */
    public void editUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el botón editar el usuario.");
            interactionLocators.clickButtonInUserRow(Locators.AdminPage.LOCATOR_VALIDATE_USER, Locators.AdminPage.LOCATOR_BUTTON_EDIT_USER, name);
            test.log(LogStatus.INFO, "Termino de dar click en el botón editar el usuario.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón editar el usuario : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Delete user.
     *
     * @param name the name
     * @param test the test
     */
    public void deleteUser(final String name, final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el botón eliminar el usuario: .");
            interactionLocators.clickButtonInUserRow(Locators.AdminPage.LOCATOR_VALIDATE_USER, Locators.AdminPage.LOCATOR_BUTTON_DELETE_USER, name);
            test.log(LogStatus.INFO, "Termino de dar click en el botón eliminar el usuario.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón eliminar el usuario : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Confirm delete user.
     *
     * @param test the test
     */
    public void confirmDeleteUser(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta dar click en el botón eliminar el usuario en la ventana de confirmación.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_BUTTON_CONFIRM_DELETE_USER);
            test.log(LogStatus.INFO, "Termino de dar click en el botón eliminar el usuario en la ventana de confirmació.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón eliminar el usuario en la ventana de confirmación : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Button check box change password.
     *
     * @param test the test
     */
    public void buttonCheckBoxChangePassword(final ExtentTest test) {
        try {
            test.log(LogStatus.INFO, "Intenta darle click en el botón checkbox para change password.");
            interactionLocators.findElementJavascriptClick(Locators.AdminPage.LOCATOR_CHECK_BOX_CHANGE_PASSWORD);
            test.log(LogStatus.INFO, "Termino de darle click en el botón checkbox para change password.");
        } catch (AssertionError e) {
            test.log(LogStatus.ERROR, "No puedo dar click en el botón save : " + e.getMessage());
            throw e;
        }
    }

}
