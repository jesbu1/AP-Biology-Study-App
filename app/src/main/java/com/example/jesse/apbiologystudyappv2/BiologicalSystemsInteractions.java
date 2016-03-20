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

public class BiologicalSystemsInteractions extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Are all biological systems, from cells to ecosystems, affected by biotic and abiotic interactions?");
        add("Which one of the following does not support common ancestry?");
        add("Which of these don't affect ecosystem balance?");
        add("Do vertebrate and plants also have nonspecific immune responses (like mammals)?");
        add("What role do B cells play?");
    }};
    private ArrayList<String> array_of_answers = new ArrayList<String>() {{
        add("Yes");
        add("No");
        add(" ");
        add(" ");
        add("Gas exchange in aquatic and terrestrial plants");
        add("Excretory systems in flatworms, earthworms and vertebrates");
        add("Osmoregulation in bacteria, fish and protists");
        add("Different structures of wings across different species");
        add("Human impact");
        add("An invasive species");
        add("Water limitation");
        add("All of the above affect ecosystem balance");
        add("Yes");
        add("No");
        add("");
        add("");
        add("In the cell mediated response, they target and destroy pathogens");
        add("They bind to antigens on the pathogen to slow it down");
        add("In the humoral response, they produce antibodies against antigens");
        add("In the humoral response, they help with the proliferation of T cells");


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
            View rootView = inflater.inflate(R.layout.fragment_biological_systems_interactions, container, false);
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
                    return fragment_quiz.newInstance(arrayOfQuestions, array_of_answers,1, 4, 4, 1, 3 );
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
