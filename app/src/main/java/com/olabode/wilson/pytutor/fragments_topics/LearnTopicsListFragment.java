package com.olabode.wilson.pytutor.fragments_topics;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.adapters.RecyclerAdapter;
import com.olabode.wilson.pytutor.classes.Topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearnTopicsListFragment extends Fragment {
    private RecyclerAdapter mReaderRecyclerAdapter;
    private List<Topics> mTopicsList;
    private RecyclerView mRecyclerView;



    public LearnTopicsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tutorial, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);
        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(newsLayoutManager);

        // list to hold all topic names objects and their side icons.
        mTopicsList = new ArrayList<>();
        mTopicsList.add(new Topics(R.drawable.pink, "Overview"));
        mTopicsList.add(new Topics(R.drawable.blue, "Environment Setup"));
        mTopicsList.add(new Topics(R.drawable.green, "Basic Syntax"));
        mTopicsList.add(new Topics(R.drawable.orange, "Variable & Types"));
        mTopicsList.add(new Topics(R.drawable.red, "Basic Operators"));
        mTopicsList.add(new Topics(R.drawable.green, "Strings"));
        mTopicsList.add(new Topics(R.drawable.yellow, "Decision Making"));
        mTopicsList.add(new Topics(R.drawable.pink, "Loops"));
        mTopicsList.add(new Topics(R.drawable.orange, "Lists"));
        mTopicsList.add(new Topics(R.drawable.red, "Tuples"));
        mTopicsList.add(new Topics(R.drawable.yellow, "Dictionary"));
        mTopicsList.add(new Topics(R.drawable.blue, "Functions"));
        mTopicsList.add(new Topics(R.drawable.green, "Modules"));
        mTopicsList.add(new Topics(R.drawable.orange, "Files I/O"));
        mTopicsList.add(new Topics(R.drawable.red, "Exceptions"));
        mTopicsList.add(new Topics(R.drawable.yellow, "Classes & Objects"));


        mReaderRecyclerAdapter = new RecyclerAdapter(getContext(), mTopicsList);
        mRecyclerView.setAdapter(mReaderRecyclerAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Objects.requireNonNull(getActivity()).setTitle(R.string.app_name);
    }
}
