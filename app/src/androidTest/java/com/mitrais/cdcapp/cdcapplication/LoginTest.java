package com.mitrais.cdcapp.cdcapplication;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

/**
 * Created by Fadlika_N on 10/03/2017.
 */

public class LoginTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mitrais.cdcapp.cdcapplication.LoginActivity";

    private static Class<?> launcherActivityClass;
    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public LoginTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRun() {
        // Wait for activity
        solo.waitForActivity("LoginActivity", 2000);
        // Set default small timeout to 15425 milliseconds
        Timeout.setSmallTimeout(15425);
        // Enter the text
        solo.clearEditText((android.widget.EditText) solo.getView("inputEmail"));
        solo.enterText((android.widget.EditText) solo.getView("inputEmail"), "fadlikadn@gmail.com");
        // Click on Empty Text View
        solo.clickOnView(solo.getView("inputPassword"));
        // Enter the text: 'fadlika'
        solo.clearEditText((android.widget.EditText) solo.getView("inputPassword"));
        solo.enterText((android.widget.EditText) solo.getView("inputPassword"), "fadlika");
        // Click on Sign in or register
        solo.clickOnView(solo.getView("buttonLogin"));
    }
}

