package com.material.piyush.screenshotsample;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.material.piyush.screenshotlib.ScreenCaptureListener;
import com.material.piyush.screenshotlib.ScreenShotView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, ScreenCaptureListener {

    ScreenShotView mScreenShotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreenShotView = (ScreenShotView) findViewById(R.id.layout_host);
        mScreenShotView.setOnTouchListener(this);
        mScreenShotView.setScreenCaptureListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onScreenCapture(Bitmap bitmap) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
        mScreenShotView.setBackgroundColor(Color.DKGRAY);
    }
}
