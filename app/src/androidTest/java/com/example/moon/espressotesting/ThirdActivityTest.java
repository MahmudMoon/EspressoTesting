package com.example.moon.espressotesting;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ThirdActivityTest {
    @Rule
    public ActivityTestRule<ThirdActivity> activityActivityTestRule_third = new ActivityTestRule<ThirdActivity>(ThirdActivity.class);

    @Before
    public void setUp() throws Exception {
        activityActivityTestRule_third.getActivity();
    }

    @Test
    public void ensure_list_work(){

        Espresso.onView(withId(R.id.list_one))
                .check(matches(isDisplayed()));

        onData(anything())
                .inAdapterView(withId(R.id.list_one))
                .atPosition(0)
                .perform(click());

        Espresso.onData(anything())
                .inAdapterView(withId(R.id.list_one))
                .atPosition(0)
                .check(matches(withText("Mustofa")));
    }

    @After
    public void tearDown() throws Exception {
    }
}