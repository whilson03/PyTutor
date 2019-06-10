package com.olabode.wilson.pytutor.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.LearnContentsActivity;
import com.olabode.wilson.pytutor.classes.Topics;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TopicViewHolder> {


    private  final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final List<Topics> mTopics;
    private int mClickedPosition;

    // recycler view constructor
    public RecyclerAdapter(Context context, List<Topics> topics) {
        this.mContext = context;
        this.mTopics = topics;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.learn_recycler_items, viewGroup, false);
        return new TopicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder topicViewHolder, int position) {
        //associate each news items in the list vy their positions.
         Topics topic = mTopics.get(position);

        topicViewHolder.mTopicsTextView.setText(topic.getTopic());
        topicViewHolder.mTopicLeftIcon.setImageResource(topic.getLeftIcon());
        // news current position
        topicViewHolder.mCurrentTopicPosition = position;

        mClickedPosition = position;
    }


    @Override
    public int getItemCount() {
        return mTopics.size();
    }


    // view holder class that hold all the items in the card view for each item in the list.
    public class TopicViewHolder extends RecyclerView.ViewHolder {
        // text view for the topic section.
        public final TextView mTopicsTextView ;
        public final ImageView mTopicLeftIcon;
        public int mCurrentTopicPosition;


        public TopicViewHolder(@NonNull final View itemView) {
            super(itemView);
            mTopicsTextView = itemView.findViewById(R.id.learn_topics_text_view);
            mTopicLeftIcon = itemView.findViewById(R.id.learn_topics_left_icon);


            // list of all the html files from the assets directory
            final List<String> mAssetTitle = new ArrayList<>();
            mAssetTitle.add("overview.html");
            mAssetTitle.add("Environment_Setup.html");
            mAssetTitle.add("BasicSyntax.html");
            mAssetTitle.add("variables.html");
            mAssetTitle.add("basic_operator.html");
            mAssetTitle.add("strings.html");

            mAssetTitle.add("decision_making.html");
            mAssetTitle.add("loops.html");
            mAssetTitle.add("lists.html");
            mAssetTitle.add("Tuples.html");
            mAssetTitle.add("dictionaries.html");
            mAssetTitle.add("functions.html");
            mAssetTitle.add("Modules.html");
            mAssetTitle.add("file.html");
            mAssetTitle.add("exceptions.html");
            mAssetTitle.add("classes.html");

            final int listLength = mAssetTitle.size();


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, LearnContentsActivity.class);
                    i.putExtra("position", getAdapterPosition());
                    i.putExtra("listLength", listLength);
                    i.putExtra("title", mTopics.get(mCurrentTopicPosition).getTopic());
                    i.putExtra("ContentAssetName", mAssetTitle.get(mCurrentTopicPosition));
                    mContext.startActivity(i);


                }
            });


        }
    }


}
