/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.educonnect;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author prant
 */
public class OTPGenerator {

    private static final Map<String, String> otpMap = new HashMap<>();

    public String generateOTP(String email) {
        String otp = generateRandomOTP();
        otpMap.put(email, otp);

        TimerTask task = new TimerTask() {
            public void run() {
                otpMap.remove(email);
                System.out.println("OTP for " + email + " expired.");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 120000); // 2 minutes in milliseconds

        //System.out.println("OTP for " + email + " is: " + otp);
        return otp;
    }

    public boolean validateOTP(String email, String enteredOTP) {
        String storedOTP = otpMap.get(email);

        if (storedOTP != null && storedOTP.equals(enteredOTP)) {
            otpMap.remove(email);
            System.out.println("OTP for " + email + " validated successfully.");
            return true;
        } else {
            System.out.println("OTP validation failed for " + email + ".");
            return false;
        }
    }

    private static String generateRandomOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
