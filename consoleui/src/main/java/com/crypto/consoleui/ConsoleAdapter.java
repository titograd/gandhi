package com.crypto.consoleui;

import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.core.Merchant;
import com.crypto.domain.services.MerchantRegistrationServiceImpl;

/*
The purpose of this addapter is not to be used in real life, it is just a
quick way of quering the service layer to manipulate data
 */
public class ConsoleAdapter  implements MerchantRegistrationServiceAPI {

    private MerchantRegistrationServiceImpl merchantRegistrationService;

    public ConsoleAdapter(MerchantRegistrationServiceImpl merchantRegistrationService) {
        this.merchantRegistrationService = merchantRegistrationService;
    }

    @Override
    public void register(Merchant merchant) {
        merchantRegistrationService.register(merchant);
    }
}
