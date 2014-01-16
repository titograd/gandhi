package com.crypto.servletui.registration;


import com.crypto.domain.core.Merchant;
import com.crypto.domain.services.MerchantRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet{

    private MerchantRegistrationService merchantRegistrationService;

    public RegistrationServlet(MerchantRegistrationService merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        merchantRegistrationService.register(
                configureMerchant(
                        req.getParameter("username"),
                        req.getParameter("password"),
                        req.getParameter("email")));
        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("<h1>Registered!</h1>");
        resp.flushBuffer();
    }

    private Merchant configureMerchant(String username,String password,String email) {
        Merchant merchant = new Merchant();
        merchant.setUsername(username);
        merchant.setPassword(password);
        merchant.setEmail(email);
        return merchant;
    }
}
