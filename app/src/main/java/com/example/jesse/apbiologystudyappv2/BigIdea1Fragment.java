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

public class BigIdea1Fragment extends Fragment {
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardViewOverview;
    private ImageView image_1;
    private ImageView image_2;
    private ImageView image_3;
    private ImageView image_4;


    public BigIdea1Fragment() {
        // Required empty public constructor
    }


    public static BigIdea1Fragment newInstance() {
        BigIdea1Fragment fragment = new BigIdea1Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardView1 = (CardView) view.findViewById(R.id.card_view_1_natural_selection);
        cardView2 = (CardView) view.findViewById(R.id.card_view_2_descent_and_ancestry);
        cardView3 = (CardView) view.findViewById(R.id.card_view_3_speciation);
        cardView4 = (CardView) view.findViewById(R.id.card_view_4_origin_of_life);
        cardViewOverview = (CardView) view.findViewById(R.id.card_view_overview);
        image_1 = (ImageView) view.findViewById(R.id.apple_tree_image);
        image_2 = (ImageView) view.findViewById(R.id.gravestones_image);
        image_3 = (ImageView) view.findViewById(R.id.dinosaur_image);
        image_4 = (ImageView) view.findViewById(R.id.bacteria_image);
        Glide.with(this).load(R.drawable.apple_tree).into(image_1);
        Glide.with(this).load(R.drawable.gravestones).into(image_2);
        Glide.with(this).load(R.drawable.dinosaur).into(image_3);
        Glide.with(this).load(R.drawable.bacteria).into(image_4);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NaturalSelectionActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DescentAndAncestry.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SpeciationAndExtinction.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OriginOfLife.class);
                startActivity(intent);
            }
        });
        cardViewOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Overview.class);
                Overview.activity_name = R.layout.activity_big_idea_1_overview;
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_big_idea1, container, false);
    }

}
