package com.example.jesse.apbiologystudyappv2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class FeedbackMechanisms extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("What is true about negative feedback mechanisms?");
        add("What is true about positive feedback mechanisms?");
        add("Which isn't consequence of alterations in feedback mechanisms?");
        add("Which of these isn't a response to a change in environment?");
        add("Ripening of fruit is an example of:");
    }};
    private ArrayList<String> array_of_answers = new ArrayList<String>() {{
        add("They amplify a stimulus");
        add("They return a changing condition back to its set point");
        add("They change a set point to fit the environmental conditions");
        add("They don't help maintain dynamic homeostasis");
        add("They amplify a stimulus");
        add("They don't produce system changes");
        add("They change a set point to fit the environmental conditions");
        add("They help maintain dynamic homeostasis");
        add("Diabetes mellitus in response to decreased insulin");
        add("Dehydration in response to decreased ADH");
        add("Graves' disease (hyperthyroidism, overproduction of thyroid hormones)");
        add("Sickle cell anemia in response to a genetic mutation");
        add("Photoperiodism and phototropism in plants");
        add("Hibernation and migration in animals");
        add("Running from a predator");
        add("Shivering and sweating in humans");
        add("Positive Feedback");
        add("Negative Feedback");
        add(" ");
        add(" ");


    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_selection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class SummaryFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        ImageView imageView;

        public SummaryFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static SummaryFragment newInstance(int sectionNumber) {
            SummaryFragment fragment = new SummaryFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_feedback_mechanisms, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a SummaryFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, array_of_answers,2, 1, 4, 3, 1 );
                default:
                    return SummaryFragment.newInstance(position + 1);
            }
        }


        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Notes";
                case 1:
                    return "Quiz";
            }
            return null;
        }
    }
}
