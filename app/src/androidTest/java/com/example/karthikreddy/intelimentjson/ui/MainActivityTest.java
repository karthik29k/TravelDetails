package com.example.karthikreddy.intelimentjson.ui;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import com.example.karthikreddy.intelimentjson.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, true, true);

    private Matcher<View> destination_spinner = withId(R.id.destination_spinner);
    private Matcher<View> navigation_button = withId(R.id.navigateBtn);
    private Matcher<View> car_travel_time = withId(R.id.carTravelTime);
    private Matcher<View> train_travel_time = withId(R.id.trainTravelTime);
    private Matcher<View> car_label = withId(R.id.carLabel);
    private Matcher<View> train_label = withId(R.id.trainLabel);

    @Test
    public void testAllPopulatedValuesAreCorrect() {
        onView(destination_spinner).check(matches(isDisplayed()));
        onView(navigation_button).check(matches(isEnabled()));
        onView(car_travel_time)
                .check(matches(isDisplayed()))
                .check(matches(withText("80 Mins")));
        onView(car_label)
                .check(matches(isDisplayed()))
                .check(matches(withText("Car:")));
        onView(train_label)
                .check(matches(isDisplayed()))
                .check(matches(withText("Train:")));
        onView(train_travel_time)
                .check(matches(isDisplayed()))
                .check(matches(withText("120 Mins")));
    }

    @Test
    public void testSelectingItemFromSpinnerPopulatesCorrectValues() throws InterruptedException {
        onView(destination_spinner).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());

        onView(navigation_button).check(matches(isEnabled()));
        onView(car_travel_time)
                .check(matches(isDisplayed()))
                .check(matches(withText("30 Mins")));
        onView(car_label)
                .check(matches(isDisplayed()))
                .check(matches(withText("Car:")));
        onView(train_label)
                .check(matches(isDisplayed()))
                .check(matches(withText("Train:")));
        onView(train_travel_time)
                .check(matches(isDisplayed()))
                .check(matches(withText("No info")));
    }
}
