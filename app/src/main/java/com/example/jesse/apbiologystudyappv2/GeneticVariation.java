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

public class GeneticVariation extends AppCompatActivity {

    public ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Can external factors in the environment affect the degree of or probability for errors in DNA processing?");
        add("What is transduction?");
        add("Errors in mitosis or meiosis can result in:");
        add("What is true about mutations?");
        add("What is a latent (lysogenic) infection?");
    }};
    public ArrayList<String> arrayOfAnswers = new ArrayList<String>() {{
        add("Yes");
        add("No");
        add("");
        add("");
        add("The process in which bacteria take in DNA from the surrounding environment");
        add("The process in which bacteria form a sex pilus and exchange DNA with other bacteria");
        add("The process in which viruses inject other bacterial DNA into a new bacteria");
        add("All of the above");
        add("Doubling or tripling of chromosome number");
        add("Changes in chromosome number resulting in extra or missing chromosomes (Down syndrome)");
        add("Polyploidy");
        add("All of the above");
        add("Mutations can be positive, neutral, or negative to the fitness of the organism");
        add("Whether or not a mutation is good or bad depends on the environmental context");
        add("Mutations are the primary source of genetic variation");
        add("All of the above");
        add("Viral infections in which viruses integrate DNA into the host genome");
        add("Viral infections in which viruses replicate and burst through the membrane");
        add("Bacterial infections in which they use quorum sensing to launch a coordinated attack");
        add("Bacterial infections in which g protein pathways are affected");
    }};
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genetic_variation);

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
            View rootView = inflater.inflate(R.layout.fragment_genetic_variation, container, false);
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
                    return GeneticVariation.SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, arrayOfAnswers, 1, 3, 4, 4, 1);
                default:
                    return GeneticVariation.SummaryFragment.newInstance(position + 1);
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
