package com.masaki_auto.gesturedetect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
//        GestureDetector.OnGestureListener,
//        GestureDetector.OnDoubleTapListener
{
    String TAG = "G/D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnTouchListener otl = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int act = event.getActionMasked();
                buttonUpDown((Button) v, act);
                return false;
            }
        };

        findViewById(R.id.buttonUp).setOnTouchListener(otl);
        findViewById(R.id.buttonDown).setOnTouchListener(otl);
        findViewById(R.id.buttonRollup).setOnTouchListener(otl);
        findViewById(R.id.buttonRolldown).setOnTouchListener(otl);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int act = event.getActionMasked();
        switch (act){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ACTION_DOWN:" + event.toString());
                return true;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "ACTION_CANCEL:" + event.toString());
                return true;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP:" + event.toString());
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    private void buttonUpDown(Button v, int act){
        switch(v.getId()){
            case R.id.buttonUp:
                if(act == MotionEvent.ACTION_DOWN){
                    Log.d(TAG, v.getText() + " => 押");
                }else if(act == MotionEvent.ACTION_UP){
                    Log.d(TAG, v.getText() + " => 離");
                }
                break;
            case R.id.buttonDown:
                if(act == MotionEvent.ACTION_DOWN){
                    Log.d(TAG, v.getText() + " => 押");
                } else if(act == MotionEvent.ACTION_UP){
                    Log.d(TAG, v.getText() + " => 離");
                }
                break;
            case R.id.buttonRollup:
                if(act == MotionEvent.ACTION_DOWN){
                    Log.d(TAG, v.getText() + " => 押");
                } else if(act == MotionEvent.ACTION_UP){
                    Log.d(TAG, v.getText() + " => 離");
                }
                break;
            case R.id.buttonRolldown:
                if(act == MotionEvent.ACTION_DOWN){
                    Log.d(TAG, v.getText() + " => 押");
                } else if(act == MotionEvent.ACTION_UP){
                    Log.d(TAG, v.getText() + " => 離");
                }
                break;
            default:
                break;
        }
    }
}