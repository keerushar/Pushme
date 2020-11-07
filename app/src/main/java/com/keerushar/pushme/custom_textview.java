package com.keerushar.pushme;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class custom_textview extends android.support.v7.widget.AppCompatTextView {

    Context context;

    public custom_textview(Context context) {
        super(context);
        this.context = context;
        SetContextFont();
    }

    public custom_textview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        SetContextFont();
    }


    public void SetContextFont(){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"segoepr.ttf");
        this.setTypeface(typeface);
    }
}
