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


public class ThemeParksFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_themeparks, container, false);

        CardView imagicaa, wonderla, worldsofwonder;

        TextView imagicaatext, wonderlatext, worldsofwondertext;

        Intent i = new Intent(getActivity() , OpenLinkService.class);

        imagicaa = view.findViewById(R.id.imagicaa_cardView);
        imagicaa.setOnClickListener(view1 -> {
            i.putExtra("link" , "imagicaa");
            requireActivity().startService(i);
        });

        imagicaatext = view.findViewById(R.id.imagicaa);
        imagicaatext.setOnClickListener(view1 -> {
            i.putExtra("link" , "imagicaa");
            requireActivity().startService(i);
        });

        wonderla = view.findViewById(R.id.wonderla_cardview);
        wonderla.setOnClickListener(view1 -> {
            i.putExtra("link" , "wonderla");
            requireActivity().startService(i);
        });

        wonderlatext = view.findViewById(R.id.wonderla);
        wonderlatext.setOnClickListener(view1 -> {
            i.putExtra("link" , "wonderla");
            requireActivity().startService(i);
        });

        worldsofwonder = view.findViewById(R.id.worldsofwonder_cardview);
        worldsofwonder.setOnClickListener(view1 -> {
            i.putExtra("link" , "worldsofwonder");
            requireActivity().startService(i);
        });

        worldsofwondertext = view.findViewById(R.id.worldsofwonder);
        worldsofwondertext.setOnClickListener(view1 -> {
            i.putExtra("link" , "worldsofwonder");
            requireActivity().startService(i);
        });

        return view;

    }
    public void onDestroyView() {

        super.onDestroyView();
    }
}