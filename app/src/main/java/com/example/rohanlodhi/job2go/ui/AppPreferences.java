package com.example.rohanlodhi.job2go.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Set;

public class AppPreferences {


    public static final String NUMBER = "number";
    private static final String MyPREFERENCES = "MyPrefs";

    private static SharedPreferences mAppSharedPrefs;
    private static AppPreferences mInstance;

    public static AppPreferences getInstance(Context pContext) {
        if (mInstance == null) {
            mInstance = new AppPreferences();
            Initialize(pContext);
        }
        return mInstance;
    }

    private static void Initialize(Context ctxt) {
        mAppSharedPrefs = ctxt.getSharedPreferences(MyPREFERENCES, Activity.MODE_PRIVATE);
    }

    public void putString(String pKey, String pDefaultVal) {
        //Log.d(TAG, "key :: " + pDefaultVal + " pDefaultVal = " + pDefaultVal);
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.putString(pKey, pDefaultVal);
        prefsEditor.apply();
        //  prefsEditor.commit();
    }

    public void putStringSet(String pKey, Set pDefaultVal) {
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.putStringSet(pKey, pDefaultVal);
        prefsEditor.apply();
    }

    public void putInt(String pKey, int pDefaultVal) {
        //Log.d(TAG, "key :: " + pDefaultVal + " pDefaultVal = " + pDefaultVal);
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.putInt(pKey, pDefaultVal);
        prefsEditor.apply();
        //  prefsEditor.commit();

    }

    public void putBoolean(String pKey, boolean pDefaultVal) {
        //Log.d(TAG, "key :: " + pDefaultVal + " pDefaultVal = " + pDefaultVal);
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.putBoolean(pKey, pDefaultVal);
        prefsEditor.apply();
        //prefsEditor.commit();
    }

    public void putLong(String pKey, long pDefaultVal) {
        //Log.d(TAG, "key :: " + pDefaultVal + " pDefaultVal = " + pDefaultVal);
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.putLong(pKey, pDefaultVal);
        prefsEditor.apply();
        //  prefsEditor.commit();
    }

    public String getString(String key, String pDefaultVal) {
        return mAppSharedPrefs.getString(key, pDefaultVal);
    }

    public int getInt(String pKey, int pDefaultVal) {
        return mAppSharedPrefs.getInt(pKey, pDefaultVal);
    }

    public long getLong(String pKey, long pDefaultVal) {
        return mAppSharedPrefs.getLong(pKey, pDefaultVal);
    }

    public boolean getBoolean(String pKey, boolean pDefaultVal) {
        return mAppSharedPrefs.getBoolean(pKey, pDefaultVal);
    }

    public void deleteAllPreferences() {
        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.clear();
        prefsEditor.apply();
    }

    public void deletePreferences(String name) {

        Editor prefsEditor = mAppSharedPrefs.edit();
        prefsEditor.remove(name);
        prefsEditor.apply();
    }

    public Boolean containsKey(String name) {
        return mAppSharedPrefs.contains(name);
    }


}