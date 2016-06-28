package es.upsa.mimo.espressoexamples.espresso;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sergiogarcia on 28/06/16.
 */
@RunWith(AndroidJUnit4.class)
public class DataPickerTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void setDataPicker(){
        int year = 2016;
        int month = 3;
        int day = 15;

        onView(withId(R.id.data_picker_button)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month+1, day));
        onView(withId(android.R.id.button1)).perform(click());
        //Other option: onView(withText("OK")).perform(click());

        onView(withId(R.id.data_picker_text)).check(matches(withText(year + "-" + month + "-" + day)));
    }

    @Test
    public void setCancelDataPicker(){
        onView(withId(R.id.data_picker_button)).perform(click());
        onView(withId(android.R.id.button2)).perform(click());
        //Other option: onView(withText("CANCEL")).perform(click());

        onView(withId(R.id.data_picker_text)).check(matches(withText(R.string.time_data_picker)));

    }
}
