package com.example.config;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {
    private static final int ITERATIONS = 655356;

    private static final int KEY_LENGTH = 256;

    public static String hashPassword(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] salt = generateSalt();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte[] hashedPassword = factory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }
}
