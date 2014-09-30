package com.reoky.crackme.challengeone.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

    /**
     * Utility function that computes SHA-1 hashes
     * @param plaintext String
     * @return Hexadecimal SHA1 Hash
     */
    public static String computeSHA1Hash(String plaintext) {
        String hash = "";
        byte[] content;
        MessageDigest digest;

        // Convert plaintext bytes into
        try {
            digest = MessageDigest.getInstance( "SHA-1" );
            content = plaintext.getBytes("UTF-8");
            digest.update(content, 0, content.length);
            content = digest.digest();

            // Build hex String result
            StringBuilder builder = new StringBuilder();
            for (byte b : content) { builder.append(String.format("%02X", b)); }
            hash = builder.toString();
        }
        catch (UnsupportedEncodingException e) { e.printStackTrace(); }
        catch(NoSuchAlgorithmException e) { e.printStackTrace(); }

        // Return the hex String
        return hash;
    }
}

