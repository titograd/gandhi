package com.crypto.assembler;

import com.crypto.domain.services.MerchantRegistrationService;
import com.crypto.domain.services.MerchantRegistrationServiceImpl;
import com.crypto.orm.merchantdetails.MerchantDetailsManager;
import com.crypto.restui.RegisterRestAPI;
import com.crypto.restui.TomcatServer;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class Boot {

    public static void main(String[] args) {
        //Persistence adapter
        MerchantDetailsManager merchantDetailsManager = new MerchantDetailsManager();
        //Service port
        MerchantRegistrationService merchantRegistrationService = new MerchantRegistrationServiceImpl(merchantDetailsManager);

        TomcatServer tomcatServer = new TomcatServer(merchantRegistrationService);
        try {
            tomcatServer.start();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    //This method is used to create an instance of the application that uses the servlet UI(Needs to be ennabled in the pom)
    /*public static void usingServletUI() {
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
    }*/
}
