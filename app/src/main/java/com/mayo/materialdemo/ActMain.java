package com.mayo.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mayo.materialdemo.cardview.ActCardView;
import com.mayo.materialdemo.flexiblespace.ActFlexibleSpace;
import com.mayo.materialdemo.recyclerview.ActRecyclerView;
import com.mayo.materialdemo.reveal.ActReveal;
import com.mayo.materialdemo.ripple.ActCustomRipple;
import com.mayo.materialdemo.ripple.ActRipple;
import com.mayo.materialdemo.sharedtransition.ActCalling;
import com.mayo.materialdemo.touchfeedback.ActTouch;
import com.mayo.materialdemo.transition.ActTransition;


public class ActMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
    }

    public void showRecyclerView(View v){
        startActivity(new Intent(this, ActRecyclerView.class));
    }

    public void showCardView(View v){
        startActivity(new Intent(this, ActCardView.class));
    }

    public void showUnboundRipple(View v){
        startActivity(new Intent(this, ActCustomRipple.class));
    }

    public void showBoundRipple(View v){
        startActivity(new Intent(this, ActRipple.class));
    }

    public void showSharedTransition(View v){
        startActivity(new Intent(this, ActCalling.class));
    }

    public void showTransition(View v){
        startActivity(new Intent(this, ActTransition.class));
    }

    public void showFlexibleSpace(View v){ startActivity(new Intent(this, ActFlexibleSpace.class));}

    public void showReveal(View v){startActivity(new Intent(this, ActReveal.class));}

    public void showTouchfeedback(View v) {
        startActivity(new Intent(this, ActTouch.class));
    }
}
