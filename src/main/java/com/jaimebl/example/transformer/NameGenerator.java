package com.jaimebl.example.transformer;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Created by Jaime on 12/02/2015.
 */
public class NameGenerator implements org.eclipse.persistence.oxm.XMLNameTransformer {

    // Use the unqualified class name as our root element name.
    //Expected: "com.jaimebl.example.CustomerName"
    //Result: "customer-name"
    public String transformRootElementName(String name) {

        String className = StringUtils.decapitalize( getClassName(name) );
        return camelCaseToHyphen(className);
    }

    // The same algorithm as root element name plus "Type" appended to the end.
    //Expected "com.jaimebl.example.CustomerName"
    //Result "CustomerNameType"
    public String transformTypeName(String name) {
        return getClassName(name) + "Type";
    }

    //Expected "_customerName"
    //Result "customer-name"
    public String transformElementName(String name) {
        return camelCaseToHyphen( name ).substring(1);
    }

    //Expected "_customerName"
    //Result "customer-name"
    // The original name converted to upper-case.
    public String transformAttributeName(String name) {
        return camelCaseToHyphen(name).substring(1);
    }

    private String getClassName( String fullName ){
        return fullName.substring(fullName.lastIndexOf('.') + 1);
    }

    // The name will be lower-case with word breaks represented by '-'.
    // Note:  A capital letter in the original name represents the start of a new word.
    private String camelCaseToHyphen( String camelCase ){
        StringBuilder strBldr = new StringBuilder();
        for (char character : camelCase.toCharArray()) {
            if (Character.isUpperCase(character)) {
                strBldr.append('-');
                strBldr.append(Character.toLowerCase(character));
            } else {
                strBldr.append(character);
            }
        }
        return strBldr.toString();
    }

}
