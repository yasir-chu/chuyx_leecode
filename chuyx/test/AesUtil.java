package test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AesUtil {

    private static final String ALGORITHM_MODE = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHM = "AES";

    /**
     * 加密
     *
     * @param plainText 明文
     * @param password  密钥
     * @return 密文
     */
    public static String encrypt(String plainText, String password)   throws  Exception{
        return toHex(encrypt(plainText.getBytes(StandardCharsets.UTF_8), password));
    }


    /**
     * 解密
     *
     * @param cipherText 密文
     * @param password 密钥
     * @return 明文
     */
    public static String decrypt(String cipherText, String password)   throws  Exception{
        byte[] bytes = decrypt(hexToBytes(cipherText), password);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * 加密，以byte[]明文输入,byte[]密文输出
     *
     * @param byteS byte[]明文
     * @param password 密钥
     * @return byte[]密文
     */
    public static byte[] encrypt(byte[] byteS, String password) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE);
        SecretKeySpec keySpec = getKey(password);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(byteS);
    }

    /**
     * 解密，以byte[]密文输入,以byte[]明文输出
     *
     * @param byteD byte[]密文
     * @param password 密码
     * @return byte[]明文
     */
    public static byte[] decrypt(byte[] byteD, String password)  throws  Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE);
        SecretKeySpec keySpec = getKey(password);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(byteD);
    }

    /**
     * 密钥转换为SecretKeySpec
     *
     * @param password 密钥
     * @return SecretKeySpec
     */
    private static SecretKeySpec getKey(String password) {
        return new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    }


    /**
     * Convert byte array to hex string
     * @param bytes 字节码
     * @return 十六进制字符串
     */
    public static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 3);
        for (byte aByte : bytes) {
            int val = ((int) aByte) & 0xff;
            if (val < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString();
    }

    /**
     * Convert hex string to byte array
     *
     * @param hexStr 十六进制字符串
     * @return bytes 字节码
     */
    public static byte[] hexToBytes(String hexStr) {
        int hexLen = hexStr.length();
        final int two = 2;
        if ((hexLen % two) != 0) {
            throw new IllegalArgumentException("长度不是偶数!");
        }
        byte[] bytes = new byte[hexLen / two];
        for (int i = 0; i < hexLen; i = i + two) {
            String item = hexStr.substring(i, i + two);
            bytes[i / two] = (byte) Integer.parseInt(item, 16);
        }
        return bytes;
    }

}