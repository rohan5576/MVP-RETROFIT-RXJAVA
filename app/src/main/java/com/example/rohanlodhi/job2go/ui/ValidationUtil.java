package com.example.rohanlodhi.job2go.ui;

import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by spoton on 30/10/17.
 */

public class ValidationUtil {

    private static boolean validAddress;

    public static boolean isValidEmail(EditText etEmail) {
        CharSequence target = etEmail.getText().toString().trim();

        if (target.equals(""))
            return true;

        if (Patterns.EMAIL_ADDRESS.matcher(target).matches()) {
            return true;
        } else {
            etEmail.setError("Please enter valid email address!");
            etEmail.requestFocus();
            return false;
        }
    }

    public static boolean isValidatePassword(EditText etPassword) {
        Pattern pattern;
        Matcher matcher;

//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[-!@#$%^&*()+=,./|~`_])(?=\\S+$).{6,}$";
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z]).{6,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(etPassword.getText().toString().trim());
        if (matcher.matches()) {
            return true;
        } else {
            etPassword.setError("Password should be atleast 6 alphanumeric characters");
            etPassword.requestFocus();
            return false;
        }
    }



    public static boolean isValidateMobileNumber(EditText etMobile) {

        if (etMobile.getText().toString().trim().length() >= 10) {
            return true;
        } else {
            etMobile.setError("Enter valid mobile number");
            etMobile.requestFocus();
            return false;
        }
    }

    public static boolean isValidateName(EditText etName) {

        if (etName.getText().toString().trim().length() > 0) {
            return true;
        } else {
            etName.setError("Enter valid name");
            etName.requestFocus();
            return false;
        }
    }

    public static boolean isValidateInjectionBrand(EditText editText) {

        if (editText.getText().toString().trim().length() > 0) {
            return true;
        } else {
            editText.setError("Enter valid injection brand");
            editText.requestFocus();
            return false;
        }
    }

    public static boolean isValidAddress(EditText etAddress) {
        if (etAddress.getText().toString().trim().length() > 0) {
            return true;
        } else {
            etAddress.setError("Enter valid address");
            etAddress.requestFocus();
            return false;
        }
    }

    public static boolean isValidTagId(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        } else {
            editText.setError("Enter valid tag id");
            editText.requestFocus();
            return false;
        }
    }

    public static boolean isValidVenue(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        } else {
            editText.setError("Enter valid venue");
            editText.requestFocus();
            return false;
        }
    }

    public static boolean isValidDate(EditText etDate) {

        if (etDate.getText().toString().trim().length() > 0) {
            return true;
        } else {
            etDate.setError("Please select date");
            etDate.requestFocus();
            return false;
        }
    }

    public static boolean isValidateTreatmentPlace(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        } else {
            editText.setError("Enter valid treatment place");
            editText.requestFocus();
            return false;
        }
    }
}
