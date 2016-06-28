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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static es.upsa.mimo.espressoexamples.espresso.matches.Matchers.withBackgroundColor;

/**
 * Created by sergiogarcia on 27/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class ShowDialogColorTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCheckDialogDisplayed() {
        onView(withId(R.id.dialog_example_activity)).perform(click());

        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()));
        onView(withText(R.string.dialog_message)).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).check(matches(isEnabled()));
        onView(withId(android.R.id.button2)).check(matches(isEnabled()));
    }

    @Test
    public void showGreatDialog(){
        onView(withId(R.id.dialog_example_activity)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.frame_show_dialog)).check(matches(withBackgroundColor(R.color.colorOkDialog)));
    }

    @Test
    public void showCancelDialog(){
        onView(withId(R.id.dialog_example_activity)).perform(click());
        onView(withId(android.R.id.button2)).perform(click());
        onView(withId(R.id.frame_show_dialog)).check(matches(withBackgroundColor(R.color.colorCancelDialog)));
    }
}
