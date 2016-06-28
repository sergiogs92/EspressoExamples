package es.upsa.mimo.espressoexamples.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import es.upsa.mimo.espressoexamples.R;
import es.upsa.mimo.espressoexamples.adapter.MyPagerAdapter;
import es.upsa.mimo.espressoexamples.fragments.ViewPagerFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ViewPagerFragment(), "ONE PAGE");
        adapter.addFragment(new ViewPagerFragment(), "TWO PAGE");
        viewPager.setAdapter(adapter);
    }
}
