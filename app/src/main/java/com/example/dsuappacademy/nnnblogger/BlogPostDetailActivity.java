package com.example.dsuappacademy.nnnblogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class BlogPostDetailActivity extends Activity {
//
//    private TextView tvTitle;
//    private TextView tvBlogDate;
//    private TextView tvBlogBody;
//    private ImageView ivBlogPics;
//    private ImageView ivFeaturedImage;
//
//
//    @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_blog_post_detail);
//
//        // Fetch views
//            tvTitle = (TextView) findViewById(R.id.tvTitle);
//            tvBlogDate = (TextView) findViewById(R.id.tvBlogDate);
//            tvBlogBody = (TextView) findViewById(R.id.tvBlogBody);
//            ivBlogPics= (ImageView) findViewById(R.id.ivBlogPics);
//            ivFeaturedImage = (ImageView) findViewById(R.id.ivFeaturedImage);
//
//            // Load blog post data
//            BlogPostsPost post = (BlogPostsPost) getIntent().getSerializableExtra(BlogPostsActivity.POST_DETAIL_KEY);
//            loadPost(post);
//        }
//
//        // Populate the data for the blog post
//        @SuppressLint("NewApi")
//        public void loadPost(BlogPostsPost post) {
//            if (android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.HONEYCOMB) {
//                getActionBar().setTitle(post.getTitle());
//            }
//            // Populate data
//            tvTitle.setText(post.getTitle());
//            tvBlogDate.setText(Html.fromHtml("<b>Blog Date:</b> " + post.getBlogdate()));
//            tvBlogBody.setText(Html.fromHtml("<b>Blog Body:</b> " + post.getBlogbody()));
//            ivBlogPics.setImageDrawable(Html.fromHtml("<b>Blog Pics:</b> " + post.getBlogpics));
//            ivFeaturedImage.setImageDrawable(Html.fromHtml("<b>Featured Image:</b> " + post.getFeaturedimage));
//    }
}
