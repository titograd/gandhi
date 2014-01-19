package com.crypto.orm.merchantdetails;


import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.orm.entities.MerchantDetails;
import com.crypto.orm.utils.HibernateUtils;
import org.hibernate.Session;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

import static com.crypto.orm.utils.JSONPathTools.findWithJSONPath;
import static com.crypto.orm.utils.XPathTools.findWithXPath;

/*
* This class is an adapter that can interact with the database.
* We use Merchant details as an abstraction layer and we map the values
* of the merchant object to the values of the merchandetails object.
* By doing this we avoid using the hibernate module in the domain layer(That would be
* a costly bad practice)
* */

public class MerchantDetailsManager implements MerchantRegistrationServiceAPI {

    private MerchantDetails merchantDetails = new MerchantDetails();

    @Override
    public void register(String input) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        try {
        session.save(marshallMerchantDetails(input));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    //This methods populates an object that is only specific to the persistence layer and inputs into the database
    //the data from the xml.
    private MerchantDetails marshallMerchantDetails(String input) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        if(isXML(input)) {
            parseXML(input);
        }
        else {
            parseJSON(input);
        }
    return merchantDetails;
    }

    private boolean isXML(String input) {
        return input.startsWith("<");
    }

    private MerchantDetails parseXML(String input) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        merchantDetails.setBussinessName(findWithXPath("//REGISTRATION/BUSINESS_NAME",input));
        merchantDetails.setEmail(findWithXPath("//REGISTRATION/EMAIL", input));
        merchantDetails.setPhoneNumber(findWithXPath("//REGISTRATION/PHONE_NUMBER", input));
        merchantDetails.setFirstName(findWithXPath("//REGISTRATION//FIRST_NAME", input));
        merchantDetails.setSecondName(findWithXPath("//REGISTRATION//SECOND_NAME", input));
        merchantDetails.setAddress(findWithXPath("//REGISTRATION//ADDRESS", input));
        merchantDetails.setIndustry(findWithXPath("//REGISTRATION/INDUSTRY", input));
        merchantDetails.setPostalCode(findWithXPath("//REGISTRATION//POSTAL_CODE", input));
        merchantDetails.setCity(findWithXPath("//REGISTRATION//CITY", input));
        merchantDetails.setState(findWithXPath("//REGISTRATION//STATE", input));
        merchantDetails.setCountry(findWithXPath("//REGISTRATION//COUNTRY", input));
        merchantDetails.setStore(findWithXPath("//REGISTRATION//STORE", input));
        merchantDetails.setPrimaryWebsite(findWithXPath("//REGISTRATION//PRIMARY_WEBSITE", input));
        merchantDetails.setShopingCartOrPosSoftware(findWithXPath("//REGISTRATION//SHOPING_CART_ORR_POS_SOFTWARE", input));
        return merchantDetails;
    }

    private MerchantDetails parseJSON(String input) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        merchantDetails.setBussinessName(findWithJSONPath("BUSINESS_NAME", input));
        merchantDetails.setEmail(findWithJSONPath("EMAIL", input));
        merchantDetails.setPhoneNumber(findWithJSONPath("PHONE_NUMBER", input));
        merchantDetails.setFirstName(findWithJSONPath("FIRST_NAME", input));
        merchantDetails.setSecondName(findWithJSONPath("SECOND_NAME", input));
        merchantDetails.setAddress(findWithJSONPath("ADDRESS", input));
        merchantDetails.setIndustry(findWithJSONPath("INDUSTRY", input));
        merchantDetails.setPostalCode(findWithJSONPath("POSTAL_CODE", input));
        merchantDetails.setCity(findWithJSONPath("CITY", input));
        merchantDetails.setState(findWithJSONPath("STATE", input));
        merchantDetails.setCountry(findWithJSONPath("COUNTRY", input));
        merchantDetails.setStore(findWithJSONPath("STORE", input));
        merchantDetails.setPrimaryWebsite(findWithJSONPath("PRIMARY_WEBSITE", input));
        merchantDetails.setShopingCartOrPosSoftware(findWithJSONPath("SHOPING_CART_ORR_POS_SOFTWARE", input));
        return merchantDetails;
    }
}
