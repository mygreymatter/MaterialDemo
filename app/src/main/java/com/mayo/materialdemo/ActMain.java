package com.mayo.materialdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mayo.materialdemo.cardview.ActCardView;
import com.mayo.materialdemo.recyclerview.ActRecyclerView;
import com.mayo.materialdemo.ripple.ActBoundRipple;
import com.mayo.materialdemo.ripple.ActUnboundRipple;


public class ActMain extends Activity {

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
        startActivity(new Intent(this, ActUnboundRipple.class));
    }

    public void showBoundRipple(View v){
        startActivity(new Intent(this, ActBoundRipple.class));
    }

}
