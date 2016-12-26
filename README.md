# ScreenShotView
ScreenShotView is a library to capture screenshot of current view on double tap. It is really easy for users to use it.

# build.gradle
You need to download library and add it into your project.

compile project(':screenshotlib')

# Layout xml file

<?xml version="1.0" encoding="utf-8"?>
<com.material.piyush.screenshotlib.ScreenShotView xmlns:android="http://schemas.android.com/apk/res/android"

    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/layout_host"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.material.piyush.screenshotsample.MainActivity">


    <ImageView
        android:id="@+id/imageView"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_centerInParent="true" />
        
    </com.material.piyush.screenshotlib.ScreenShotView>
        

# Java File

    // you needs to implement View.OnTouchListener and ScreenCaptureListener
  
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
        // leave it blank
        return false;
    }

    // callback method provide bitmap of captured screen. you can use it according to your requirement.

    @Override
    public void onScreenCapture(Bitmap bitmap) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
        mScreenShotView.setBackgroundColor(Color.DKGRAY);
    }
  }
