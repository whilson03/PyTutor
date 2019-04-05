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
        View rootView = inflater.inflate(R.layout.learn_recycler_view, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);
        LinearLayoutManager topicsLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(topicsLayoutManager);

        // list to hold all topic names objects and their side icons.
        mTopicsList = new ArrayList<>();
        mTopicsList.add(new Topics(R.drawable.pink, getString(R.string.topic_overview)));
        mTopicsList.add(new Topics(R.drawable.blue, getString(R.string.topic_environment_setup)));
        mTopicsList.add(new Topics(R.drawable.green, getString(R.string.topic_basic_syntax)));
        mTopicsList.add(new Topics(R.drawable.orange, getString(R.string.topic_var_type)));
        mTopicsList.add(new Topics(R.drawable.red, getString(R.string.topic_operators)));
        mTopicsList.add(new Topics(R.drawable.green, getString(R.string.topic_strings)));
        mTopicsList.add(new Topics(R.drawable.yellow, getString(R.string.topic_decision_making)));
        mTopicsList.add(new Topics(R.drawable.pink, getString(R.string.topic_loops)));
        mTopicsList.add(new Topics(R.drawable.orange, getString(R.string.topic_list)));
        mTopicsList.add(new Topics(R.drawable.red, getString(R.string.topic_tuples)));
        mTopicsList.add(new Topics(R.drawable.yellow, getString(R.string.topic_dictionary)));
        mTopicsList.add(new Topics(R.drawable.blue, getString(R.string.topic_functions)));
        mTopicsList.add(new Topics(R.drawable.green, getString(R.string.topic_modules)));
        mTopicsList.add(new Topics(R.drawable.orange, getString(R.string.topic_files)));
        mTopicsList.add(new Topics(R.drawable.red, getString(R.string.topic_exceptions)));
        mTopicsList.add(new Topics(R.drawable.yellow, getString(R.string.topic_classes)));


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
