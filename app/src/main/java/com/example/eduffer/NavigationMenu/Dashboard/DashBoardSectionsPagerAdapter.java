package com.example.eduffer.NavigationMenu.Dashboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eduffer.NavigationMenu.Dashboard.TabLayout.BasicInfoFragment;
import com.example.eduffer.NavigationMenu.Dashboard.TabLayout.UniversityInfoFragment;
import com.google.android.material.tabs.TabLayout;


public class DashBoardSectionsPagerAdapter extends FragmentPagerAdapter {


    private final DashBoardFragment mContext;
    private final int totaltabs;

    public DashBoardSectionsPagerAdapter(DashBoardFragment context, FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        mContext = context;
        totaltabs = tabLayout.getTabCount();
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
            default:
                BasicInfoFragment basicInfoFragment = new BasicInfoFragment();
                return basicInfoFragment;
            case 1:
                UniversityInfoFragment universityInfoFragment = new UniversityInfoFragment();
                return universityInfoFragment;
        }
    }

    @Override
    public int getCount() {
        return totaltabs;
    }

}