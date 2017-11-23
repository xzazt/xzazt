package com.xzazt.utils;


import com.xzazt.exception.StringException;
import org.apache.shiro.codec.Base64;

public class ShiroEncrypUtils {

    /**
     * shiro base64 加密
     * @param value
     * @return
     */
    public static String base64Encode(String value){
        if(value == null){
            throw new StringException("The encrypted text cannot be null");
        }
        String encodeToString = Base64.encodeToString(value.getBytes());
        System.out.println(encodeToString);
        return encodeToString;
    }

    /**
     * shiro base64 解密
     * @param value
     * @return
     */
    public static String base64Decode(String value){
        if(value == null){
            throw new StringException("The decrypted text cannot be null");
        }
        String encodeToString = Base64.decodeToString(value);
        System.out.println(encodeToString);
        return encodeToString;
    }



    public static void main(String[] args) {
        base64Encode("xz");
    }
}
