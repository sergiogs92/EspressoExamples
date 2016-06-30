package es.upsa.mimo.espressoexamples.espresso;

import android.support.test.espresso.contrib.RecyclerViewActions;
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
 * Created by sergiogarcia on 26/6/16.
 */
@RunWith(AndroidJUnit4.class)
public class ItemClickRecyclerViewTest{

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testClickAtFirstPosition() {
        onView(withId(R.id.recycler_example_button)).perform(click());

        onView(withId(R.id.recyclerView_fragment)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        pressBack();
    }

    @Test
    public void testClickAtSecondPosition(){
        onView(withId(R.id.recycler_example_button)).perform(click());

        onView(withId(R.id.recyclerView_fragment)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        pressBack();
    }

    @Test
    public void testClickAtFirstAndSecondPosition(){
        onView(withId(R.id.recycler_example_button)).perform(click());

        onView(withId(R.id.recyclerView_fragment)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        pressBack();
        onView(withId(R.id.recyclerView_fragment)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        pressBack();
    }
}
