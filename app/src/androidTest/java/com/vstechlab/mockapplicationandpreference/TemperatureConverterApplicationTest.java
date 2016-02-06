package com.vstechlab.mockapplicationandpreference;

import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TemperatureConverterApplicationTest extends ApplicationTestCase<TemperatureConverterApplication> {

    public TemperatureConverterApplicationTest() {
        super(TemperatureConverterApplication.class);
    }

    public void testSetAndRetrieveDecimalPlaces() {
        RenamingMockContext mockContext = new RenamingMockContext(getContext());
        setContext(mockContext);
        createApplication();
        TemperatureConverterApplication application = getApplication();
        application.setDecimalPlaces(3);

        assertEquals(3, application.getDecimalPlaces());
    }
}