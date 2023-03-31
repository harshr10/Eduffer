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

public class EducationFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_education, container, false);

        CardView adobe  , coursera , evernote , gitHub , impact , microsoft , nytimes ,  testbook , udemy , wix;
        TextView adobetext  , courseratext , evernotetext , gitHubtext ,
                impacttext , microsofttext , nytimestext , testbooktext , udemytext , wixtext;

        Intent i = new Intent(getActivity() , OpenLinkService.class);

        adobe = view.findViewById(R.id.adobe_cardView);
        adobe.setOnClickListener(view1 -> {
            i.putExtra("link" , "adobe");
        requireActivity().startService(i);
        });

        adobetext = view.findViewById(R.id.Adobe);
        adobetext.setOnClickListener(view1 -> {
            i.putExtra("link" , "adobe");
            requireActivity().startService(i);
        });

        coursera = view.findViewById(R.id.coursera_cardView);
        coursera.setOnClickListener(view1 -> {
            i.putExtra("link" , "coursera");
            requireActivity().startService(i);
        });

        courseratext = view.findViewById(R.id.Coursera);
        courseratext.setOnClickListener(view1 -> {
            i.putExtra("link" , "coursera");
            requireActivity().startService(i);
        });

        evernote = view.findViewById(R.id.evernote_cardView);
        evernote.setOnClickListener(view1 -> {
            i.putExtra("link" , "evernote");
            requireActivity().startService(i);
        });

        evernotetext = view.findViewById(R.id.Evernote);
        evernotetext.setOnClickListener(view1 -> {
            i.putExtra("link" , "evernote");
            requireActivity().startService(i);
        });

        gitHub = view.findViewById(R.id.github_cardView);
        gitHub.setOnClickListener(view1 -> {
            i.putExtra("link" , "github");
            requireActivity().startService(i);
        });

        gitHubtext = view.findViewById(R.id.GitHub);
        gitHubtext.setOnClickListener(view1 -> {
            i.putExtra("link" , "github");
            requireActivity().startService(i);
        });

        impact = view.findViewById(R.id.impact_cardView);
        impact.setOnClickListener(view1 -> {
            i.putExtra("link" , "impact");
            requireActivity().startService(i);
        });

        impacttext = view.findViewById(R.id.Impact);
        impacttext.setOnClickListener(view1 -> {
            i.putExtra("link" , "impact");
            requireActivity().startService(i);
        });

        microsoft = view.findViewById(R.id.microsoft_cardView);
        microsoft.setOnClickListener(view1 -> {
            i.putExtra("link" , "microsoft");
            requireActivity().startService(i);
        });

        microsofttext = view.findViewById(R.id.Microsoft);
        microsofttext.setOnClickListener(view1 -> {
            i.putExtra("link" , "microsoft");
            requireActivity().startService(i);
        });

        nytimes = view.findViewById(R.id.nytimes_cardView);
        nytimes.setOnClickListener(view1 -> {
            i.putExtra("link" , "nytimes");
            requireActivity().startService(i);
        });

        nytimestext = view.findViewById(R.id.NYtimes);
        nytimestext.setOnClickListener(view1 -> {
            i.putExtra("link" , "nytimes");
            requireActivity().startService(i);
        });

        testbook = view.findViewById(R.id.testbook_cardView);
        testbook.setOnClickListener(view1 -> {
            i.putExtra("link" , "testbook");
            requireActivity().startService(i);
        });

        testbooktext = view.findViewById(R.id.Testbook);
        testbooktext.setOnClickListener(view1 -> {
            i.putExtra("link" , "testbook");
            requireActivity().startService(i);
        });

        udemy = view.findViewById(R.id.udemy_cardView);
        udemy.setOnClickListener(view1 -> {
            i.putExtra("link" , "udemy");
            requireActivity().startService(i);
        });

        udemytext = view.findViewById(R.id.Udemy);
        udemytext.setOnClickListener(view1 -> {
            i.putExtra("link" , "udemy");
            requireActivity().startService(i);
        });

        wix = view.findViewById(R.id.wix_cardView);
        wix.setOnClickListener(view1 -> {
            i.putExtra("link" , "wix");
            requireActivity().startService(i);
        });

        wixtext = view.findViewById(R.id.Wix);
        wixtext.setOnClickListener(view1 ->{
            i.putExtra("link" , "wix");
            requireActivity().startService(i);
        });

        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}