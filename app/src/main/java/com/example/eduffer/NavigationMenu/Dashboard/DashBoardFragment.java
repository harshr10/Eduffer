package com.example.eduffer.NavigationMenu.Dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.eduffer.R;
import com.google.android.material.tabs.TabLayout;


public class DashBoardFragment extends Fragment {

    private ViewPager viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TabLayout tabLayout = view.findViewById(R.id.dashboard_tabs);
        viewPager = view.findViewById(R.id.dashboard_view_pager);

        DashBoardSectionsPagerAdapter dashboardsectionsPagerAdapter = new DashBoardSectionsPagerAdapter(this, getChildFragmentManager(), tabLayout);
        viewPager.setAdapter(dashboardsectionsPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

}