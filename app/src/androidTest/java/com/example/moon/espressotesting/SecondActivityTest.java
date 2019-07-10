package com.example.moon.espressotesting;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class SecondActivityTest {
    SecondActivity secActivity;
    @Rule
    public ActivityTestRule<SecondActivity> activityTestRule_sec = new ActivityTestRule<SecondActivity>(SecondActivity.class);

    @Before
    public void setUp() throws Exception {
        secActivity = activityTestRule_sec.getActivity();
    }

    @Test
    public void ensure_double(){
        TextView textView = secActivity.findViewById(R.id.resultView);
        String text = textView.getText().toString();
        text+=text;
        Espresso.onView(withId(R.id.btn_make_double))
                .perform(click());
        Espresso.onView(withId(R.id.resultView))
                .check(matches(withText(text)));
    }

    @After
    public void tearDown() throws Exception {
        secActivity = null;
    }
}