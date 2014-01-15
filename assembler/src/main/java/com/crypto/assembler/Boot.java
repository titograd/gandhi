package com.crypto.assembler;

import com.crypto.domain.services.MerchantRegistrationService;
import com.crypto.domain.services.MerchantRegistrationServiceImpl;
import com.crypto.orm.merchantdetails.MerchantDetailsManager;
import com.crypto.servletui.uisetup.GandhiTomcatServer;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class Boot {

    public static void main(String[] args) {

        MerchantDetailsManager merchantDetailsManager = new MerchantDetailsManager();
        MerchantRegistrationService merchantRegistrationService = new MerchantRegistrationServiceImpl(merchantDetailsManager);
        GandhiTomcatServer gandhiTomcatServer = new GandhiTomcatServer(merchantRegistrationService);
        try {
            gandhiTomcatServer.start();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
