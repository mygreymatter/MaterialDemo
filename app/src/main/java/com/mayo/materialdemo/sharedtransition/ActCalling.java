package com.mayo.materialdemo.sharedtransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mayo.materialdemo.R;
import com.mayo.materialdemo.Tags;
import com.mayo.materialdemo.flexiblespace.ActFlexibleSpace;

public class ActCalling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_calling);

        final ImageView sharedView = (ImageView) findViewById(R.id.image);

        sharedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(ActCalling.this, ActCalled.class);
                String transitionName = getString(R.string.monkey);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(ActCalling.this,
                        sharedView,
                        transitionName);
                startActivity(i, transitionActivityOptions.toBundle());*/
                Intent intent = new Intent(ActCalling.this, ActFlexibleSpace.class);

                int[] screenLocation = new int[2];
                sharedView.getLocationOnScreen(screenLocation);
                int orientation = getResources().getConfiguration().orientation;
                intent.putExtra(Tags.EXTRA_ORIENTATION, orientation);
                intent.putExtra(Tags.EXTRA_LEFT, screenLocation[0]);
                intent.putExtra(Tags.EXTRA_TOP, screenLocation[1]);
                intent.putExtra(Tags.EXTRA_WIDTH, sharedView.getWidth());
                intent.putExtra(Tags.EXTRA_HEIGHT, sharedView.getHeight());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActCalling.this);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
                //overridePendingTransition(0, R.anim.activity_fade_out);
            }
        });

    }

}
