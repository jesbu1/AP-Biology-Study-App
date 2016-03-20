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

public class DnaAndRna extends AppCompatActivity {

    public ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("What kind of chromosomes do noneukaryotics have?");
        add("What enzyme assists retroviruses in replication?");
        add("True or False: DNA replication occurs bidirectionally and differs in the production of the leading and lagging strands");
        add("What are plasmids?");
        add("What do tRNA molecules do?");
    }};
    public ArrayList<String> arrayOfAnswers = new ArrayList<String>() {{
        add("Mutliple linear chromosomes");
        add("Circular chromosomes");
        add("One linear chromosome");
        add("X shaped chromosomes");
        add("Reverse Transcriptase");
        add("Reverse Topoisomerase");
        add("DNA Ligase");
        add("DNA Helicase");
        add("True");
        add("False");
        add("");
        add("");
        add("Small, single stranded circular RNA molecules in eukaryotes");
        add("Small, single stranded circular RNA molecules in prokaryotes");
        add("Small, double stranded circular DNA molecules in eukaryotes");
        add("Small, double stranded circular DNA molecules in prokaryotes");
        add("Carries information from the DNA to the ribosome");
        add("Form the building blocks of ribosomes");
        add("Bind specific amino acids and allow information in the mRNA to be translated to a peptide");
        add("Regulate gene expression at the level of mRNA transcription");
    }};
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dna_and_rna);

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
            View rootView = inflater.inflate(R.layout.fragment_dna_and_rna, container, false);
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
                    return DnaAndRna.SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, arrayOfAnswers, 2, 1, 1, 4, 3);
                default:
                    return DnaAndRna.SummaryFragment.newInstance(position + 1);
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
