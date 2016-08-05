package com.example.dsuappacademy.nnnblogger;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Created by dsuappacademy on 8/3/16.
 */
public class AssetLoader {
    // AssetLoader.readTextFile(this, "blogger_key.txt");
    public static String readTextFile(Context c, String name) {
        // To load text file
        InputStream input;
        try {
            AssetManager assetManager = c.getAssets();
            input = assetManager.open("helloworld.txt");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            String text = new String(buffer);
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
