package com.crypto.orm.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class JSONPathToolsTest {

    String registrationJson = "{\n" +
            "    \"BUSINESS_NAME\": \"some company\",\n" +
            "    \"EMAIL\": \"email@mail.com\",\n" +
            "    \"FIRST_NAME\": \"John\",\n" +
            "    \"SECOND_NAME\": \"Smith\",\n" +
            "    \"PHONE_NUMBER\": \"123456789\",\n" +
            "    \"ADDRESS\": \"Rue 13\",\n" +
            "    \"INDUSTRY\": \"Fashion\",\n" +
            "    \"POSTAL_CODE\": \"WS678I\",\n" +
            "    \"CITY\": \"Glasgow\",\n" +
            "    \"STATE\": \"some state\",\n" +
            "    \"COUNTRY\": \"Scotland\",\n" +
            "    \"STORE\": \"This shouldn't be here\",\n" +
            "    \"PRIMARY_WEBSITE\": \"www.primaryWebsite.com\",\n" +
            "    \"SHOPING_CART_ORR_POS_SOFTWARE\": \"POS\"\n" +
            "}";

    @Test
    public void testFindWithJSONPath() throws Exception {
        assertThat(JSONPathTools.findWithJSONPath("CITY",registrationJson),is("Glasgow"));
    }
}
