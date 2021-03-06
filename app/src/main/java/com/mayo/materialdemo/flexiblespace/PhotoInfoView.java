package com.mayo.materialdemo.flexiblespace;

import android.content.Context;
import android.widget.FrameLayout;

public class PhotoInfoView extends FrameLayout {
    public PhotoInfoView(Context context) {
        super(context);
    }

    /*@Bind(R.id.img_icon)
    ImageView imgIcon;
    @Bind(R.id.txt_title)
    TextView txtTitle;
    @Bind(R.id.txt_sub)
    TextView txtSub;

    public PhotoInfoView(Context context) {
        super(context);
    }

    public PhotoInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.ui_photo_info, this);
        ButterKnife.bind(this);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PhotoInfoView);
        try {
            Drawable iconSrc = a.getDrawable(R.styleable.PhotoInfoView_iconSrc);
            String titleText = a.getString(R.styleable.PhotoInfoView_titleText);
            String subText = a.getString(R.styleable.PhotoInfoView_subText);

            bindData(iconSrc, titleText, subText);
        } finally {
            a.recycle();
        }
    }

    private void bindData(Drawable iconSrc, String titleText, String subText) {
        if (iconSrc != null) imgIcon.setImageDrawable(iconSrc);
        if (titleText != null) txtTitle.setText(titleText);
        if (subText != null) txtSub.setText(subText);
    }

    public void setTitleText(String text) {
        txtTitle.setText(text);
    }
*/
}
