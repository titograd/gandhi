package com.crypto.domain.services.validation;

import com.crypto.domain.core.Merchant;
import com.crypto.domain.core.errors.MerchantDetailsMissingException;

public class MerchantValidator {
    //TODO:add logging
    public static void validate(Merchant merchant) {
        userNameNotNull(merchant);
        passwordNotNull(merchant);
    }

    private static void userNameNotNull(Merchant merchant) {
        if(merchant.getUsername() == null)
            throw new MerchantDetailsMissingException("Merchant username not provided!");
    }
    private static void passwordNotNull(Merchant merchant) {
        if(merchant.getPassword() == null)
            throw new MerchantDetailsMissingException("Merchant password not provided!");
    }
}
