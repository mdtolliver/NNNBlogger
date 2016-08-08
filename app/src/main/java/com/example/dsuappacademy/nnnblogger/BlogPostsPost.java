package com.example.dsuappacademy.nnnblogger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by dsuappacademy on 8/3/16.
 */
public class BlogPostsPost implements Serializable {

    private static final long serialVersionUID = -8959832007991513854L;

    private String title;
    private String blogDate;
    private String blogBody;
    private String blogPics;
    private String featuredImage;
    private ArrayList<String> posts;
    private ArrayList<String> assets;

    //Returns a BlogPostsPost given the expected JSON
//Reads 'title', 'blogDate', 'blogBody', ''featuredImage'
    public static BlogPostsPost fromJson(JSONObject jsonObject, HashMap<String, String> assets) {
        BlogPostsPost b = new BlogPostsPost();
        try {
            JSONObject fields = jsonObject.getJSONObject("fields");
            // Deserialize json into object fields
            b.title = fields.getString("title");
            //blogDate mayneed to be string
            b.blogDate = fields.getString("blogDate");
            b.blogBody = fields.getString("blogBody");
            //not sure wht this looks like
            //b.blogPics = jsonObject.getJSONObject("blogpics");
            if (!fields.isNull("featuredImage")) {
                String image_id = fields.getJSONObject("featuredImage")
                        .getJSONObject("sys").getString("id");
                b.featuredImage = "http:" + assets.get(image_id);
                Log.v("BlogPost", "setting featured image to " + b.getFeaturedImage());
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;

    }
    public static ArrayList<BlogPostsPost> fromJson(JSONArray jsonArray, JSONArray assetsArray) {
        ArrayList<BlogPostsPost> posts = new ArrayList<BlogPostsPost>(jsonArray.length());
        HashMap<String, String> assets = new HashMap<>();
        //BlogPostsPosts b = new BlogPostsPost();
        //process assets Array
        for(int i=0; i < assetsArray.length(); i++){
            JSONObject assetJson = null;
            try {

                String assetId = assetsArray.getJSONObject(i).getJSONObject("sys")
                        .getString("id");
                String url = assetsArray.getJSONObject(i).getJSONObject("fields")
                        .getJSONObject("file").getString("url");
                assets.put(assetId,url);

            } catch (Exception e) {
                e.printStackTrace();
               continue;
            }
        }
        // Process each result in json array, decode and convert to post
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject postJson = null;
            try {
                postJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            BlogPostsPost post = BlogPostsPost.fromJson(postJson, assets);
            if (post != null) {
                posts.add(post);
            }
        }

        return posts;
    }

    public String getTitle() {
        return title;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public String getBlogPics() { return blogPics; }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public String getBlogBody() {
        return blogBody;
    }

}

