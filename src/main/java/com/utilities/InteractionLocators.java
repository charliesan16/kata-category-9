package com.utilities;


import junit.framework.Assert;
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
import java.util.List;
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
            //js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", element); // Simular que el usuario dejó el campo

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

    /**
     * Is element present.
     *
     * @param usernameLocator  the username locator
     * @param expectedUsername the expected username
     */
    public void isElementPresent(final By usernameLocator, final String expectedUsername) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));

            String actualUsername = element.getText().trim(); // Extraer el texto y limpiar espacios

            if (actualUsername.equals(expectedUsername)) {
                System.out.println("El usuario guardado es correcto: " + actualUsername);
            } else {
                Assert.fail("ERROR: El usuario esperado era '" + expectedUsername + "', pero se encontró '" + actualUsername + "'.");
            }

        } catch (TimeoutException e) {
            Assert.fail("ERROR: No se encontro el usuario esperado en la lista: " + expectedUsername);
        }
    }

    /**
     * Is element not present.
     *
     * @param usernameLocator  the username locator
     * @param expectedUsername the expected username
     */
    public void isElementNotPresent(final By usernameLocator, final String expectedUsername) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            boolean isNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(usernameLocator));

            if (isNotPresent) {
                System.out.println("El usuario ya no está presente en la lista: " + expectedUsername);
            } else {
                Assert.fail("ERROR: El usuario esperado aún está presente en la lista: " + expectedUsername);
            }
        } catch (TimeoutException e) {
            System.out.println("Confirmado: El usuario no se encuentra en la lista: " + expectedUsername);
        }
    }

    /**
     * Is user present and status correct.
     *
     * @param usernameLocator  the username locator
     * @param expectedUsername the expected username
     * @param shouldBeEnabled  the should be enabled
     */
    public void isUserPresentAndStatusCorrect(By usernameLocator, String expectedUsername, boolean shouldBeEnabled) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Esperar a que los elementos sean visibles
            List<WebElement> userElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(usernameLocator));

            System.out.println("🔍 Usuarios encontrados en la tabla: " + userElements.size());

            boolean userFound = false;

            for (WebElement userElement : userElements) {
                // Extraer solo el nombre de usuario
                WebElement usernameDiv = userElement.findElement(By.xpath("."));
                String actualUsername = usernameDiv.getText().trim().replaceAll("\\s+", ""); // Eliminar espacios y saltos de línea

                System.out.println("📌 Usuario encontrado en la UI (procesado): '" + actualUsername + "'");
                System.out.println("🔎 Comparando con esperado: '" + expectedUsername + "'");

                if (actualUsername.equalsIgnoreCase(expectedUsername.trim().replaceAll("\\s+", ""))) {
                    userFound = true;

                    // Obtener la fila completa del usuario
                    WebElement rowElement = userElement.findElement(By.xpath("./ancestor::div[contains(@class, 'oxd-table-row')]"));

                    // Buscar la celda de estado dentro de la misma fila
                    WebElement statusElement = rowElement.findElement(By.xpath(".//div[contains(@class, 'oxd-table-cell')][last()]"));
                    String actualStatus = statusElement.getText().trim();
                    boolean isEnabled = actualStatus.equalsIgnoreCase("Enabled");

                    System.out.println("🟢 Estado encontrado para '" + expectedUsername + "': '" + actualStatus + "'");
                    System.out.println("🔎 Se espera que el usuario esté: " + (shouldBeEnabled ? "Enabled" : "Disabled"));

                    // Validar estado del usuario
                    if (isEnabled != shouldBeEnabled) {
                        String expectedStatus = shouldBeEnabled ? "Enabled" : "Disabled";
                        Assert.fail("❌ ERROR: Se esperaba que el usuario '" + expectedUsername + "' estuviera " + expectedStatus + ", pero se encontró '" + actualStatus + "'.");
                    }

                    System.out.println("✅ El usuario '" + expectedUsername + "' está presente y tiene el estado correcto: " + actualStatus);
                    break;
                }
            }

            // Si no se encontró el usuario en ninguna fila, lanzar error
            if (!userFound) {
                Assert.fail("❌ ERROR: No se encontró el usuario esperado en la lista: '" + expectedUsername + "'");
            }

        } catch (TimeoutException e) {
            Assert.fail("⏳ ERROR: Tiempo de espera agotado al buscar el usuario: '" + expectedUsername + "'");
        } catch (NoSuchElementException e) {
            Assert.fail("🚫 ERROR: No se encontró un elemento esperado en la fila del usuario: '" + expectedUsername + "'");
        }
    }


    /**
     * Click button in user row.
     *
     * @param usernameLocator the username locator
     * @param buttonLocator   the button locator
     * @param username        the username
     */
    public void clickButtonInUserRow(final By usernameLocator, final By buttonLocator, final String username) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            WebElement userRow = wait.until(ExpectedConditions.presenceOfElementLocated(usernameLocator));

            // Encuentra el botón dentro de la fila del usuario
            WebElement actionButton = userRow.findElement(buttonLocator);
            actionButton.click();
            System.out.println("✅ Se hizo clic en el botón dentro de la fila del usuario: " + username);
        } catch (TimeoutException e) {
            Assert.fail("❌ ERROR: No se encontró el usuario '" + username + "' en la tabla.");
        } catch (NoSuchElementException e) {
            Assert.fail("❌ ERROR: No se encontró el botón en la fila del usuario '" + username + "'.");
        }
    }


}
