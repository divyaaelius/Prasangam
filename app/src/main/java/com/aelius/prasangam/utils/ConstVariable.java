package com.aelius.prasangam.utils;

import android.content.Context;

public class ConstVariable {
    Context context;



    public static String ID_DEFAULT="511";
    public static String USRDETAILSID_DEFAULT="22";
    //Image request code
    public static int PICK_IMAGE_REQUEST = 1;

    //storage permission code
    public static final int STORAGE_PERMISSION_CODE = 123;


    public static String[] PRIORITY = {"Select Priority","Normal", "Medium","High"};
    public static String[] SPNCONCERNTYPE = {"Select Concern Type","General Query", "Technical Query","Non Technical Query","Others"};
    public static String[] PRIORITY_OPD = {"Select Priority Status","Normal", "Urgent","Emergency"};
    public static String[] FOLLOWUPVISIT = {"Yes","No"};
   public static String[] FIELDTYPE = {"Select field Type","Name", "CHG ID", "Aadhar No.", "Mobile No.", "Email ID", "DOB (DD-MM-YYYY)"};
    public static String[] SERVIC_TYPE = {"Select Service", "ECG/EKG Review", "OPD Booking.", "VPD Booking.", "Second Opinion"};

    public static int ZERO=0;
    public static int ONE=1;
    public static int TWO=2;
    public static int THREE=3;
    public static int FOUR=4;
    public static int FIVE=5;
    public static int SIX=6;

    public static class URL{

    }



    public static class PARAM{

        public static String IDENTITY="identity";
        public static String PASSWORD="password";
        public static String TOKEN_DEVICE="token_device";
        public static String DEVICE_ID="deviceId";
        public static String DEVICEID_CAP="DeviceId";
        public static String MOBILEDEVICEID="mobileDeviceId";

        public static String ID="id";
        public static String STATUS="status";
        public static String TRUE="true";
        public static String DATA="data";
        public static String USERNAME="username";
        public static String USERDETAILSID="userDetailsId";
        public static String CREATEBYUSERID="createByUserId";
        public static String EMAIL="email";


        public static String OLD="old";
        public static String NEW="new";
        public static String NEW_CONFIRM="new_confirm";

    }





























}
