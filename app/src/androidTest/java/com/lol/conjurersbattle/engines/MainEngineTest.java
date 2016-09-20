package com.lol.conjurersbattle.engines;

import android.test.AndroidTestCase;

import org.mockito.MockitoAnnotations;

public class MainEngineTest extends AndroidTestCase {
    private MainEngine testObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    public void testStartTurn() throws Exception {
        testObject = new MainEngine();
        testObject.startTurn();
    }
}
