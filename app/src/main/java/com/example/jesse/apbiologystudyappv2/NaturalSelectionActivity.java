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

public class NaturalSelectionActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> arrayOfQuestions = new ArrayList<String>() {{
        add("Natural Selection acts on");
        add("You have sampled a population in which you know that the percentage of the homozygous recessive genotype (aa) is 36%. Calculate Aa frequency");
        add("Which organism has the highest fitness?");
        add("What two objects play the biggest role in Natural Selection?");
        add("Which of these decreases the fitness of the organism the most?");
    }};
    private ArrayList<String> array_of_answers = new ArrayList<String>() {{
        add("Phenotypic Traits");
        add("DNA Sequence");
        add("Genetic Traits");
        add("Less 'fit' Individuals");
        add("2pq =  0.48");
        add("2pq = 0.30");
        add("2pq = 0.43");
        add("2pq = 0.36");
        add("A sterile mule that can pull 800 pounds");
        add("A small prairie dog that has twice the amount of healthy young in her litter");
        add("A childless human male who lives to be 120");
        add("A healthy dog who cannot give birth");
        add("Mutations and Genetic Stability");
        add("Evolutionary Fitness and Altruism");
        add("DNA Sequence and Order");
        add("Genetic Variation and Mutation");
        add("A grandparent who has pneumonia");
        add("A dog who gave birth already but now has cancer");
        add("A human child with Sickle Cell Anemia");
        add("An adult cat who has a temporarily injured leg");


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
            View rootView = inflater.inflate(R.layout.fragment_natural_selection, container, false);
            imageView = (ImageView) rootView.findViewById(R.id.Hardy_weinberg_image);
            Glide.with(getActivity()).load(R.drawable.hardy_weinberg).into(imageView);
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
                    return fragment_quiz.newInstance(arrayOfQuestions, array_of_answers,1, 1, 2, 4, 3 );
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
