package com.reoky.crackme.challengetwo.util;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * I need to hash a string, where do I turn? Oh ya, to the digest class!
 */
public class Digest {
    private static final String TAG = "Util/Digest";

    /**
     * Useful for calculating the MD5 checksum of a String, but be warned that MD5 in no longer
     * considered secure because of collisions.
     *
     * @param plaintext String
     * @return String Cipher text (md5 hash in String-Hex form)
     */
    public static String md5Sum(String plaintext) {
       StringBuilder builder = new StringBuilder();
       String hash = "";
       try {
           MessageDigest messageDigest = MessageDigest.getInstance("MD5");
           byte[] hashBytes = messageDigest.digest(plaintext.getBytes("UTF-8"));

           // Build hex String result
           for (byte b : hashBytes) {
               builder.append(String.format("%02x", b));
           }
           hash = builder.toString();
           Log.e(TAG, hash);

       } catch (UnsupportedEncodingException e) {
           Log.e(TAG, "Your phone doesn't seem to support UTF-8 encoding? This should never happen.");
       } catch (NoSuchAlgorithmException e) {
           Log.e(TAG, "This device doesn't support MD5 from java.security.MessageDigest.");
       }
       return hash;
    }
}
