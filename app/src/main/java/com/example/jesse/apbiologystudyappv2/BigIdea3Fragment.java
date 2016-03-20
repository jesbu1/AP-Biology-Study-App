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



public class BigIdea3Fragment extends Fragment {
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

    public BigIdea3Fragment() {
        // Required empty public constructor
    }


    public static BigIdea3Fragment newInstance() {
        BigIdea3Fragment fragment = new BigIdea3Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        cardView2 = (CardView) view.findViewById(R.id.card_view_2_DNA_and_RNA);
        cardView3 = (CardView) view.findViewById(R.id.card_view_3_expression_of_genetic_info);
        cardView4 = (CardView) view.findViewById(R.id.card_view_4_genetic_variation);
        cardView5 = (CardView) view.findViewById(R.id.card_view_5_chemical_signaling);
        cardView1 = (CardView) view.findViewById(R.id.card_view_1_overview);
        cardView6 = (CardView) view.findViewById(R.id.card_view_6_results_of_signaling);

        cardView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Overview.class);
                Overview.activity_name = R.layout.activity_big_idea3_overview;
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DnaAndRna.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ExpressionOfGeneticInfo.class));
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GeneticVariation.class));
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChemicalSignaling.class));
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ResultsOfSignaling.class));
            }
        });
        image_2 = (ImageView) view.findViewById(R.id.DNA_and_RNA);
        image_3 = (ImageView) view.findViewById(R.id.expression_of_genetic_info);
        image_4 = (ImageView) view.findViewById(R.id.genetic_variation);
        image_5 = (ImageView) view.findViewById(R.id.chemical_signaling);
        image_6 = (ImageView) view.findViewById(R.id.results_of_signaling);
        Glide.with(this).load(R.drawable.dna_and_rna).into(image_2);
        Glide.with(this).load(R.drawable.expression_of_genetic_info).into(image_3);
        Glide.with(this).load(R.drawable.genetic_variation).into(image_4);
        Glide.with(this).load(R.drawable.chemical_signaling).into(image_5);
        Glide.with(this).load(R.drawable.results_of_signaling).into(image_6);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_big_idea3, container, false);
    }

}
