package com.material.piyush.screenshotlib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Piyush on 12/19/2016.
 */

public class ScreenShotView extends RelativeLayout {

    private Context mContext;
    private GestureDetectorCompat mGestureDetectorCompat;
    private ScreenCaptureListener mScreenCaptureListener;

    public ScreenShotView(Context context) {
        super(context);
        this.mContext = context;
        mGestureDetectorCompat = new GestureDetectorCompat(context, new DoubleTapListener());
    }

    public ScreenShotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        loadProperties();
        mGestureDetectorCompat = new GestureDetectorCompat(context, new DoubleTapListener());
    }

    public ScreenShotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        loadProperties();
        mGestureDetectorCompat = new GestureDetectorCompat(context, new DoubleTapListener());
    }

    private void loadProperties() {
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setScreenCaptureListener(ScreenCaptureListener mScreenCaptureListener){
        this.mScreenCaptureListener=mScreenCaptureListener;
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return mGestureDetectorCompat.onTouchEvent(e);
    }

    private class DoubleTapListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            if(mScreenCaptureListener !=null)
            {
                mScreenCaptureListener.onScreenCapture(getBitmap(((Activity)mContext).getWindow().getDecorView().getRootView()));
            }
            return true;
        }

        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }
    }

    public Bitmap getBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
