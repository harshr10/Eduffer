package com.example.eduffer.NavigationMenu.Home.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.eduffer.R;

public class EntertainmentFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);

        CardView amazonprime , spotify;
        TextView amazonprimetext , spotifytext;

        Intent i = new Intent(getActivity(), OpenLinkService.class);

        amazonprime = view.findViewById(R.id.amazonprime_cardView);
        amazonprime.setOnClickListener(view1 -> {
            i.putExtra("link" , "amazonprime");
            requireActivity().startService(i);
        });

        amazonprimetext = view.findViewById(R.id.AmazonPrime);
        amazonprimetext.setOnClickListener(view1 -> {
            i.putExtra("link" , "amazonprime");
            requireActivity().startService(i);
        });

        spotify = view.findViewById(R.id.spotify_cardView);
        spotify.setOnClickListener(view1 -> {
            i.putExtra("link" , "spotify");
            requireActivity().startService(i);
        });

        spotifytext = view.findViewById(R.id.Spotify);
        spotifytext.setOnClickListener(view1 -> {
            i.putExtra("link" , "spotify");
            requireActivity().startService(i);
        });

        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}