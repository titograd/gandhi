package com.crypto.restui;

import com.crypto.domain.services.MerchantRegistrationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.status;

@Path("register")
public class RegisterRestAPI {

    private MerchantRegistrationService merchantRegistrationService;

    public RegisterRestAPI(MerchantRegistrationService merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }

    //IMPORTANT NOTE: Dont use JAXB in this side of the communication. We don't want to tight couple to the domain of the user
    // interface(We don't care what the UI domain objects are, thats why we write our own mappings)
    @POST
    @Consumes({"application/xml","application/json"})
    @Produces({"application/xml","application/json"})
    public Response register(String registrationForm) {
        merchantRegistrationService.register(registrationForm);
        return status(OK).build();
    }
}
