package com.example.receptsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Profile extends Fragment {

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the CardView within the fragment's layout
        CardView getStartedCard = rootView.findViewById(R.id.myrecept);

        // Set an OnClickListener on the CardView
        getStartedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the ReceptPage activity
                Intent intent = new Intent(getActivity(), ReceptPage.class);
                startActivity(intent); // Start the ReceptPage activity
            }
        });

        return rootView;
    }
}
