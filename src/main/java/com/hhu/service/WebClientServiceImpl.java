package com.hhu.service;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.hhu.entities.User;

import java.io.IOException;

public class WebClientServiceImpl implements WebClientService {

    private HtmlPage page;

    private DomElement submit;

    private final String login = "http://ids.hhu.edu.cn/amserver/UI/Login";

    private final String _goto = "http://form.hhu.edu.cn:80/pdc/formDesignApi/S/gUTwwojq";

    private final int timeout = 100;

    @Override
    public boolean checkIn(User user) throws IOException {
        WebClient webClient = WebClientBuilder.build();
        page = webClient.getPage(login);
        webClient.waitForBackgroundJavaScript(timeout);
        if (page == null) {
            return false;
        }
        page.getFormByName("frm1").getInputByName("IDToken1").type(user.getId());
        page.getFormByName("frm2").getInputByName("IDToken2").type(user.getPassword());
        page.getFormByName("Login").getInputByName("goto").setAttribute("value",_goto);
        for (DomElement img : page.getElementsByTagName("img")) {
            if (img.hasAttribute("onclick")) {
                submit = img;
                break;
            }
        }
        page = submit.click();
        webClient.waitForBackgroundJavaScript(timeout);
        page = page.getElementsByTagName("a").get(0).click();

        webClient.waitForBackgroundJavaScript(timeout);
        page = page.getElementsByTagName("button").get(0).click();
        return true;
    }
}
