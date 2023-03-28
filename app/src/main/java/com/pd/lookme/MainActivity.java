package com.pd.lookme;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        //lookAtMe.init(this); for eye tracking status
        lookAtMe.initWithSmilingStatus(this); // for smiling status of the user
        lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));

        lookAtMe.start();
        lookAtMe.setLookMe();

        this.showStatus();
    }

    public void showStatus() {
        runOnUiThread(() -> {
            String message = lookAtMe.getStatus();
            textView.setText(message);
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
