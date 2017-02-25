package com.kelompok16.supercow;

import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;

/**
 * Activity beranda.
 */
public class HomeActivity extends AppCompatActivity {

    private ImageView mSettingIcon;
    private ImageView mShopIcon;
    private RelativeLayout mSocialDrawer;
    private RelativeLayout mInventoryDrawer;
    private TextView mCowName;
    private final String TAG = "HomeActivity";
    private class ActivityGestureDetector extends GestureDetector.SimpleOnGestureListener{
        private final int SWIPE_THRESHOLD = 100;
        private final int SWIPE_VELOCITY_THRESHOLD = 100;

        //Terima kasih, Stack Overflow
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.i(TAG, "MotionEvent e1 : " + e1 + " e2 : " + e2 + " velocity X : "
                    + velocityX + "velocity Y : " + velocityY);
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            result = onSwipeRight();
                        } else {
                            result = onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            result = onSwipeBottom();
                        } else {
                            result = onSwipeTop();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }

        public boolean onSwipeLeft(){
            //transisi ke shop
            Toast.makeText(getApplicationContext(), "Shop", Toast.LENGTH_SHORT);
            return true;
        }

        public boolean onSwipeRight(){
            //transisi ke settings
            Toast.makeText(getApplicationContext(), "setting", Toast.LENGTH_SHORT);
            return true;
        }

        public boolean onSwipeBottom(){
            //transisi ke chat
            Toast.makeText(getApplicationContext(), "chat", Toast.LENGTH_SHORT);
            return true;
        }

        public boolean onSwipeTop(){
            //transisi ke inventory selection
            Toast.makeText(getApplicationContext(), "inventory", Toast.LENGTH_SHORT);
            return true;
        }
    }
    ActivityGestureDetector mGestureDec = new ActivityGestureDetector();

    View.OnTouchListener mActivitySwipeListener = new View.OnTouchListener() {
        Handler mHandler = new Handler(Looper.getMainLooper());//gatau mesti ngeoverride handlemessage atau ga
        Context ctx = getApplicationContext();
        private GestureDetector swipeGestureDetected = new GestureDetector(ctx,
                new ActivityGestureDetector(), mHandler );
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return swipeGestureDetected.onTouchEvent(event);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSettingIcon = (ImageView) findViewById(R.id.icon_settings);
        mShopIcon = (ImageView) findViewById(R.id.icon_shop);
        mInventoryDrawer = (RelativeLayout) findViewById(R.id.inventory_home_drawer);
        mSocialDrawer = (RelativeLayout) findViewById(R.id.center_social_layout);
        mCowName = (TextView) findViewById (R.id.cow_name_text);

        //bikin supaya semua icon yang clickable bisa di-klik-klik
        mSettingIcon.setClickable(true);
        mSettingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bikin visual feedback dengan agak mencerahkan warna
                //punya efek yang sama kayak activity di swipe right
                mGestureDec.onSwipeRight();
            }
        });
        mShopIcon.setClickable(true);
        mShopIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //bikin visual feedback dengan agak mencerahkan warna
                //punya efek yang sama kayak activity di swipe left
                mGestureDec.onSwipeLeft();
            }
        });
        mInventoryDrawer.setClickable(true);
        mInventoryDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGestureDec.onSwipeTop();
            }
        });
        mSocialDrawer.setClickable(true);
        mSocialDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGestureDec.onSwipeRight();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
