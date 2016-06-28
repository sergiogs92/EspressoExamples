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
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static es.upsa.mimo.espressoexamples.espresso.matches.Matchers.withBackgroundColor;

/**
 * Created by sergiogarcia on 28/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class ViewPagerTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDisplayedOnSwipeLeft(){
        onView(withId(R.id.view_pager_button)).perform(click());
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        pressBack();
    }

    @Test
    public void testDisplayedOnLeftRightSwipe(){
        onView(withId(R.id.view_pager_button)).perform(click());
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.viewpager)).perform(swipeRight());
    }
}
