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

public class ExpressionOfGeneticInfo extends AppCompatActivity {

    public ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Which of these is an example of a regulatory protein?");
        add("What is a regulatory gene?");
        add("True or False: Regulatory proteins inhibit gene expression by binding to DNA and blocking transcription");
        add("True or False: Regulatory proteins stimulate gene expression by binding to repressors to inactivate repressor function");
        add("What are inducers?");
    }};
    public ArrayList<String> arrayOfAnswers = new ArrayList<String>() {{
        add("Promoters");
        add("Terminators");
        add("Enhancers");
        add("All of the above");
        add("A type of transcription factor that assists in DNA replication");
        add("A gene that regulates other genes");
        add("A sequence of DNA encoding a regulatory protein or RNA");
        add("All of the above");
        add("True");
        add("False");
        add("");
        add("");
        add("True");
        add("False");
        add("");
        add("");
        add("Proteins that inhibit the expression of specific genes");
        add("Proteins that can turn on gene expression");
        add("Regulatory genes that encode for transcription factors");
        add("Regulatory genes that code for polymerase");
    }};
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expression_of_genetic_info);

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
            View rootView = inflater.inflate(R.layout.fragment_expression_of_genetic_info, container, false);
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
                    return ExpressionOfGeneticInfo.SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, arrayOfAnswers, 3, 3, 1, 1, 2);
                default:
                    return ExpressionOfGeneticInfo.SummaryFragment.newInstance(position + 1);
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
