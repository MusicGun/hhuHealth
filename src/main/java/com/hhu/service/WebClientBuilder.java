package com.hhu.service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

import java.util.logging.Level;

public class WebClientBuilder {


    private static WebClient webClient = new WebClient(BrowserVersion.CHROME);


    public static WebClient build() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http.client").setLevel(Level.OFF);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        webClient.getOptions().setActiveXNative(false);

        webClient.getOptions().setCssEnabled(true);

        webClient.getOptions().setJavaScriptEnabled(true);

        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        return webClient;
    }


}
