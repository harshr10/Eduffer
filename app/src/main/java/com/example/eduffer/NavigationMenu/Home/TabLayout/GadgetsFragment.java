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

public class GadgetsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gadgets, container, false);

        CardView ableton , acer , apple , hp , lenovo , microsoft , oneplus , realme , samsung;
        TextView abletontext , acertext , appletext , hptext , lenovotext , microsofttext , oneplustext , realmetext , samsungtext;

        Intent i = new Intent(getActivity(), OpenLinkService.class);

        ableton = view.findViewById(R.id.ableton_cardView);
        ableton.setOnClickListener(view1 -> {
            i.putExtra("link" , "ableton");
            requireActivity().startService(i);
        });

        abletontext = view.findViewById(R.id.Ableton);
        abletontext.setOnClickListener(view1 -> {
            i.putExtra("link" , "ableton");
            requireActivity().startService(i);
        });

        acer = view.findViewById(R.id.acer_cardView);
        acer.setOnClickListener(view1 -> {
            i.putExtra("link" , "acer");
            requireActivity().startService(i);
        });

        acertext = view.findViewById(R.id.Acer);
        acertext.setOnClickListener(view1 -> {
            i.putExtra("link" , "acer");
            requireActivity().startService(i);
        });

        apple = view.findViewById(R.id.apple_cardView);
        apple.setOnClickListener(view1 -> {
            i.putExtra("link" , "apple");
            requireActivity().startService(i);
        });

        appletext = view.findViewById(R.id.Apple);
        appletext.setOnClickListener(view1 -> {
            i.putExtra("link" , "apple");
            requireActivity().startService(i);
        });

        hp = view.findViewById(R.id.hp_cardView);
        hp.setOnClickListener(view1 -> {
            i.putExtra("link" , "hp");
            requireActivity().startService(i);
        });

        hptext = view.findViewById(R.id.HP);
        hptext.setOnClickListener(view1 -> {
            i.putExtra("link" , "hp");
            requireActivity().startService(i);
        });

        lenovo = view.findViewById(R.id.lenovo_cardView);
        lenovo.setOnClickListener(view1 -> {
            i.putExtra("link" , "lenovo");
            requireActivity().startService(i);
        });

        lenovotext = view.findViewById(R.id.Lenovo);
        lenovotext.setOnClickListener(view1 -> {
            i.putExtra("link" , "lenovo");
            requireActivity().startService(i);
        });

        microsoft = view.findViewById(R.id.gmicrosoft_cardView);
        microsoft.setOnClickListener(view1 -> {
            i.putExtra("link" , "gmicrosoft");
            requireActivity().startService(i);
        });

        microsofttext = view.findViewById(R.id.GMicrosoft);
        microsofttext.setOnClickListener(view1 -> {
            i.putExtra("link" , "gmicrosoft");
            requireActivity().startService(i);
        });

        oneplus = view.findViewById(R.id.oneplus_cardView);
        oneplus.setOnClickListener(view1 -> {
            i.putExtra("link" , "oneplus");
            requireActivity().startService(i);
        });

        oneplustext = view.findViewById(R.id.Oneplus);
        oneplustext.setOnClickListener(view1 -> {
            i.putExtra("link" , "oneplus");
            requireActivity().startService(i);
        });

        realme = view.findViewById(R.id.realme_cardView);
        realme.setOnClickListener(view1 -> {
            i.putExtra("link" , "realme");
            requireActivity().startService(i);
        });

        realmetext = view.findViewById(R.id.Realme);
        realmetext.setOnClickListener(view1 -> {
            i.putExtra("link" , "realme");
            requireActivity().startService(i);
        });

        samsung = view.findViewById(R.id.samsung_cardView);
        samsung.setOnClickListener(view1 -> {
            i.putExtra("link" , "samsung");
            requireActivity().startService(i);
        });

        samsungtext = view.findViewById(R.id.Samsung);
        samsungtext.setOnClickListener(view1 -> {
            i.putExtra("link" , "samsung");
            requireActivity().startService(i);
        });
        return view;
    }
    public void onDestroyView() {
        super.onDestroyView();
    }
}