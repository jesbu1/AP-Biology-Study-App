package com.example.jesse.apbiologystudyappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BigIdea2Fragment extends android.support.v4.app.Fragment {
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardView5;
    private CardView cardView6;
    private CardView cardView1;
    private ImageView image_2;
    private ImageView image_3;
    private ImageView image_4;
    private ImageView image_5;
    private ImageView image_6;

    public BigIdea2Fragment() {
        // Required empty public constructor
    }


    public static BigIdea2Fragment newInstance() {
        BigIdea2Fragment fragment = new BigIdea2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        cardView2 = (CardView) view.findViewById(R.id.card_view_2_free_energy);
        cardView3 = (CardView) view.findViewById(R.id.card_view_3_internal_external_environments);
        cardView4 = (CardView) view.findViewById(R.id.card_view_4_feedback_mechanisms);
        cardView5 = (CardView) view.findViewById(R.id.card_view_5_biological_systems_interactions);
        cardView1 = (CardView) view.findViewById(R.id.card_view_1_overview);
        cardView6 = (CardView) view.findViewById(R.id.card_view_6_timing_and_coordination);

        cardView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Overview.class);
                Overview.activity_name = R.layout.activity_big_idea2_overview;
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FreeEnergy.class));
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SeparationOfEnvironment.class));
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FeedbackMechanisms.class));
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BiologicalSystemsInteractions.class));
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TimingAndCoordination.class));
            }
        });
        image_2 = (ImageView) view.findViewById(R.id.free_energy);
        image_3 = (ImageView) view.findViewById(R.id.separation_of_environment);
        image_4 = (ImageView) view.findViewById(R.id.feedback_mechanisms);
        image_5 = (ImageView) view.findViewById(R.id.biological_systems_interactions_image);
        image_6 = (ImageView) view.findViewById(R.id.timing_and_coordination_image);
        Glide.with(this).load(R.drawable.free_energy).into(image_2);
        Glide.with(this).load(R.drawable.separation_of_environment).into(image_3);
        Glide.with(this).load(R.drawable.feedback_mechanisms).into(image_4);
        Glide.with(this).load(R.drawable.biological_systems_interactions).into(image_5);
        Glide.with(this).load(R.drawable.timing_and_coordination).into(image_6);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_big_idea2, container, false);
    }

}
