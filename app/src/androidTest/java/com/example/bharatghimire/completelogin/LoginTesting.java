package com.example.bharatghimire.completelogin;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Bharat Ghimire on 9/8/16.
 */
public class LoginTesting {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void validateEditTest() {
        onView(withId(R.id.edittext_email)).perform(typeText("bharatghimire@gmail.com"));
        onView(withId(R.id.edittext_password)).perform(typeText("password"));

    }

}
