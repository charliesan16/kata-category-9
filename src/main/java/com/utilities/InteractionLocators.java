package com.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

/**
 * The type Interaction locators.
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:MagicNumber"})
public class InteractionLocators {
    /**
     * Driver de la clase ShadowDom.
     */
    private WebDriver driver;

    /**
     * logger.
     */
    private static final Logger UTILS_LOGGER = Logger.getLogger("InteractionLocators");

    /**
     * Variable tiempo explicito.
     */
    private static final int EXPLICIT_WAIT_30_SECOND = 30;

    /**
     * Instantiates a new.
     *
     * @param newWebDriver the new web driver
     */
    public InteractionLocators(final WebDriver newWebDriver) {
        this.driver = newWebDriver;
        PageFactory.initElements(
                new AjaxElementLocatorFactory(newWebDriver, 5), this);
    }


    /**
     * Performs a "sendKeys" operation on an element using JavaScript
     * and ensures the system detects the input.
     *
     * @param by   The locator (By) used to find the element.
     * @param data The data to be entered into the element.
     */
    public void findElementJavascriptSendKeys(final By by, final String data) {
        try {
            UTILS_LOGGER.info("Esperando que el input sea visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            UTILS_LOGGER.info("Se agrega el valor al input: " + data);
            // Establecer el valor del input
            js.executeScript("arguments[0].value = arguments[1];", element, data);
            UTILS_LOGGER.info("Se disparan eventos para simular una escritura real");
            // Disparar eventos para simular una escritura real
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", element);
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
            js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", element); // Simular que el usuario dejó el campo

        } catch (TimeoutException e) {
            throw new AssertionError("COMMENT_TIME_OUT: " + by.toString(), e);
        } catch (NoSuchElementException e) {
            throw new AssertionError("COMMENT_ELEMENT_NOT_FOUND: " + by.toString(), e);
        }
    }


    /**
     * Performs a "click" operation on an element using JavaScript.
     *
     * @param by The By locator that identifies the element to be clicked.
     */
    public void findElementJavascriptClick(final By by) {
        try {
            UTILS_LOGGER.info("Esperando que el botón sea visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            UTILS_LOGGER.info("Se hace click el valor: " + by);
            // Hacer clic en el botón
            js.executeScript("arguments[0].click();", element);
        } catch (TimeoutException e) {
            throw new AssertionError("COMMENT_TIME_OUT: " + by.toString(), e);
        } catch (NoSuchElementException e) {
            throw new AssertionError("COMMENT_ELEMENT_NOT_FOUND: " + by.toString(), e);
        }
    }

    /**
     * Waits for an element's text to match the expected text using WebDriverWait.
     * If the element is inside a Shadow DOM, it retrieves the text using JavaScript.
     *
     * @param locator      The By locator to identify the element.
     * @param expectedText The expected text to compare.
     */
    public void findElementJavascriptGetText(final By locator, final String expectedText) {
        try {
            UTILS_LOGGER.info("Esperando que el texto sea visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String actualText = null;

            UTILS_LOGGER.info("Intentando obtener el texto usando JavaScript...");

            try {
                Object scriptResult = js.executeScript("return arguments[0].textContent;", element);
                actualText = (scriptResult != null) ? scriptResult.toString().trim() : "";
            } catch (Exception e) {
                UTILS_LOGGER.info("Fallo al obtener el texto con JavaScript, usando getText()" + e);
                actualText = element.getText().trim(); // Fallback al método estándar
            }

            UTILS_LOGGER.info("Texto obtenido: '" + actualText + "'");

            // Comparar los textos
            if (actualText.equals(expectedText)) {
                UTILS_LOGGER.info("Texto localizado correctamente: " + actualText);
            } else {
                throw new AssertionError(String.format(
                        "Expected text '%s' but found '%s' in element located by: %s",
                        expectedText, actualText, locator));
            }
        } catch (TimeoutException e) {
            throw new AssertionError(
                    "Timeout exceeded while waiting for text in element: " + locator, e);
        }
    }

    /**
     * Find element javascript click drop down.
     *
     * @param by the by
     */
    public void findElementJavascriptClickDropDown(final By by) {
        try {
            UTILS_LOGGER.info("Esperando que el botón dropdown sea visible...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(by));
            UTILS_LOGGER.info("Se hace click el valor: " + by);
            dropdown.click();
        } catch (TimeoutException e) {
            throw new AssertionError("COMMENT_TIME_OUT: " + by.toString(), e);
        } catch (NoSuchElementException e) {
            throw new AssertionError("COMMENT_ELEMENT_NOT_FOUND: " + by.toString(), e);
        }
    }


}
