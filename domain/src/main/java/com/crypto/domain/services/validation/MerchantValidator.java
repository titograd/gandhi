package com.crypto.domain.services.validation;

//REFACTOR THIS CLASS TO USE TEMPLATE METHOD PATTERN
public class MerchantValidator {
    //TODO:add logging
    public static void validate(String xml) {
        validateBussinessName(xml);
        validateEmail(xml);
        validateFirstName(xml);
        validateSecondName(xml);
        validatePhoneNumber(xml);
        validateAddress(xml);
        validateState(xml);
        validateCountry(xml);
        validateIndustry(xml);
        validatePostalCode(xml);
        validateCity(xml);
        validateStore(xml);
        validatePrimaryWebsite(xml);
        validateShoppingCartOrPosSoftware(xml);
    }

    //TODO implement XPATH reading and validation for all the fields in the incomming XML
    private static void validateBussinessName(String xml) {
//        throw new MerchantDetailsMissingException("Merchant username not provided!");
    }

    private static void validateShoppingCartOrPosSoftware(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validatePrimaryWebsite(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateStore(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateCity(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validatePostalCode(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateIndustry(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateCountry(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateState(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateAddress(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validatePhoneNumber(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateSecondName(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateFirstName(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void validateEmail(String xml) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
