package org.openjfx.mycriptofx;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class MyCripto {
    static String getHashString(String message) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());
        byte[] digest = md.digest();
        return getHexString(digest) + "\n String: " + new String(digest); 
    }
    
    static String getMacString(String message) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom sr = new SecureRandom();
        keyGen.init(sr);
        Key key = keyGen.generateKey();
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[]bytes = message.getBytes();
        byte[]macResult = mac.doFinal(bytes);
        return getHexString(macResult) + "\n String:  " + new String(macResult);
    }
    
    static String getCipherString(String message) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom sr = new SecureRandom();
        keyGen.init(sr);
        Key key = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(cipher.ENCRYPT_MODE, key);
        byte[] bytes = message.getBytes();
        byte[] cipherResult = cipher.doFinal(bytes);
        cipher.init(cipher.DECRYPT_MODE, key);
        byte[] bytes1 = cipher.doFinal(cipherResult);
        String str = new String(bytes1);
        String str1 = getHexString(cipherResult);
        str = str1 + "\n исходный текст: " + str;
        return str;
    }
    
    static String getPairCipherString(String message) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize (2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = message.getBytes();
        cipher.update(bytes);
        byte[] cipherResult = cipher.doFinal();
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        byte[] bytes1 = cipher.doFinal(cipherResult);
        String str = new String(bytes1);
        String str1 = getHexString(cipherResult);
        str = str1 + "\n исходный текст:  " + str;
        return str;
    }
    
    static String getElectSigmatString(String message) throws Exception{
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize (2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        byte[] bytes = message.getBytes();
        sign.update(bytes);
        byte[] signature = sign.sign();
        sign.initVerify(pair.getPublic());
        sign.update(bytes);
        boolean bool = sign.verify(signature);
        String str;
        if (bool) str = "Signature verified "; else str = "Signature failed";
        String str1 = getHexString(signature);
        str = str1 + "\n" + str;
        return str;
    }
    
    private static String getHexString(byte[] bytes){
        StringBuilder hexString = new StringBuilder();
        for(int i = 0; i < bytes.length;i++)
        {
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return "HexStr:  " + hexString.toString();
    }
}
