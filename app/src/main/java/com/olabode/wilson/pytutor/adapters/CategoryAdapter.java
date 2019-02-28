package com.olabode.wilson.pytutor.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.olabode.wilson.pytutor.fragment_exercises.BasicsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.ConditionalsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.DataTypesFragment;
import com.olabode.wilson.pytutor.fragment_exercises.DateAndTime;
import com.olabode.wilson.pytutor.fragment_exercises.FilesHandlingFragment;
import com.olabode.wilson.pytutor.fragment_exercises.FunctionsFragment;
import com.olabode.wilson.pytutor.fragment_exercises.OOPFragment;

public class CategoryAdapter extends FragmentPagerAdapter {


    private String tabTitles[] = new String[]{"Basics", "Conditionals", "Dates/Time", "OOP","Datatypes","Files","Functions"};


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
            return new DateAndTime();

        } else if (position == 3) {
            return new OOPFragment();

        } else if (position == 4) {
            return new DataTypesFragment();

        } else if (position == 5) {
            return new FilesHandlingFragment();
        } else {
            return new FunctionsFragment();
        }

    }

    @Override
    public int getCount() {
        return 7;
    }

    // get current tab title
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
