package com.talentsprint.otobisnow.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ValidateUtils {
    static Pattern pattern;
    static Matcher matcher;
    public static final String DEFAULT_ENCODING = "UTF-8";
    static BASE64Encoder enc = new BASE64Encoder();
    static BASE64Decoder dec = new BASE64Decoder();
  //  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  //  private static final String BUSNO_PATTERN = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";

    public ValidateUtils() {
    }

    public static String base64encode(String text) {
        try {
            String rez = enc.encode(text.getBytes("UTF-8"));
            return rez;
        } catch (UnsupportedEncodingException var2) {
            return null;
        }
    }

    public static String base64decode(String text) {
        try {
            return new String(dec.decodeBuffer(text), "UTF-8");
        } catch (IOException var2) {
            return null;
        }
    }

    public static boolean validateBusNo(String param) {
        pattern = Pattern.compile("^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$");
        matcher = pattern.matcher(param);
        return !matcher.matches();
    }

    public static boolean validateText(String param) {
        return !param.matches("[a-zA-Z]*");
    }

    public static boolean validateNumber(String param) {
        return param.matches("[0-9]*");
    }

    public static boolean isEmpty(String param) {
        return param != null && (param == "" || param.trim().isEmpty());
    }

    public static boolean EmailFormatValidator(String email) {
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        matcher = pattern.matcher(email);
        return matcher.matches() && email.endsWith(".com");
    }

    public static String getDay(int day) {
        Calendar c = Calendar.getInstance();
        c.set(7, day);
        return c.getDisplayName(7, 2, new Locale("en"));
    }

    public static void main(String[] args) {
        System.out.println(base64encode("dip"));
        System.out.println(base64decode(base64encode("dip")));
    }
}
