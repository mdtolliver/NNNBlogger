package com.example.dsuappacademy.nnnblogger;

//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;
//import com.loopj.android.http.RequestParams;
//
///**
// * Created by dsuappacademy on 8/3/16.
// */
//public class ContentfulClient {
//    private final String API_KEY = "4c3c90277514c7495e03e1253da973f514f7fe95a60b9f4373534ebec3492faf";
//    private final String API_BASE_URL = "https://cdn.contentful.com/spaces/";
//    private AsyncHttpClient client;
//
//    public ContentfulClient() {
//        this.client = new AsyncHttpClient();
//    }
//
//    // http://api.contentful.com/api/public/v1.0/lists/post/blog_posts.json?apikey=<key>
//    public void getBlogPosts(JsonHttpResponseHandler handler) {
//        String url = getApiUrl("lists/Blog Posts/post.json");
//        RequestParams params = new RequestParams("apikey", API_KEY);
//        client.get(url, params, handler);
//    }
//
//    private String getApiUrl(String relativeUrl) {
//        return API_BASE_URL + relativeUrl;
//    }
//}
