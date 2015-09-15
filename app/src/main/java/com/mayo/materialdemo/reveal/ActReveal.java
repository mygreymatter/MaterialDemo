package com.mayo.materialdemo.reveal;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.widget.Button;

import com.mayo.materialdemo.R;
import com.mayo.materialdemo.Tags;

public class ActReveal extends AppCompatActivity  implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_reveal);

        findViewById(R.id.button_reveal_anywhere).setOnTouchListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.i(Tags.LOG, "Its Lollipop");
            Button b = (Button) findViewById(R.id.button_ripple);

            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void getOutline(View view, Outline outline) {
                    // Or read size directly from the view's width/height
                    int size = 10;
                    outline.setOval(0, 0, size, size);
                }
            };
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            setRevealEffect(v, (int) event.getX(), (int) event.getY());
        }
        return false;
    }

    private void setRevealEffect(View v, int startX, int startY) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewAnimationUtils.createCircularReveal(v,
                    startX,
                    startY,
                    0,
                    v.getHeight() * 2).start();
        }
    }

    public void setRevealEffect(View v) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewAnimationUtils.createCircularReveal(v,
                    v.getWidth(),
                    v.getHeight(),
                    0,
                    v.getHeight() * 2).start();
        }
    }

}
