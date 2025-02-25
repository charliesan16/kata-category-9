package com.utilities;

import com.relevantcodes.extentreports.ExtentReports;

import java.util.Locale;

public final class Reports {
    private Reports() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Obtiene una instancia de ExtentReports con la configuración específica.
     *
     * @param servicio El servicio para el que se genera el informe.
     * @return Una instancia de ExtentReports configurada.
     */
    @SuppressWarnings("checkstyle:LineLength")
    public static ExtentReports getInstance(final String servicio) {
        ExtentReports extent;
        String path = "reports/" + servicio + ".html";
        extent = new ExtentReports(path, false, Locale.ENGLISH);
        extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo("Platform", "Mac");
        return extent;
    }
}
