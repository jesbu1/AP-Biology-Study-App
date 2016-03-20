package com.example.jesse.apbiologystudyappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BigIdea4Fragment extends Fragment {
        private CardView cardView2;
        private CardView cardView3;
        private CardView cardView4;
        private CardView cardView5;
        private CardView cardView1;
        private ImageView image_2;
        private ImageView image_3;
        private ImageView image_4;
        private ImageView image_5;

        public BigIdea4Fragment() {
            // Required empty public constructor
        }


        public static BigIdea4Fragment newInstance() {
            BigIdea4Fragment fragment = new BigIdea4Fragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            cardView2 = (CardView) view.findViewById(R.id.card_view_2_Interactions_to_Properties_1);
            cardView3 = (CardView) view.findViewById(R.id.card_view_3_Interactions_to_Properties_2);
            cardView4 = (CardView) view.findViewById(R.id.card_view_4_competition_and_cooperation);
            cardView5 = (CardView) view.findViewById(R.id.card_view_5_diversity);
            cardView1 = (CardView) view.findViewById(R.id.card_view_1_overview);

             cardView1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
            Intent intent = new Intent(getContext(), Overview.class);
            Overview.activity_name = R.layout.activity_big_idea_4_overview;
            startActivity(intent);
            }
            });

             cardView2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
            startActivity(new Intent(getContext(), InteractionsToProperties1.class));
            }
            });

             cardView3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
            startActivity(new Intent(getContext(), InteractionsToProperties2.class));
            }
            });

             cardView4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
            startActivity(new Intent(getContext(), CompetitionAndCooperation.class));
            }
            });
             cardView5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
            startActivity(new Intent(getContext(), Diversity.class));
            }
            });

            image_2 = (ImageView) view.findViewById(R.id.interactions_to_properties_1);
            image_3 = (ImageView) view.findViewById(R.id.interactions_to_properties_2);
            image_4 = (ImageView) view.findViewById(R.id.competition_and_cooperation);
            image_5 = (ImageView) view.findViewById(R.id.diversity);
            Glide.with(this).load(R.drawable.interactions_to_properties_1).into(image_2);
            Glide.with(this).load(R.drawable.interactions_to_properties_2).into(image_3);
            Glide.with(this).load(R.drawable.competition_and_cooperation).into(image_4);
            Glide.with(this).load(R.drawable.diversity).into(image_5);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_big_idea4, container, false);
        }


}
