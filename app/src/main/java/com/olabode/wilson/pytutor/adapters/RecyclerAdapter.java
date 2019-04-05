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


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private  final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final List<Topics> mTopics;

    // recycler view constructor
    public RecyclerAdapter(Context context, List<Topics> topics) {
        this.mContext = context;
        this.mTopics = topics;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.learn_recycler_items, viewGroup, false);
        return new ViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //associate each news items in the list vy their positions.
         Topics topic = mTopics.get(position);

         viewHolder.mTopicsTextView.setText(topic.getTopic());
         viewHolder.mTopicLeftIcon.setImageResource(topic.getLeftIcon());
        // news current position
        viewHolder.mCurrentTopicPosition = position;
    }


    @Override
    public int getItemCount() {
        return mTopics.size();
    }


    // view holder class that hold all the items in the card view for each item in the list.
    public class ViewHolder extends RecyclerView.ViewHolder{
        // text view for the topic section.
        public final TextView mTopicsTextView ;
        public final ImageView mTopicLeftIcon;
        public int mCurrentTopicPosition;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mTopicsTextView = (TextView) itemView.findViewById(R.id.learn_topics_text_view);
            mTopicLeftIcon = (ImageView) itemView.findViewById(R.id.learn_topics_left_icon);


            final List<String> mAssetTitle = new ArrayList<>();
            mAssetTitle.add("overview.html");
            mAssetTitle.add("Environment_Setup.html");
            mAssetTitle.add("BasicSyntax.html");
            mAssetTitle.add("variables&datatypes.html");
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



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, LearnContentsActivity.class);
                    i.putExtra("title", mTopics.get(mCurrentTopicPosition).getTopic());
                    i.putExtra("ContentAssetName", mAssetTitle.get(mCurrentTopicPosition));
                    mContext.startActivity(i);


                }
            });


        }
    }
}
