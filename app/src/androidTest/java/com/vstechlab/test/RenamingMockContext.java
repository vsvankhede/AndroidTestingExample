package com.vstechlab.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.test.RenamingDelegatingContext;

/**
 * Mock context to test shared preference.
 */
public class RenamingMockContext extends RenamingDelegatingContext {
    public static final String PREFIX = "test.";

    public RenamingMockContext(Context context) {
        super(context, PREFIX);
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(PREFIX + name, mode);
    }
}
