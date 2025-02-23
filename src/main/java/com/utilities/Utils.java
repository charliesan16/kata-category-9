package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

/**
 * Clase de utilidades para interacciones comunes en Selenium.
 */
@SuppressWarnings("checkstyle:LineLength")
public class Utils {
    /**
     * logger.
     */
    private static final Logger UTILS_LOGGER = Logger.getLogger("BdbUtils");
    /**
     * driver.
     */
    private WebDriver driver;
    /**
     * Url para conectarse con browserstack.
     */
    private static final String BROWSERSTACK_URL = "https://hub-cloud.browserstack.com/wd/hub";
    /**
     * Time explicit wait 10 seconds.
     */
    private static final int EXPLICIT_WAIT_30_SECOND = 30;
    /**
     * Establece el controlador WebDriver para su uso en las utilidades.
     *
     * @param newWebDriver El controlador WebDriver a establecer.
     */
    public void setDriver(final WebDriver newWebDriver) {
        this.driver = newWebDriver;
    }

    /**
     * Realiza un desplazamiento en la ventana
     * del navegador en las coordenadas especificadas.
     *
     * @param x La cantidad de desplazamiento horizontal.
     * @param y La cantidad de desplazamiento vertical.
     */
    public void scroll(final int x, final int y) {
        try {
            UTILS_LOGGER.info("Inicio método scroll");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
            UTILS_LOGGER.info("Fin método scroll");
        } catch (Exception e) {
            UTILS_LOGGER.info("Método fallido" + e.getMessage());
        }
    }

    /**
     * Waits for the web page to load completely.
     *
     * @throws AssertionError If the timeout
     *                        expires or the element is not found.
     * @param newDriver WebDriver instance to control the browser.
     */
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:MagicNumber"})
    public void waitForPageLoad(final WebDriver newDriver) {
        try {
            WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(EXPLICIT_WAIT_30_SECOND));
            wait.pollingEvery(Duration.ofMillis(300));
            wait.ignoring(Exception.class);
            wait.until((Function<WebDriver, Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
            );

            UTILS_LOGGER.info("La página ha cargado completamente.");
        } catch (TimeoutException e) {
            throw new AssertionError("Se excedió el tiempo de espera mientras se esperaba el elemento", e);
        }
    }
    /**
     * Pausa la ejecución durante la cantidad de milisegundos especificada.
     *
     * @param milliseconds El tiempo de pausa en milisegundos.
     */
    public void pause(final long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
            UTILS_LOGGER.info("Espero 5 segundos para que cargue la página");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Realiza una aserción para comparar dos cadenas de texto.
     *
     * @param text1 La primera cadena de texto a comparar.
     * @param text2 La segunda cadena de texto a comparar.
     */
    public void asserts(final String text1, final String text2) {
        Assert.assertEquals(text1, text2, "Las cadenas no son iguales");
    }

    /**
     * Marca el estado de una prueba en BrowserStack utilizando el API de ejecución.
     *
     * Este método utiliza un script JavaScript para interactuar con la sesión de BrowserStack
     * y definir el estado de la prueba como "passed" o "failed" junto con una razón.
     *
     * @param status el estado del test, debe ser "passed" o "failed".
     * @param reason una descripción del resultado de la prueba.
     * @param driver el WebDriver usado para la sesión actual.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
    public static void markTestStatusBrowserStack(final String status, final String reason,
                                                  final WebDriver driver) {
        if (status == null || (!status.equals("passed") && !status.equals("failed"))) {
            throw new IllegalArgumentException("El estado debe ser 'passed' o 'failed'.");
        }
        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("La razón no puede ser nula o vacía.");
        }
        if (driver == null) {
            throw new IllegalArgumentException("El WebDriver no puede ser nulo.");
        }

        String script = String.format(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"reason\": \"%s\"}}",
                status, reason);

        ((JavascriptExecutor) driver).executeScript(script);
    }

    /**
     * Crea una instancia de RemoteWebDriver configurada para BrowserStack.
     *
     * @param sessionName el nombre de la sesión para identificar pruebas en BrowserStack.
     * @return una instancia de RemoteWebDriver configurada.
     * @throws IllegalArgumentException si el sessionName es nulo o vacío.
     * @throws RuntimeException si la URL de BrowserStack no es válida.
     */
    public RemoteWebDriver createRemoteDriver(final String sessionName) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("sessionName", sessionName);
        capabilities.setCapability("bstack:options", bstackOptions);
        try {
            return new RemoteWebDriver(new URI(BROWSERSTACK_URL).toURL(), capabilities);
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("La URL de BrowserStack es inválida: " + BROWSERSTACK_URL, e);
        }
    }
}
