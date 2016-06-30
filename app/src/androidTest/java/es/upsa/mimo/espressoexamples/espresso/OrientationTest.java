package es.upsa.mimo.espressoexamples.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static es.upsa.mimo.espressoexamples.espresso.viewActions.OrientationAction.orientationLandscape;
import static es.upsa.mimo.espressoexamples.espresso.viewActions.OrientationAction.orientationPortrait;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by sergiogarcia on 29/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class OrientationTest {

    private static final String USER_NAME = "Sergio";
    private static final String USER_SURNAME = "Garcia";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testChangeOrientationInForm(){
        onView(withId(R.id.enter_example_button)).perform(click());
        onView(isRoot()).perform(orientationLandscape());

        onView(withId(R.id.name_edittext)).perform(typeText(USER_NAME), closeSoftKeyboard());
        onView(withId(R.id.error_text_data)).check(matches(not(isDisplayed())));
        onView(withId(R.id.next_button)).perform(click());
        onView(withId(R.id.error_text_data)).check(matches(isDisplayed()));

        onView(isRoot()).perform(orientationPortrait());
        onView(withId(R.id.surnames_edittext)).perform(typeText(USER_SURNAME), closeSoftKeyboard());
        onView(withId(R.id.next_button)).perform(click());
        onView(withId(R.id.error_text_data)).check(matches(not(isDisplayed())));
    }
}
