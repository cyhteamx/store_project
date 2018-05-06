package com.store.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by ace on 2017/9/10.
 */
public class KeyHelper {
    /**
     * 获取公钥
     *
     * @param filename
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(new FileReader(filename).readBytes());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * 获取密钥
     *
     * @param filename
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String filename) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(new FileReader(filename).readBytes());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    /**
     * 生存rsa公钥和密钥
     *
     * @param publicKeyFilename
     * @param privateKeyFilename
     * @param password
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String password) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        new FileWriter(publicKeyFilename).write(publicKeyBytes, 0, publicKeyBytes.length);
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        new FileWriter(privateKeyFilename).write(privateKeyBytes, 0, privateKeyBytes.length);


    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //C:\Users\lupo\Desktop
        String publicKeyFilename = "/Users/PC/Desktop/pub.key";
        String privateKeyFilename = "/Users/PC/Desktop/pri.key";
        String password = Base64.encode("wm-client");
        generateKey(publicKeyFilename,privateKeyFilename,password);
    }
}

