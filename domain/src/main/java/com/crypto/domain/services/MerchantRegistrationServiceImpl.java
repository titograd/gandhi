package com.crypto.domain.services;

import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.core.Merchant;

import static com.crypto.domain.services.validation.MerchantValidator.validate;

public class MerchantRegistrationServiceImpl implements MerchantRegistrationService {

    private MerchantRegistrationServiceAPI merchantRegistrationServiceAPI;

    public MerchantRegistrationServiceImpl(MerchantRegistrationServiceAPI merchantRegistrationServiceAPI) {
        this.merchantRegistrationServiceAPI = merchantRegistrationServiceAPI;
    }

    @Override
    public void register(Merchant merchant) {
        validate(merchant);
        merchantRegistrationServiceAPI.register(merchant);
    }


}
