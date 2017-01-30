package com.oneconnect.payments.paygate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class ChecksumUtil {

    static final Logger log = Logger.getLogger(PayGateInitiateRequestDTO.class.getSimpleName());
    public static String getMD5Checksum(String string)
            throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(string.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        String checksum = hexString.toString();
        System.out.println("Calculated checksum: " + checksum);

        return checksum;
    }

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        PayGateInitiateRequestDTO req = new PayGateInitiateRequestDTO();
        req.setAmount(24390);
        req.setEmail("aubreym@oneconnectgroup.com");
        req.setReference("OneConnect-" + System.currentTimeMillis());
        req.setUser1("AubreyM");
        req.setEmail("aubreym@oneconnectgroup.com");
        req.calculateChecksum();

        System.out.println(GSON.toJson(req));

    }
}
