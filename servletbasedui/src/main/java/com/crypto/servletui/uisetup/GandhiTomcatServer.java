package com.crypto.servletui.uisetup;
    import com.crypto.domain.services.MerchantRegistrationService;
    import com.crypto.servletui.registration.RegistrationServlet;
    import org.apache.catalina.Context;
    import org.apache.catalina.LifecycleException;
    import org.apache.catalina.startup.Tomcat;

    import javax.servlet.ServletException;
    import java.io.File;


public class GandhiTomcatServer {

        private MerchantRegistrationService merchantRegistrationService;

        public GandhiTomcatServer(MerchantRegistrationService merchantRegistrationService) {
            this.merchantRegistrationService = merchantRegistrationService;
        }

        public void start() throws ServletException, LifecycleException {
            String webappDirLocation = "servletbasedui/src/main/webapp/";
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
            tomcat.addServlet(context,"registration servlet", new RegistrationServlet(merchantRegistrationService));
            context.addServletMapping("/register", "registration servlet");

            tomcat.start();
            tomcat.getServer().await();
        }
}
