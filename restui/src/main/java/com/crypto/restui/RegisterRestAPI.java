package com.crypto.restui;

import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.services.MerchantRegistrationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.*;

@Path("register")
public class RegisterRestAPI {

    private MerchantRegistrationService merchantRegistrationService;

    public RegisterRestAPI(MerchantRegistrationService merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }

    @GET
    @Produces(TEXT_PLAIN)
    public String register() {
        return "Hello!!!!";
    }
}
