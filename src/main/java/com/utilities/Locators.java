package com.utilities;

import org.openqa.selenium.By;

/**
 * Clase para definir los localizadores de cada página.
 */
@SuppressWarnings("checkstyle:LineLength")
public final class Locators {
    /**
     * Constructor privado para evitar la instanciación de esta clase.
     */
    private Locators() {
        // Constructor privado para cumplir con las reglas de utilidad.
    }

    /**
     * The type Login page.
     */
    public static final class LoginPage {

        private LoginPage() {
        }

        /**
         * The constant LOCATOR_INPUT_USERNAME.
         */
        public static final By LOCATOR_INPUT_USERNAME = By.cssSelector("input[name='username']");
        /**
         * The constant LOCATOR_INPUT_PASSWORD.
         */
        public static final By LOCATOR_INPUT_PASSWORD = By.cssSelector("input[name='password']");
        /**
         * The constant LOCATOR_BUTTON_LOGIN.
         */
        public static final By LOCATOR_BUTTON_LOGIN = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        /**
         * The constant LOCATOR_TEXT_INVALID_CREDENTIALS.
         */
        public static final By LOCATOR_TEXT_INVALID_CREDENTIALS = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > div > div.oxd-alert.oxd-alert--error > div.oxd-alert-content.oxd-alert-content--error > p");
        /**
         * The constant TEXT_INVALID_CREDENTIALS.
         */
        public static final String TEXT_INVALID_CREDENTIALS = "Invalid credentials";
        /**
         * The constant LOCATOR_USERNAME_TEXT_REQUIRED.
         */
        public static final By LOCATOR_USERNAME_TEXT_REQUIRED = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > span");
        /**
         * The constant LOCATOR_PASSWORD_TEXT_REQUIRED.
         */
        public static final By LOCATOR_PASSWORD_TEXT_REQUIRED = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > span");
        /**
         * The constant TEXT_REQUIRED.
         */
        public static final String TEXT_REQUIRED = "Required";
    }

    /**
     * The type Admin page.
     */
    public static final class AdminPage {
        private AdminPage() {
        }

        /**
         * The constant LOCATOR_BUTTON_ADMIN.
         */
        public static final By LOCATOR_BUTTON_ADMIN = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a");

        /**
         * The constant LOCATOR_BUTTON_ADD_USER.
         */
        public static final By LOCATOR_BUTTON_ADD_USER = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button");

        /**
         * The constant LOCATOR_ADD_USER_TEXT.
         */
        public static final By LOCATOR_ADD_USER_TEXT = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6");

        /**
         * The constant TEXT_ADD_USER.
         */
        public static final String TEXT_ADD_USER = "Add User";
        /**
         * The constant LOCATOR_EDIT_USER_TEXT.
         */
        public static final By LOCATOR_EDIT_USER_TEXT = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6");

        /**
         * The constant TEXT_ADD_USER.
         */
        public static final String TEXT_EDIT_USER = "Edit User";


        /**
         * The constant LOCATOR_BUTTON_DROPDOWN_LIST_ROLE.
         */
        public static final By LOCATOR_BUTTON_DROPDOWN_LIST_ROLE = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div");

        /**
         * The constant LOCATOR_OPTION_LIST_ROLE_ADMIN.
         */
        public static final By LOCATOR_OPTION_LIST_ROLE_ADMIN = By.xpath("//div[@role='option' and span[text()='" + "Admin" + "']]");

        /**
         * The constant LOCATOR_OPTION_LIST_ROLE_ESS.
         */
        public static final By LOCATOR_OPTION_LIST_ROLE_ESS = By.xpath("//div[@role='option' and span[text()='" + "ESS" + "']]");

        /**
         * The constant LOCATOR_BUTTON_DROPDOWN_LIST_STATUS.
         */
        public static final By LOCATOR_BUTTON_DROPDOWN_LIST_STATUS = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div");
        /**
         * The constant LOCATOR_OPTION_LIST_STATUS_ENABLED.
         */
        public static final By LOCATOR_OPTION_LIST_STATUS_ENABLED = By.xpath("//div[@role='option' and span[text()='" + "Enabled" + "']]");
        /**
         * The constant LOCATOR_OPTION_LIST_STATUS_DISABLED.
         */
        public static final By LOCATOR_OPTION_LIST_STATUS_DISABLED = By.xpath("//div[@role='option' and span[text()='" + "Disabled" + "']]");
        /**
         * The constant LOCATOR_INPUT_PASSWORD_CREATE_USER.
         */
        public static final By LOCATOR_INPUT_PASSWORD_CREATE_USER = By.cssSelector(".user-password-cell input");
        /**
         * The constant LOCATOR_INPUT_CONFIRM_PASSWORD_CREATE_USER.
         */
        public static final By LOCATOR_INPUT_CONFIRM_PASSWORD_CREATE_USER = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input");
        /**
         * The constant LOCATOR_INPUT_EMPLOYEE_NAME_CREATE_USER.
         */
        public static final By LOCATOR_INPUT_EMPLOYEE_NAME_CREATE_USER = By.xpath("//input[@placeholder='Type for hints...']");
        /**
         * The constant Locator_INPUT_EMPLOYEE_NAME_OPTION_CREATE_USER.
         */
        public static final By LOCATOR_INPUT_EMPLOYEE_NAME_OPTION_CREATE_USER = By.xpath("//div[contains(@class, 'oxd-autocomplete-dropdown')]//div[contains(normalize-space(), 'Henry Middle name Last Name')]\n");
        /**
         * The constant LOCATOR_INPUT_USERNAME_CREATE_USER.
         */
        public static final By LOCATOR_INPUT_USERNAME_CREATE_USER = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(4) > div > div:nth-child(2) > input");

        /**
         * The constant LOCATOR_BUTTON_SAVE_CREATE_USER.
         */
        public static final By LOCATOR_BUTTON_SAVE_CREATE_USER = By.xpath("//button[contains(@class, 'oxd-button--secondary')]");

        /**
         * The constant LOCATOR_VALIDATE_USER.
         */
        public static final By LOCATOR_VALIDATE_USER = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='1daniel1234']/ancestor::div[contains(@class, 'oxd-table-row')]");
        /**
         * The constant LOCATOR_VALIDATE_CREATE_USER.
         */
        public static final By LOCATOR_VALIDATE_CREATE_USER = By.xpath("//div[@class='oxd-table']//div[contains(@class,'oxd-table-cell')][normalize-space()='1daniel1234']\n");


        /**
         * The constant LOCATOR_BUTTON_EDIT_USER.
         */
        public static final By LOCATOR_BUTTON_EDIT_USER = By.xpath(".//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-pencil-fill')]]");

        /**
         * The constant LOCATOR_BUTTON_DELETE_USER.
         */
        public static final By LOCATOR_BUTTON_DELETE_USER = By.xpath(".//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-trash')]]");

        /**
         * The constant LOCATOR_BUTTON_CONFIRM_DELETE_USER.
         */
        public static final By LOCATOR_BUTTON_CONFIRM_DELETE_USER = By.cssSelector("#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > div.orangehrm-modal-footer > button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin");

        /**
         * The constant LOCATOR_CHECK_BOX_CHANGE_PASSWORD.
         */
        public static final By LOCATOR_CHECK_BOX_CHANGE_PASSWORD = By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row > div > div:nth-child(5) > div > div:nth-child(2) > div > label > span");
    }
}
