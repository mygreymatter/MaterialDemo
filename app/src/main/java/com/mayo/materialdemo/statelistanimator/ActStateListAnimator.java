package com.mayo.materialdemo.statelistanimator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.widget.Button;

import com.mayo.materialdemo.R;

public class ActStateListAnimator extends Activity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_state_list_animator);

        findViewById(R.id.button_reveal_anywhere).setOnTouchListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.i("MaterialDemo", "Its Lollipop");
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
//            b.setOutlineProvider(viewOutlineProvider);


        }
    }

    public void setStateselected(View v) {
        v.setSelected(true);
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

    private void setRevealEffect(View v, int startX, int startY) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewAnimationUtils.createCircularReveal(v,
                    startX,
                    startY,
                    0,
                    v.getHeight() * 2).start();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            setRevealEffect(view, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }
}
