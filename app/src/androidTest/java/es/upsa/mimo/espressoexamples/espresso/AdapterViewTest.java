package es.upsa.mimo.espressoexamples.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.activities.MainActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static es.upsa.mimo.espressoexamples.espresso.matches.Matchers.withTeamDriver;
import static es.upsa.mimo.espressoexamples.espresso.matches.Matchers.withTeamName;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by sergiogarcia on 29/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class AdapterViewTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private static final String TEAM_NAME = "Honda";
    private static final String TEAM_DRIVER = "Alonso";

    @Test
    public void testClickOnData(){
        onView(withId(R.id.adapter_view_list_button)).perform(click());
        onData(allOf(withTeamName(TEAM_NAME), withTeamDriver(TEAM_DRIVER))).perform(click());
    }

    @Test
    public void testClickOnBookByPosition(){
        onView(withId(R.id.adapter_view_list_button)).perform(click());
        onData(anything()).atPosition(7).perform(click());
        onView(withId(R.id.text)).check(matches(withText(TEAM_NAME)));
    }

}
