/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumexpress.util;

/**
 *
 * @author HP
 */
public class UserProfile {
    private static String userName;
    private static String emailId;
    private static String userId;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }

    public static String getEmailId() {
        return emailId;
    }

    public static void setEmailId(String emailId) {
        UserProfile.emailId = emailId;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserProfile.userId = userId;
    }

    public UserProfile() {
    }

    
}
