package com.niharinfo.anyservice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by chaitanya on 29/7/15.
 */
public class FloatSeekBar extends SeekBar {

    private float max = 20.0f;
    private float min = 0.0f;

    public FloatSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttrs(attrs);
    }

    public FloatSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttrs(attrs);
    }

    public FloatSeekBar(Context context) {
        super(context);
    }

    public float getValue() {
        return (max - min) * ((float) getProgress() / (float) getMax()) + min;
    }

    public void setValue(float value) {
        setProgress((int) ((value - min) / (max - min) * getMax()));
    }

    private void applyAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FloatSeekBar);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.FloatSeekBar_floatMax:
                    this.max = a.getFloat(attr, 20.0f);
                    break;
                case R.styleable.FloatSeekBar_floatMin:
                    this.min = a.getFloat(attr, 0.0f);
                    break;
            }
        }
        a.recycle();
    }
}

