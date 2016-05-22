package com.arteko.mvptdd.login;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.arteko.mvptdd.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by juancho on 21/05/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest  {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void onEmailErrorNull(){
        String error = mActivityRule.getActivity().getString(R.string.not_null);
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText(error)));
    }

    @Test
    public void onPasswordErrorNull(){
        String error = mActivityRule.getActivity().getString(R.string.not_null);
        onView(withId(R.id.input_email)).perform(typeText("test"));
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText(error)));
    }
}
