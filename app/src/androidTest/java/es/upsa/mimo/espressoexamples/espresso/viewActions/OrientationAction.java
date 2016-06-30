package es.upsa.mimo.espressoexamples.espresso.viewActions;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

/**
 * Created by sergiogarcia on 29/06/16.
 */
public class OrientationAction implements ViewAction{

    private int orientation;
    private Activity activity;

    private OrientationAction(int orientation) {
        this.orientation = orientation;
    }

    @Override
    public Matcher<View> getConstraints() {
        return isRoot();
    }

    @Override
    public String getDescription() {
        return "orientation: ".concat(String.valueOf(orientation));
    }

    @Override
    public void perform(UiController uiController, View view) {
        activity = (Activity) view.getContext();
        activity.setRequestedOrientation(orientation);
    }

    public static ViewAction orientationLandscape() {
        return new OrientationAction(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public static ViewAction orientationPortrait() {
        return new OrientationAction(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}
