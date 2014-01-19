package com.crypto.orm.utils;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static com.jayway.jsonpath.JsonPath.read;

public class JSONPathTools {

    public static String findWithJSONPath(String element, String json) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        return read(json, element);
    }
}
