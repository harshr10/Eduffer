package com.example.eduffer.NavigationMenu.Home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eduffer.NavigationMenu.Home.TabLayout.EducationFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.EducationFragmentRecyclerView;
import com.example.eduffer.NavigationMenu.Home.TabLayout.EntertainmentFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.GadgetsFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.HotelsFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.LifestyleFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.ThemeParksFragment;
import com.example.eduffer.NavigationMenu.Home.TabLayout.TravelFragment;
import com.google.android.material.tabs.TabLayout;


public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private final HomeFragment mContext;
    private final int totaltabs;

    public SectionsPagerAdapter(HomeFragment context, FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        mContext = context;
        totaltabs = tabLayout.getTabCount();
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
            default:
                EducationFragment educationFrag = new EducationFragment();
                return educationFrag;
            case 1:
                EntertainmentFragment entertainmentFrag = new EntertainmentFragment();
                return entertainmentFrag;
            case 2:
                GadgetsFragment gadgetsFragment = new GadgetsFragment();
                return gadgetsFragment;
            case 3:
                HotelsFragment hotelsFragment = new HotelsFragment();
                return hotelsFragment;
            case 4:
                LifestyleFragment lifestyleFragment = new LifestyleFragment();
                return lifestyleFragment;
            case 5:
                ThemeParksFragment theme_parksFragment = new ThemeParksFragment();
                return theme_parksFragment;
            case 6:
                TravelFragment travelFragment = new TravelFragment();
                return travelFragment;
            case 7:
                EducationFragmentRecyclerView educationFragmentRecyclerView = new EducationFragmentRecyclerView();
                return educationFragmentRecyclerView;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}