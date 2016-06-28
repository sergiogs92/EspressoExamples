package es.upsa.mimo.espressoexamples.espresso.matches;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v4.content.ContextCompat;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;


/**
 * Created by sergiogarcia on 27/06/16.
 */
public class Matchers {

    /**
     * Matches a View with background color
     */
    public static Matcher<Object> withBackgroundColor(final int backgroundColor) {
        return new BoundedMatcher<Object, View>(View.class) {

            @Override
            public boolean matchesSafely(View view) {
                int color = ((ColorDrawable) view.getBackground().getCurrent()).getColor();
                return color == ContextCompat.getColor(view.getContext(), backgroundColor);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with background color from id: " + backgroundColor);
            }
        };
    }
}
