package com.dreaminreality.ranad_000.yugiohcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class coinTossFrag extends Fragment {

    public static final Random RANDOM = new Random();
    private ImageView coin;
    private Button btn;


    public static coinTossFrag newInstance() {
        coinTossFrag fragment = new coinTossFrag();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_coin_toss, container, false);

        final Random rng = new Random();

        final Button closeFragment = (Button) view.findViewById(R.id.close_dice_frag_btn);
        final ImageView imageViewDice = (ImageView) view.findViewById(R.id.dice_image);

        //imageViewDice = view.findViewById(R.id.dice_image);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinToss(view);
            }
        });


        closeFragment.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 closeFragment();
                                             }
                                         }
        );

        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coinToss(view);
            }
        });


        return view;
    }


    private void closeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

    }

    private void coinToss(View view) {
        Random rng = new Random();
        int randomNumber = rng.nextInt(2) + 1;
        ImageView imageViewDice = (ImageView) view.findViewById(R.id.dice_image);

        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.coin_heads);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.coin_tails);
                break;
        }
    }

}
