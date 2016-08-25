package com.example.bharatghimire.completelogin.utlity;

import android.text.TextUtils;

/**
 * Created by Bharat Ghimire on 12/8/16.
 */
public class LoginUtility {

    public static boolean isFieldEmpty(CharSequence target) {
        return !TextUtils.isEmpty(target);
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
