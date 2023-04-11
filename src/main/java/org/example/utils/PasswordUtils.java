package org.example.utils;

public class PasswordUtils {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assesPassword(String password) {
        if(password.length()<8 || password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        } else if (password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }
        return SecurityLevel.STRONG;
    }
}
