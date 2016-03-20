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

public class TimingAndCoordination extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Which one of these is not a reason why cells containing the same DNA can be so different from each other?");
        add("What is photoperiodism?");
        add("What is quorum sensing?");
        add("What is phototropism?");
        add("Is estivation a response to an environmental cue?");
    }};
    private ArrayList<String> array_of_answers = new ArrayList<String>() {{
        add("Mutations");
        add("Genetic regulation by microRNAs");
        add("Genetic regulation by proteins and polymerases");
        add("All of the above are reasons");
        add("The response to change in length of the night in plants");
        add("The response to presence of light in plants");
        add("The response to varying wind conditions in plants");
        add("The response to lack of nutrients in roots of plants");
        add("A fruiting body formation in fungi");
        add("A type of parasitic symbiotic relationship");
        add("A way bacteria communicate to each other the number of others in the vicinity");
        add("A type of commensalistic symbiotic relationship");
        add("The response to change in length of the night in plants");
        add("The response to presence of light in plants");
        add("The response to varying wind conditions in plants");
        add("The response to lack of nutrients in roots of plants");
        add("Yes");
        add("No");
        add("");
        add("");


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
            View rootView = inflater.inflate(R.layout.fragment_timing_and_coordination, container, false);
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
                    return fragment_quiz.newInstance(arrayOfQuestions, array_of_answers,4, 1, 3, 2, 3 );
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
