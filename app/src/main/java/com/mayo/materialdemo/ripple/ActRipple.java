package com.mayo.materialdemo.ripple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mayo.materialdemo.R;

/**
 * @author mayo
 *         Illustrates ripple effect which is bounded.
 *         use android:background="?android:attr/selectableItemBackground" instead of bound_ripple drawable
 */
public class ActRipple extends AppCompatActivity {

    private boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_bound_ripple);
    }

    public void setStateselected(View v) {
        isSelected = !isSelected;
        v.setSelected(isSelected);
    }
}