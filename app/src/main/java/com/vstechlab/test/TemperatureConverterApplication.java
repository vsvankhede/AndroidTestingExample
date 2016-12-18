package com.vstechlab.test;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Base application class of app.
 */
public class TemperatureConverterApplication extends Application {
    private static final int DECIMAL_PLACES_DEFAULT = 2;
    private static final String KEY_DECIMAL_PLACES = ".KEY_DECIMAL_PLACES";

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void setDecimalPlaces(int decimalPlaces) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_DECIMAL_PLACES, decimalPlaces);
        editor.apply();
    }

    public int getDecimalPlaces() {
        return sharedPreferences.getInt(KEY_DECIMAL_PLACES, DECIMAL_PLACES_DEFAULT);
    }
}
