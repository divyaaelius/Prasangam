package com.aelius.prasangam.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferHelper {



    private SharedPreferences app_prefs;
    private SharedPreferences.Editor edit;
    private final String NUMBER = "number";
    private final String CREATEDBYUSERID = "CreatedByUserId";
    private final String USER_NAME = "username";
    private final String USER_TYPE = "usertype";
    private final String USERID = "user_id";
    private final String ISLOGIN="isLogin";
    private final String TOKEN = "authtoken";
    private final String DEVICE_TOKEN = "device_token";
    private final String USER_FULLNAME = "first_name";
    private final String USER_DETAILS_ID = "user_details_id";
    private final String EMAIL = "email";
    private final String PROFILE_IMAGE = "profile_image";


    public PreferHelper(Context context) {
        app_prefs = context.getSharedPreferences("chspref",
                Context.MODE_PRIVATE);
        edit = app_prefs.edit();

//		this.context = context;
    }

    public String getMobileNumber() {
        return app_prefs.getString(NUMBER, null);

    }

    public void putMobileNumber(String full_name) {
        edit.putString(NUMBER, full_name);
        edit.commit();
    }

    public String getCreatedByUserId() {
        return app_prefs.getString(CREATEDBYUSERID, null);

    }

    public void putCreatedByUserId(String CreatedByUserId) {
        edit.putString(this.CREATEDBYUSERID, CreatedByUserId);
        edit.commit();
    }

    public String getUserName() {
        return app_prefs.getString(USER_NAME, null);

    }

    public void putUserName(String username) {
        edit.putString(USER_NAME, username);
        edit.commit();
    }

    public void putUserType(String email) {
        edit.putString(USER_TYPE, email);
        edit.commit();
    }

    public String getUserType() {
        return app_prefs.getString(USER_TYPE, null);
    }

    public void putUserId(String userId) {
        edit.putString(USERID, userId);
        edit.commit();
    }

    public String getUserId() {
        return app_prefs.getString(USERID, null);
    }

    public boolean getLogin() {
        return app_prefs.getBoolean(ISLOGIN, false);

    }

    public void putLogin(boolean login) {
        edit.putBoolean(ISLOGIN, login);
        edit.commit();
    }

    public String getToken() {
        return app_prefs.getString(TOKEN, null);

    }

    public void putToken(String token) {
        edit.putString(TOKEN, token);
        edit.commit();
    }

    public void putDeviceToken(String deviceToken) {
        edit.putString(DEVICE_TOKEN, deviceToken);
        edit.commit();
    }

    public String getDeviceToken() {
        return app_prefs.getString(DEVICE_TOKEN, null);

    }
    public String getUserFullName() {
        return app_prefs.getString(USER_FULLNAME, null);

    }

    public void putUserFullName(String username) {
        edit.putString(USER_FULLNAME, username);
        edit.commit();
    }
    public String getNumber() {
        return app_prefs.getString(NUMBER, null);

    }

    public void putNumber(String username) {
        edit.putString(NUMBER, username);
        edit.commit();
    }

    public String getUserDetailID() {
        return app_prefs.getString(USER_DETAILS_ID, null);

    }

    public void putUserDetailId(String userdetailid) {
        edit.putString(USER_DETAILS_ID, userdetailid);
        edit.commit();
    }

    public String getUserEmail() {
        return app_prefs.getString(EMAIL, null);

    }

    public void putUserEmail(String email) {
        edit.putString(EMAIL, email);
        edit.commit();
    }

    public void clearLogin()
    {
        edit.putString(EMAIL, "");
        edit.putString(CREATEDBYUSERID, "");
        edit.putString(USER_DETAILS_ID, "");
        edit.putString(USER_FULLNAME, "");
        edit.putString(USERID, "");
        edit.putString(USER_NAME, "");
        edit.commit();

    }

    public String getProfileImage() {
        return app_prefs.getString(PROFILE_IMAGE, null);
    }

    public void putProfileImage(String image) {
        edit.putString(PROFILE_IMAGE, image);
        edit.commit();
    }
}