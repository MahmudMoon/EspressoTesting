package com.example.moon.espressotesting;

import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    MainActivity mainActivity;
    String res = "Hello Buddy";
    @Rule
     public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        mainActivity = activityActivityTestRule.getActivity();

    }

    @Before
    public void grantPermission(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand(
                "pm grant " + InstrumentationRegistry.getTargetContext().getPackageName() +
                        " android.permission.call_Phone"
        );
    }

    @Test
    public void ensure_textChange(){
        //write something in editText
        Espresso.onView(withId(R.id.inputField))
                .perform(typeText(res));
        //close the soft keyBoard
        Espresso.closeSoftKeyboard();
        //check the text Changed
        Espresso.onView(withId(R.id.changeText))
                .perform(click());
        Espresso.onView(withId(R.id.inputField))
                .check(matches(withText("Lalala")));

    }



    @Test
    public void ensure_activity_change(){
        // write text in editText
        Espresso.onView(withId(R.id.inputField))
                .perform(typeText(res));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // click the switch button
        Espresso.onView(withId(R.id.switchActivity))
                .perform(click());
        // match text
        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText(res)));
    }




    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}