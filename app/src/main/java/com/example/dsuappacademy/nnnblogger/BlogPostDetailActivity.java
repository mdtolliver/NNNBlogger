package com.example.dsuappacademy.nnnblogger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;

import com.squareup.picasso.Picasso;

public class BlogPostDetailActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvBlogDate;
    private TextView tvBlogBody;
    private ImageView ivBlogPics;
    private ImageView ivFeaturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_post_detail);

        // Fetch views
        ivFeaturedImage = (ImageView) findViewById(R.id.ivFeaturedImage);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvBlogDate = (TextView) findViewById(R.id.tvblogDate);
        tvBlogBody = (TextView) findViewById(R.id.tvBlogBody);
        //    ivBlogPics= (ImageView) findViewById(R.id.ivblogPics);

        // Load blog post data
        BlogPostsPost post = (BlogPostsPost)
                getIntent().getSerializableExtra(BlogPostsActivity.POST_DETAIL_KEY);
        loadPost(post);
    }

    // Populate data
    @SuppressLint("NewApi")
    public void loadPost(BlogPostsPost post) {
       // if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
      //      getActionBar().setTitle(post.getTitle());
            tvTitle.setText(post.getTitle());
            tvBlogDate.setText(Html.fromHtml("<b>Blog Date:</b> " + post.getBlogDate()));
            tvBlogBody.setText(Html.fromHtml("<b>Blog Body:</b> " + post.getBlogBody()));
            Picasso.with(this).load(post.getFeaturedImage()).
                    placeholder(R.drawable.blackbeauty).
                    into(ivFeaturedImage);
        }
    }
