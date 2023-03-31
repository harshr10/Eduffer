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


public class TravelFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        CardView airindia, britishairways, emirates, easemytrip, gofirst, indigo, isic, lufthansa,
                spicejet, surffares, virginatlantic, yatra;
        TextView airindiatext, britishairwaystext, emiratestexttext, easemytriptext, gofirsttext, indigotext,
                isictext, lufthansatext, spicejettext, surffarestext, virginatlantictext, yatratext;

        Intent i = new Intent(getActivity() , OpenLinkService.class);

        airindia = view.findViewById(R.id.airindia_cardview);
        airindia.setOnClickListener(view1 -> {
            i.putExtra("link" , "airindia");
            requireActivity().startService(i);
        });

        airindiatext = view.findViewById(R.id.airindia);
        airindiatext.setOnClickListener(view1 -> {
            i.putExtra("link" , "airindia");
            requireActivity().startService(i);
        });

        britishairways = view.findViewById(R.id.british_cardview);
        britishairways.setOnClickListener(view1 -> {
            i.putExtra("link" , "britishairways");
            requireActivity().startService(i);
        });

        britishairwaystext = view.findViewById(R.id.britishairways);
        britishairwaystext.setOnClickListener(view1 ->{
            i.putExtra("link" , "britishairways");
            requireActivity().startService(i);
        });

        emirates = view.findViewById(R.id.emirates_cardview);
        emirates.setOnClickListener(view1 -> {
            i.putExtra("link" , "emirates");
            requireActivity().startService(i);
        });

        emiratestexttext = view.findViewById(R.id.emirates);
        emiratestexttext.setOnClickListener(view1 -> {
            i.putExtra("link" , "emirates");
            requireActivity().startService(i);
        });

        easemytrip = view.findViewById(R.id.easemytrip_cardview);
        easemytrip.setOnClickListener(view1 -> {
            i.putExtra("link" , "easemytrip");
            requireActivity().startService(i);
        });

        easemytriptext = view.findViewById(R.id.easemytrip);
        easemytriptext.setOnClickListener(view1 -> {
            i.putExtra("link" , "easemytrip");
            requireActivity().startService(i);
        });

        gofirst = view.findViewById(R.id.gofirst_cardView);
        gofirst.setOnClickListener(view1 -> {
            i.putExtra("link" , "gofirst");
            requireActivity().startService(i);
        });

        gofirsttext = view.findViewById(R.id.gofirst);
        gofirsttext.setOnClickListener(view1 -> {
            i.putExtra("link" , "gofirst");
            requireActivity().startService(i);
        });

        indigo = view.findViewById(R.id.indigo_cardView);
        indigo.setOnClickListener(view1 -> {
            i.putExtra("link" , "indigo");
            requireActivity().startService(i);
        });

        indigotext = view.findViewById(R.id.indigo);
        indigotext.setOnClickListener(view1 -> {
            i.putExtra("link" , "indigo");
            requireActivity().startService(i);
        });

        isic = view.findViewById(R.id.isic_cardview);
        isic.setOnClickListener(view1 -> {
            i.putExtra("link" , "isic");
            requireActivity().startService(i);
        });

        isictext = view.findViewById(R.id.isic);
        isictext.setOnClickListener(view1 -> {
            i.putExtra("link" , "isic");
            requireActivity().startService(i);
        });

        lufthansa = view.findViewById(R.id.lufthansa_cardView);
        lufthansa.setOnClickListener(view1 -> {
            i.putExtra("link" , "lufthansa");
            requireActivity().startService(i);
        });

        lufthansatext = view.findViewById(R.id.lufthansa);
        lufthansatext.setOnClickListener(view1 -> {
            i.putExtra("link" , "lufthansa");
            requireActivity().startService(i);
        });

        spicejet = view.findViewById(R.id.spicejet_cardview);
        spicejet.setOnClickListener(view1 -> {
            i.putExtra("link" , "spicejet");
            requireActivity().startService(i);
        });

        spicejettext = view.findViewById(R.id.spicejet);
        spicejettext.setOnClickListener(view1 -> {
            i.putExtra("link" , "spicejet");
            requireActivity().startService(i);
        });

        surffares = view.findViewById(R.id.surffares_cardview);
        surffares.setOnClickListener(view1 -> {
            i.putExtra("link" , "surffares");
            requireActivity().startService(i);
        });

        surffarestext = view.findViewById(R.id.surffares);
        surffarestext.setOnClickListener(view1 -> {
            i.putExtra("link" , "surffares");
            requireActivity().startService(i);
        });

        virginatlantic = view.findViewById(R.id.virginatlantic_cardview);
        virginatlantic.setOnClickListener(view1 -> {
                    i.putExtra("link" , "virginatlantic");
                    requireActivity().startService(i);
                }
        );

        virginatlantictext = view.findViewById(R.id.virginatlantic);
        virginatlantictext.setOnClickListener(view1 ->{
                    i.putExtra("link" , "virginatlantic");
                    requireActivity().startService(i);
                }
        );

        yatra = view.findViewById(R.id.yatra_cardview);
        yatra.setOnClickListener(view1 -> {
            i.putExtra("link" , "yatra");
            requireActivity().startService(i);
        });

        yatratext = view.findViewById(R.id.yatra);
        yatratext.setOnClickListener(view1 -> {
            i.putExtra("link" , "yatra");
            requireActivity().startService(i);
        });

        return view;

    }

    public void onDestroyView() {

        super.onDestroyView();
    }
}