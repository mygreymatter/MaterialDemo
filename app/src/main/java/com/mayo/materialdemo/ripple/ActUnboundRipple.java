package com.mayo.materialdemo.ripple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mayo.materialdemo.R;

/**
 * Illustrates unbound_ripple effect of Material design.
 * The unbound_ripple occurs beyond the boundaries of the parent view.
 */
public class ActUnboundRipple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_unbound_ripple);
    }

}
