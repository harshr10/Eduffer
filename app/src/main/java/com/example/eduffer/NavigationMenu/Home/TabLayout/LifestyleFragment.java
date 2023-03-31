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

public class LifestyleFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lifestyle, container, false);

        CardView crocs , ericdress , lakme , nike , only ;
        TextView crocstext , ericdresstext , lakmetext , niketext , onlytext;

        Intent i = new Intent(getActivity(), OpenLinkService.class);

        crocs = view.findViewById(R.id.crocs_cardView);
        crocs.setOnClickListener(view1 -> {
            i.putExtra("link" , "crocs");
            requireActivity().startService(i);
        });

        crocstext = view.findViewById(R.id.Crocs);
        crocstext.setOnClickListener(view1 -> {
            i.putExtra("link" , "crocs");
            requireActivity().startService(i);
        });

        ericdress = view.findViewById(R.id.ericdress_cardView);
        ericdress.setOnClickListener(view1 -> {
            i.putExtra("link" , "ericdress");
            requireActivity().startService(i);
        });

        ericdresstext = view.findViewById(R.id.EricDress);
        ericdresstext.setOnClickListener(view1 -> {
            i.putExtra("link" , "ericdress");
            requireActivity().startService(i);
        });

        lakme = view.findViewById(R.id.lakme_cardView);
        lakme.setOnClickListener(view1 -> {
            i.putExtra("link" , "lakme");
            requireActivity().startService(i);
        });

        lakmetext = view.findViewById(R.id.Lakme);
        lakmetext.setOnClickListener(view1 -> {
            i.putExtra("link" , "lakme");
            requireActivity().startService(i);
        });

        nike = view.findViewById(R.id.nike_cardView);
        nike.setOnClickListener(view1 -> {
            i.putExtra("link" , "nike");
            requireActivity().startService(i);
        });

        niketext = view.findViewById(R.id.Nike);
        niketext.setOnClickListener(view1 -> {
            i.putExtra("link" , "nike");
            requireActivity().startService(i);
        });

        only = view.findViewById(R.id.only_cardView);
        only.setOnClickListener(view1 ->  {
            i.putExtra("link" , "only");
            requireActivity().startService(i);
        });

        onlytext = view.findViewById(R.id.Only);
        onlytext.setOnClickListener(view1 ->  {
            i.putExtra("link" , "only");
            requireActivity().startService(i);
        });

        return view;
    }
    public void onDestroyView() {
        super.onDestroyView();
    }
}