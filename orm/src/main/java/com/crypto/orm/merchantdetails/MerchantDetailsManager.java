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

/*
* This class is an adapter that can interact with the database.
* We use Merchant details as an abstraction layer and we map the values
* of the merchant object to the values of the merchandetails object.
* By doing this we avoid using the hibernate module in the domain layer(That would be
* a costly bad practice)
* */

public class MerchantDetailsManager implements MerchantRegistrationServiceAPI {

    @Override
    public void register(String xml) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        try {
        session.save(marshallMerchantDetails(xml));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    //This methods populates an object that is only specific to the persistence layer and inputs into the database
    //the data from the xml.
    private MerchantDetails marshallMerchantDetails(String xml) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setBussinessName(findWithXPath("//REGISTRATION/BUSINESS_NAME",xml));
        merchantDetails.setEmail(findWithXPath("//REGISTRATION/EMAIL", xml));
        merchantDetails.setPhoneNumber(findWithXPath("//REGISTRATION/PHONE_NUMBER", xml));
        merchantDetails.setFirstName(findWithXPath("//REGISTRATION//FIRST_NAME", xml));
        merchantDetails.setSecondName(findWithXPath("//REGISTRATION//SECOND_NAME", xml));
        merchantDetails.setAddress(findWithXPath("//REGISTRATION//ADDRESS", xml));
        merchantDetails.setIndustry(findWithXPath("//REGISTRATION/INDUSTRY", xml));
        merchantDetails.setPostalCode(findWithXPath("//REGISTRATION//POSTAL_CODE", xml));
        merchantDetails.setCity(findWithXPath("//REGISTRATION//CITY", xml));
        merchantDetails.setState(findWithXPath("//REGISTRATION//STATE", xml));
        merchantDetails.setCountry(findWithXPath("//REGISTRATION//COUNTRY", xml));
        merchantDetails.setStore(findWithXPath("//REGISTRATION//STORE", xml));
        merchantDetails.setPrimaryWebsite(findWithXPath("//REGISTRATION//PRIMARY_WEBSITE", xml));
        merchantDetails.setShopingCartOrPosSoftware(findWithXPath("//REGISTRATION//SHOPING_CART_ORR_POS_SOFTWARE", xml));
        return merchantDetails;
    }

    private String findWithXPath(String expression, String xml) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        InputSource source = new InputSource(new StringReader(xml));
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(source);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        return xpath.evaluate(expression,document);
    }
}
