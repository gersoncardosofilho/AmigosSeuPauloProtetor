package com.example.gerso.amigosseupauloprotetor.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gerso.amigosseupauloprotetor.activity.fragments.FragmentContas;
import com.example.gerso.amigosseupauloprotetor.activity.fragments.FragmentFacebook;
import com.example.gerso.amigosseupauloprotetor.activity.fragments.FragmentNovidades;

/**
 * Created by gerso on 6/15/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                //FragmentNovidades tab1 = new FragmentNovidades();
                FragmentFacebook tab1 = new FragmentFacebook();
                return tab1;

            case 1:
                FragmentContas tab2 = new FragmentContas();
                return tab2;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
