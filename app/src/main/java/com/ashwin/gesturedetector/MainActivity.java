package com.ashwin.gesturedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    public static final String TAG = "gesture-detector";

    private ImageView oneImageView, twoImageView;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneImageView = findViewById(R.id.one_imageview);
        twoImageView = findViewById(R.id.two_imageview);

        oneImageView.setOnTouchListener(this);
        twoImageView.setOnTouchListener(this);

        gestureDetector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.w(TAG, "onTouch");
        if (v.getId() == R.id.one_imageview) {
            gestureDetector.onTouchEvent(event);
            return true;
        }

        int action = event.getAction();
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(TAG,"Action was DOWN");
                return true;

            case (MotionEvent.ACTION_MOVE):
                Log.d(TAG,"Action was MOVE | onTouch: (x,y): (" + event.getX() + " , " + event.getY() + ")");
                return true;

            case (MotionEvent.ACTION_UP):
                Log.d(TAG,"Action was UP");
                return true;

            case (MotionEvent.ACTION_CANCEL):
                Log.d(TAG,"Action was CANCEL");
                return true;

            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(TAG,"ACTION_OUTSIDE | Movement occurred outside bounds of current screen element");
                return true;

            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.w(TAG, "onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.w(TAG, "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.w(TAG, "onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.w(TAG, "onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.w(TAG, "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.w(TAG, "onFling");
        return false;
    }

    // For double-tap
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.w(TAG, "onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.w(TAG, "onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.w(TAG, "onDoubleTapEvent");
        return false;
    }
}
