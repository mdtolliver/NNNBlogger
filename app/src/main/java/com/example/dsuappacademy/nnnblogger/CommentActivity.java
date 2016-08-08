package com.example.dsuappacademy.nnnblogger;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
    public void commentActivity(View view) {
            //Intent to open email & submit new member.
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mdtolliver@hotmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Reader feedback engages others in #DefiningBlackCommunity");

            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
        }

}


