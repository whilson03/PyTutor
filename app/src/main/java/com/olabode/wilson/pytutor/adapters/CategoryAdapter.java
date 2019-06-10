package com.olabode.wilson.pytutor.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.olabode.wilson.pytutor.fragment_exercises.BasicsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.ConditionalsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.FilesHandlingFragment;
import com.olabode.wilson.pytutor.fragment_exercises.FunctionsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.OOPFragment;

public class CategoryAdapter extends FragmentPagerAdapter {


    private String[] tabTitles = new String[]{"Basics", "Conditionals & Loops ", "Functions", "Files", "OOP"};


    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BasicsFragment();

        } else if (position == 1) {
            return new ConditionalsFragment();

        } else if (position == 2) {
            return new FunctionsFragment();

        } else if (position == 3) {
            return new FilesHandlingFragment();

        } else {
            return new OOPFragment();

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    // get current tab title
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
