package com.compdevbooks.util;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * An utility class that apply regular expressions to validate several values.
 * This class also access a file named RegularExpressions.properties to obtain internationalized error messages according to the applied regular expression.
 */
public class RegularExpressions {

    private final static HashMap<String,String> expressions = new HashMap<>();
    private static ResourceBundle bundle;
    static {
        expressions.put("NAME","[A-Za-z]{5,60}");
        expressions.put("PHONE","([0-9]{2,3} [0-9]{3,5}-[0-9]{4}");
        expressions.put("NATIONAL_REGISTER","\\w+");
        expressions.put("TITLE","");
        expressions.put("COMISSION_PERCENTAGE","[0-9]+");
        try {
            bundle = ResourceBundle.getBundle("RegularExpressions");
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }

    public static String validate(String key, String value) throws Exception {
        String regExp = expressions.get(key);
        if (regExp==null) throw new Exception("No regular expression found for " + key);
        return value.matches(regExp)?null:bundle.getString(key);
    }

}
