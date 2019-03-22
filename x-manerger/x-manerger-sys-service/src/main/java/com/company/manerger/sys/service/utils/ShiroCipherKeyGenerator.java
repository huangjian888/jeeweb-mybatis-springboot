package com.company.manerger.sys.service.utils;

import org.apache.shiro.codec.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * @description: 密钥生成java代码
 */
public class ShiroCipherKeyGenerator {

    public static void main(String[] args) {
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey deskey = keygen.generateKey();
        System.out.println(Base64.encodeToString(deskey.getEncoded()));
    }
}
