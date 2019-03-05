package com.olabode.wilson.pytutor.fragment_exercises;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.adapters.CategoryAdapter;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayExercisesFragment extends Fragment {


    public DisplayExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_display_exercises, container, false);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getChildFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Objects.requireNonNull(getActivity()).setTitle(R.string.nav_exercises_fragment_title);

    }
}
