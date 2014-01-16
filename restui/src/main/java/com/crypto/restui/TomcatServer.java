package com.crypto.restui;


import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.services.MerchantRegistrationService;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.init.JerseyServletContainerInitializer;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer {

    private MerchantRegistrationService merchantRegistrationService;

    public TomcatServer(MerchantRegistrationService merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }


    public void start() throws ServletException, LifecycleException {
        String webappDirLocation = "restui/src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        // tomcat.setHost(new StandardHost());
        tomcat.setPort(Integer.valueOf(webPort));
        //This tells tomcat where the webapp is(all resources)
        Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        //System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        //Create the servlet and pass it to the container
        tomcat.addServlet(context,"jersey-container-servlet",resourceConfig());
        context.addServletMapping("/register", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private ServletContainer resourceConfig() {
        return new ServletContainer(new ResourceConfig().register(new RegisterRestAPI(merchantRegistrationService)));
    }
}
