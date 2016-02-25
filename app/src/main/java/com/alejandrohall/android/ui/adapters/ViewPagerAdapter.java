package com.alejandrohall.android.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandrohall on 24/02/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentsOfViewPager;
    private List<String> titleFragmentsOfViewPager;

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        this.fragmentsOfViewPager = new ArrayList<>();
        this.titleFragmentsOfViewPager = new ArrayList<>();
    }

    public void add(Fragment fragment, String title){
        this.fragmentsOfViewPager.add(fragment);
        this.titleFragmentsOfViewPager.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsOfViewPager.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsOfViewPager.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragmentsOfViewPager.get(position);
    }
}
