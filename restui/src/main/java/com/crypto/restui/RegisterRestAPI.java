package com.crypto.restui;

import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.core.Merchant;
import com.crypto.domain.services.MerchantRegistrationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.*;

@Path("register")
public class RegisterRestAPI {

    private MerchantRegistrationService merchantRegistrationService;

    public RegisterRestAPI(MerchantRegistrationService merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }

    //TODO: Change this to a post method and get parameters from a form
    @GET
    @Produces(TEXT_PLAIN)
    public String register() {
        Merchant merchant = new Merchant();
        merchant.setUsername("fakeUserName");
        merchant.setPassword("fakePassword");
        merchant.setEmail("fakeEmail");
        merchantRegistrationService.register(merchant);
        return "Registered! ";
    }
}
