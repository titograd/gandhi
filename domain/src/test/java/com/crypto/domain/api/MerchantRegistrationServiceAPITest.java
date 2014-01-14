package com.crypto.domain.api;

import com.crypto.domain.core.Merchant;
import com.crypto.domain.core.errors.MerchantDetailsMissingException;
import com.crypto.domain.services.MerchantRegistrationService;
import com.crypto.domain.services.MerchantRegistrationServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MerchantRegistrationServiceAPITest {

    public  Merchant MERCHANT_WITHOUT_PASSWORD = new Merchant("username",null, "");
    public  Merchant MERCHANT_WITHOUT_USERNAME = new Merchant(null,"password", "");

    @Test(expected = MerchantDetailsMissingException.class)
    public void whenRegisteringAMerchantWithoutUsernameThereWillBeAnException() throws Exception {
        MerchantRegistrationService merchantRegistrationService = getInstance();
        merchantRegistrationService.register(MERCHANT_WITHOUT_USERNAME);
    }

    @Test(expected = MerchantDetailsMissingException.class)
    public void whenRegisteringAMerchantWithoutPasswordThereWillBeAnException() throws Exception {
        MerchantRegistrationService merchantRegistrationService = getInstance();
        merchantRegistrationService.register(MERCHANT_WITHOUT_PASSWORD);
    }


    private MerchantRegistrationService getInstance() {
        return new MerchantRegistrationServiceImpl(mock(MerchantRegistrationServiceAPI.class));
    }
}
