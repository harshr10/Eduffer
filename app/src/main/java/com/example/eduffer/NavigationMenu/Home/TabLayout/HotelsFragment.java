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

public class HotelsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

        CardView expedia , hostelworld , marriott;
        TextView expediatext , hostelworldtext , marriotttext;

        Intent i = new Intent(getActivity(), OpenLinkService.class);

        expedia = view.findViewById(R.id.expedia_cardView);
        expedia.setOnClickListener(view1 -> {
            i.putExtra("link" , "expedia");
            requireActivity().startService(i);
        });

        expediatext = view.findViewById(R.id.Expedia);
        expediatext.setOnClickListener(view1 -> {
            i.putExtra("link" , "expedia");
            requireActivity().startService(i);
        });

        hostelworld = view.findViewById(R.id.hostelworld_cardView);
        hostelworld.setOnClickListener(view1 -> {
            i.putExtra("link" , "hostelworld");
            requireActivity().startService(i);
        });

        hostelworldtext = view.findViewById(R.id.HostelWorld);
        hostelworldtext.setOnClickListener(view1 -> {
            i.putExtra("link" , "hostelworld");
            requireActivity().startService(i);
        });

        marriott = view.findViewById(R.id.marriott_cardView);
        marriott.setOnClickListener(view1 -> {
            i.putExtra("link" , "marriott");
            requireActivity().startService(i);
        });

        marriotttext = view.findViewById(R.id.Marriott);
        marriotttext.setOnClickListener(view1 ->  {
            i.putExtra("link" , "marriott");
            requireActivity().startService(i);
        });

        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}