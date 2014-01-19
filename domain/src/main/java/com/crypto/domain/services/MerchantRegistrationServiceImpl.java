package com.crypto.domain.services;

import com.crypto.domain.api.MerchantRegistrationServiceAPI;

import static com.crypto.domain.services.validation.MerchantValidator.validate;

public class MerchantRegistrationServiceImpl implements MerchantRegistrationService {

    private MerchantRegistrationServiceAPI merchantRegistrationServiceAPI;

    public MerchantRegistrationServiceImpl(MerchantRegistrationServiceAPI merchantRegistrationServiceAPI) {
        this.merchantRegistrationServiceAPI = merchantRegistrationServiceAPI;
    }

    @Override
    public void register(String input) {
        validate(input);
        merchantRegistrationServiceAPI.register(input);
    }


}
