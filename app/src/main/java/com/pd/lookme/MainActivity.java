package com.pd.lookme;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.pd.lookatme.LookAtMe;

public class MainActivity extends AppCompatActivity {

    private LookAtMe lookAtMe;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lookAtMe = findViewById(R.id.lookme);
        textView = findViewById(R.id.textView2);

        lookAtMe.init(this);
        lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));

        lookAtMe.start();
        lookAtMe.setLookMe();

        this.showStatus();
    }

    public void showStatus() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String message = lookAtMe.getStatus();
                textView.setText(message);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lookAtMe.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lookAtMe.paused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lookAtMe.destroy();
    }
}
