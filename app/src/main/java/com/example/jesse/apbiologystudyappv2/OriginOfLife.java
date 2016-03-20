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

import java.util.ArrayList;

public class OriginOfLife extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Primitive Earth didn't provide inorganic precursors from which organic molecules could have been synthesized");
        add("RNA could have been the earliest genetic material ");
        add("Is it possible to form complex organic molecules from inorganic molecules in the absence of life?");
        add("A common genetic code is common to all life forms");
        add("The earliest fossil evidence for life dates back: ");
    }};
    private ArrayList<String> arrayOfAnswers = new ArrayList<String>() {{
        add("True");
        add("False");
        add(" ");
        add(" ");
        add("True");
        add("False");
        add(" ");
        add(" ");
        add("Yes");
        add("No");
        add("Not enough evidence to come up with an answer");
        add(" ");
        add("True");
        add("False");
        add(" ");
        add(" ");
        add("4.6 billion years");
        add("3.9 billion years");
        add("3.5 billion years");
        add("3 billion years");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin_of_life);

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


    public static class SummaryFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

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
            View rootView = inflater.inflate(R.layout.fragment_origin_of_life, container, false);
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
            switch (position) {
                case 0:
                    return OriginOfLife.SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, arrayOfAnswers, 2, 1, 1, 1, 3);
                default:
                    return OriginOfLife.SummaryFragment.newInstance(position + 1);
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
