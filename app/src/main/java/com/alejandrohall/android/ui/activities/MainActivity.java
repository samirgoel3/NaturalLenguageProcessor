package com.alejandrohall.android.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alejandrohall.android.R;
import com.alejandrohall.android.ui.adapters.ViewPagerAdapter;
import com.alejandrohall.android.ui.fragments.SentimentFragment;
import com.alejandrohall.android.ui.fragments.StemmFragment;
import com.alejandrohall.android.ui.fragments.TagFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configureViewPager();
    }



    private void configureViewPager(){
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewPagerAdapter.add(new SentimentFragment(), "Sentiment");
        mViewPagerAdapter.add(new StemmFragment(), "Stemm");
        mViewPagerAdapter.add(new TagFragment(), "Tag");

        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
