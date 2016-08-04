package com.example.dsuappacademy.nnnblogger;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.TextUtils;
/**
 * Created by dsuappacademy on 8/3/16.
 */
public class BlogPostsPost implements Serializable {

    private static final long serialVersionUID = -8959832007991513854L;

    private String title;
    private int blogDate;
    private String blogBody;
    private String blogPics;
    private String featuredImage;

    public static ArrayList<BlogPostsPost> fromJson(JSONArray jsonArray) {
        ArrayList<BlogPostsPost> posts = new ArrayList<BlogPostsPost>(jsonArray.length());
        // Process each result in json array, decode and convert to movie
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject postJson = null;
            try {
                postJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            BlogPostsPost post = BlogPostsPost.fromJson(postJson);
            if (post != null) {
                posts.add(post);
            }
        }

        return posts;
    }

    // Returns a BoxOfficeMovie given the expected JSON
    // Reads `title`, `year`, `synopsis`, `posters.thumbnail`,
    // `ratings.critics_score` and the `abridged_cast`
    public static BlogPostsPost fromJson(JSONObject jsonObject) {
        BlogPostsPost b = new BlogPostsPost();
        try {
            // Deserialize json into object fields
            b.title = jsonObject.getString("title");
            b.blogDate = jsonObject.getInt("blogDate");
            b.blogBody = jsonObject.getString("blogBody");
            b.blogPics = jsonObject.getJSONObject("blogpics").getString("thumbnail");
            b.featuredImage = jsonObject.getString("featureImage");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;
    }

    public String getTitle() {
        return title;
    }

    public int getBlogdate() {
        return blogDate;
    }

    public String getBlogpics() {
        return blogPics;
    }

    public String getFeaturedimage() {
        return featuredImage;
    }

}

