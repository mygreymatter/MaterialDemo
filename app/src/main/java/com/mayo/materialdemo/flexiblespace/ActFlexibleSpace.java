package com.mayo.materialdemo.flexiblespace;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.mayo.materialdemo.R;
import com.mayo.materialdemo.Tags;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

public class ActFlexibleSpace extends AppCompatActivity {
    private static final long ANIMATION_DURATION = 250;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    @Bind(R.id.app_bar)
    AppBarLayout appBarLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.img_preview)
    CustomKenBurnsView imgPreview;
    @Bind(R.id.img_preview_cover)
    ImageView imgPreviewCover;
    @Bind(R.id.img_preview_dummy)
    ImageView imgPreviewDummy;

    private int leftDelta;
    private int topDelta;
    private float widthScale;
    private float heightScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_flexible_space);
        ButterKnife.bind(this);

        initToolbar();
        Bundle bundle = getIntent().getExtras();
        Picasso.with(this)
                .load("http://lorempixel.com/400/200/sports/1/")
                .placeholder(R.color.theme50)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        imgPreview.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });

        if (savedInstanceState == null) {
            final int thumbnailTop = bundle.getInt(Tags.EXTRA_TOP);
            final int thumbnailLeft = bundle.getInt(Tags.EXTRA_LEFT);
            final int thumbnailWidth = bundle.getInt(Tags.EXTRA_WIDTH);
            final int thumbnailHeight = bundle.getInt(Tags.EXTRA_HEIGHT);
//            originalOrientation = bundle.getInt(EXTRA_ORIENTATION);
            ViewTreeObserver observer = imgPreviewDummy.getViewTreeObserver();
            observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    // fab.setVisibility(View.GONE);
//                    FabAnimationUtils.scaleOut(fab, 50, null);

                    imgPreviewDummy.getViewTreeObserver().removeOnPreDrawListener(this);

                    int[] screenLocation = new int[2];
                    imgPreviewDummy.getLocationOnScreen(screenLocation);
                    leftDelta = thumbnailLeft - screenLocation[0];
                    topDelta = thumbnailTop - screenLocation[1];
                    widthScale = (float) thumbnailWidth / (imgPreviewDummy.getWidth());
                    heightScale = (float) thumbnailHeight / imgPreviewDummy.getHeight();

                    startEnterAnimation();

                    return true;
                }
            });
        }
    }

    private void initToolbar() {

        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setHomeAsUpIndicator(R.drawable.ic_back);
            bar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startEnterAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            imgPreviewDummy.setPivotX(0);
            imgPreviewDummy.setPivotY(0);
            imgPreviewDummy.setScaleX(widthScale);
            imgPreviewDummy.setScaleY(heightScale);
            imgPreviewDummy.setTranslationX(leftDelta);
            imgPreviewDummy.setTranslationY(topDelta);
        } else {
            AnimatorProxy proxy = AnimatorProxy.wrap(imgPreviewDummy);
            proxy.setPivotX(0);
            proxy.setPivotY(0);
            proxy.setScaleX(widthScale);
            proxy.setScaleY(heightScale);
            proxy.setTranslationX(leftDelta);
            proxy.setTranslationY(topDelta);
        }

        ViewPropertyAnimator.animate(imgPreviewDummy)
                .setDuration(ANIMATION_DURATION)
                .scaleX(1).scaleY(1)
                .translationX(0).translationY(0)
                .setInterpolator(INTERPOLATOR)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // AppBarLayout is set invisible, because AppbarLayout has default background color.
                        appBarLayout.setVisibility(View.VISIBLE);
                        imgPreview.setVisibility(View.VISIBLE);
                        revealPreview();
                    }
                });
    }

    private void revealPreview() {
        int cx = (imgPreview.getLeft() + imgPreview.getRight()) / 2;
        int cy = (imgPreview.getTop() + imgPreview.getBottom()) / 2;

        float finalRadius = (float) Math.hypot(cx, cy);

        SupportAnimator animator =
                ViewAnimationUtils.createCircularReveal(imgPreview, cx, cy, 0, finalRadius);
        animator.setInterpolator(INTERPOLATOR);
        animator.setDuration(300);
        animator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {
                imgPreviewDummy.setVisibility(View.GONE);
                imgPreviewCover.setVisibility(View.VISIBLE);
                imgPreview.setVisibility(View.VISIBLE);
                imgPreview.restart();
            }

            @Override
            public void onAnimationEnd() {
//                FabAnimationUtils.scaleIn(fab);
            }

            @Override
            public void onAnimationCancel() {
                //
            }

            @Override
            public void onAnimationRepeat() {
                //
            }
        });
        animator.start();
    }


}
