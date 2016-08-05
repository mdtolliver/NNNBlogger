package com.example.dsuappacademy.nnnblogger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


///**
// * Created by dsuappacademy on 8/3/16.
// */

    public class BlogPostsAdapter extends ArrayAdapter<BlogPostsPost> {

        public BlogPostsAdapter(Context context, ArrayList<BlogPostsPost> aBlogPosts) {
            super(context, 0, aBlogPosts);
        }

        @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//            // Get the data item for this position
        BlogPostsPost blog = getItem(position);
//            // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.adapter_item_blog_posts, null);
           }
//            // Lookup view for data population
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvblogDate = (TextView) convertView.findViewById(R.id.tvblogDate);
            TextView tvblogBody = (TextView) convertView.findViewById(R.id.tvblogBody);
            //ImageView ivblogPics = (ImageView) convertView.findViewById(R.id.ivblogPics);
            //ImageView ivfeaturedImage = (ImageView) convertView.findViewById(R.id.ivFeaturedImage);

//            // Populate the data into the template view using the data object
            tvTitle.setText(blog.getTitle());
            tvblogDate.setText(blog.getBlogDate());
            tvblogBody.setText(blog.getBlogBody());
            //ivblogPics.setImageDrawable(blog.getBlogPics());
            //ivfeaturedImage.setImageDrawable(blog.getfeaturedImage());

//            // Return the completed view to render on screen
            return convertView;

        }
    }
