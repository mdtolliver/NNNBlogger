package com.example.dsuappacademy.nnnblogger;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;


public class BlogPostsActivity extends Activity {
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
        fetchBlogPosts();
        setupPostSelectedListener();
    }

    private void fetchBoxOfficeMovies() {
        client = new ContentfulClient();
        client.getBlogPosts(new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int code, JSONObject body) {
                JSONArray items = null;
                try {
                    // Get the movies json array
                    items = body.getJSONArray("posts");
                    // Parse json array into array of model objects
                    ArrayList<BlogPostsPost> movies = BlogPostsPost.fromJson(items);
                    // Load model objects into the adapter which displays them
                    adapterPosts.addAll(Posts);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setupMovieSelectedListener() {
        lvposts.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {
                Intent i = new Intent(BlogPostsActivity.this, BlogPostDetailActivity.class);
                i.putExtra(POST_DETAIL_KEY, adapterPosts.getItem(position));
                startActivity(i);
            }
        });
    }

}
