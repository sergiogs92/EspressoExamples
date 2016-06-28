package es.upsa.mimo.espressoexamples.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sergiogarcia on 27/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class ActivityPassTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testActivityToActivity() {
        onView(withId(R.id.change_example_activity)).perform(click());
        onView(withId(R.id.button_second_activity)).perform(click());
        pressBack();
    }
}
