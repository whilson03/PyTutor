package com.olabode.wilson.pytutor.fragments_topics;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.classes.Topics;
import com.olabode.wilson.pytutor.adapters.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


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
        View rootView =  inflater.inflate(R.layout.content_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);
        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(newsLayoutManager);

        // list to hold all topic names objects and their side icons.
        mTopicsList = new ArrayList<>();
        mTopicsList.add(new Topics(R.drawable.pink,"Overview",R.drawable.pink));
        mTopicsList.add(new Topics(R.drawable.blue,"Environment Setup",R.drawable.blue));
        mTopicsList.add(new Topics(R.drawable.green,"Basic Syntax",R.drawable.green));
        mTopicsList.add(new Topics(R.drawable.orange,"Variable & Types",R.drawable.orange));
        mTopicsList.add(new Topics(R.drawable.red,"Basic Operators",R.drawable.red));
        mTopicsList.add(new Topics(R.drawable.yellow,"Decision Making",R.drawable.yellow));
        mTopicsList.add(new Topics(R.drawable.pink,"Loops",R.drawable.pink));
        mTopicsList.add(new Topics(R.drawable.blue,"Numbers",R.drawable.blue));
        mTopicsList.add(new Topics(R.drawable.green,"Strings",R.drawable.green));
        mTopicsList.add(new Topics(R.drawable.orange,"Lists",R.drawable.orange));
        mTopicsList.add(new Topics(R.drawable.red,"Tuples",R.drawable.red));
        mTopicsList.add(new Topics(R.drawable.yellow,"Dictionary",R.drawable.yellow));
        mTopicsList.add(new Topics(R.drawable.pink,"Date & Time",R.drawable.pink));
        mTopicsList.add(new Topics(R.drawable.blue,"Functions",R.drawable.blue));
        mTopicsList.add(new Topics(R.drawable.green,"Modules",R.drawable.green));
        mTopicsList.add(new Topics(R.drawable.orange,"Files I/O",R.drawable.orange));
        mTopicsList.add(new Topics(R.drawable.red,"Exceptions",R.drawable.red));
        mTopicsList.add(new Topics(R.drawable.yellow,"Classes & Objects",R.drawable.yellow));


        mReaderRecyclerAdapter = new RecyclerAdapter(getContext(), mTopicsList);
        mRecyclerView.setAdapter(mReaderRecyclerAdapter);

        return rootView;






    }

}
