package test.util;

import java.security.MessageDigest;

public class MD5Utils {

    public static final String DEFAULT_CHARSET = "utf-8";  // 默认编码utf-8

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    public static String MD5Encode(String origin) {
        String resultString = origin;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(DEFAULT_CHARSET)));
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultString;
    }

}