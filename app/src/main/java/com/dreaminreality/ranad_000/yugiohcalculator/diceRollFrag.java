package com.dreaminreality.ranad_000.yugiohcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.Random;


public class diceRollFrag extends Fragment {
    public static diceRollFrag newInstance() {
        diceRollFrag fragment = new diceRollFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dice_roll, container, false);

        final Random rng = new Random();

        final Button closeFragment = (Button) view.findViewById(R.id.close_dice_frag_btn);
        final ImageView imageViewDice = (ImageView) view.findViewById(R.id.dice_image);

        //imageViewDice = view.findViewById(R.id.dice_image);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(view);
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
                rollDice(view);
            }
        });


        return view;
    }


    private void closeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        //getActivity().getFragmentManager().popBackStack();
    }

    private void rollDice(View view) {
        Random rng = new Random();
        int randomNumber = rng.nextInt(6) + 1;
        ImageView imageViewDice = (ImageView) view.findViewById(R.id.dice_image);

        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.dice6);
                break;
        }
    }

}