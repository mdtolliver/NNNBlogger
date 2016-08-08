package com.example.dsuappacademy.nnnblogger;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class BlogPostsActivity extends AppCompatActivity {
    private ListView lvposts;
    private BlogPostsAdapter adapterPosts;
    private ContentfulClient client;
    public static final String POST_DETAIL_KEY = "post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blog_posts);
        lvposts = (ListView) findViewById(R.id.lvPosts);
        ArrayList<BlogPostsPost> aPosts = new ArrayList<BlogPostsPost>();
        adapterPosts = new BlogPostsAdapter(this, aPosts);
        lvposts.setAdapter(adapterPosts);
       // Fetch the data remotely
        fetchBlogPostsPost();
        setupBlogPostSelectedListener();


    }

    private void fetchBlogPostsPost() {
        client = new ContentfulClient();
        client.getBlogPosts(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int code, Header[] headers, JSONObject body) {
                JSONArray items = null;
                JSONArray assets = null;
            //Get items and assets arrays
                try {

                    //Get images array
                    assets = body.getJSONObject("includes").getJSONArray("Asset");

                    // Get the posts json array
                    items = body.getJSONArray("items");


                    // Parse json array into array of model objects
                    ArrayList<BlogPostsPost> posts = BlogPostsPost.fromJson(items, assets);
                    // Load model objects into the adapter which displays them
 //                   for (BlogPostsPost post : posts) {
 //                   }
 //                   adapterPosts.notifyDataSetChanged();
                    adapterPosts.addAll(posts);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setupBlogPostSelectedListener() {
        lvposts.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Intent i = new Intent(BlogPostsActivity.this, BlogPostDetailActivity.class);
                i.putExtra(POST_DETAIL_KEY, adapterPosts.getItem(position));
                startActivity(i);
            }

        });
//  //      lvposts.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//   //         public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
//                Intent i = new Intent(BlogPostsActivity.this, BlogPostDetailActivity.class);
//                i.putExtra(POST_DETAIL_KEY, adapterPosts.getItem(position));
//                startActivity(i);
//            }
//        });

    }}

