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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DescentAndAncestry extends AppCompatActivity {

    public ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("What is true about DNA and RNA?");
        add("Are metabolic pathways conserved across all currently recognized domains?");
        add("Which of these does NOT support the relatedness of all eukaryotes?");
        add("What is true about phylogenetic trees and cladograms?");
        add("Can cladograms and phlogenetic trees illustrate speciation?");
    }};
    public ArrayList<String> arrayOfAnswers = new ArrayList<String>() {{
        add("They are composed of amino acids");
        add("They are shared by all modern living systems");
        add("They facilitate carbohydrate production");
        add("They are rarely found together");
        add("Yes");
        add("No");
        add(" ");
        add(" ");
        add("Cytoskeleton");
        add("Membrane-bound organelles");
        add("Linear Chromosomes");
        add("Cell Wall");
        add("They can represent all traits of an animal");
        add("They can't show patterns of evolution");
        add("They can't be constructed from similarities of species");
        add("They can represent traits lost/derived due to evolution");
        add("Yes");
        add("No");
        add(" ");
        add(" ");
    }};
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descent_and_ancestry);

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
            View rootView = inflater.inflate(R.layout.fragment_descent_and_ancestry, container, false);
            ImageView imageView1 = (ImageView) rootView.findViewById(R.id.phylogenetic_tree);
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.cladogram);
            Glide.with(getActivity().getApplicationContext()).load(R.drawable.phylogenetic_tree).into(imageView1);
            Glide.with(getActivity().getApplicationContext()).load(R.drawable.cladogram).into(imageView2);
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
                    return DescentAndAncestry.SummaryFragment.newInstance(position + 1);
                case 1:
                    return fragment_quiz.newInstance(arrayOfQuestions, arrayOfAnswers, 2, 1, 4, 4, 1);
                default:
                    return DescentAndAncestry.SummaryFragment.newInstance(position + 1);
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
