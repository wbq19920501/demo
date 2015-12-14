package com.wbq.mvp.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.wbq.mvp.R;

/**
 * Created by wbq501 on 2015-12-14 09:33.
 * demo
 */
public class MyDialog extends AlertDialog{
    TextView dian1,dian2,dian3;
    protected MyDialog(Context context, int theme) {
        super(context, theme);
    }
    public MyDialog(Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogdian);
        dian1 = (TextView) findViewById(R.id.dian1);
        dian2 = (TextView) findViewById(R.id.dian2);
        dian3 = (TextView) findViewById(R.id.dian3);
        final AnimatorSet andian1 = new AnimatorSet();
        final ObjectAnimator oadian1 = ObjectAnimator.ofFloat(dian1, "alpha", 0f, 1f);
        final ObjectAnimator oadian2 = ObjectAnimator.ofFloat(dian2, "alpha", 0f, 1f);
        final ObjectAnimator oadian3 = ObjectAnimator.ofFloat(dian3, "alpha", 0f, 1f);
        andian1.playSequentially(oadian1, oadian2, oadian3);
        andian1.start();
    }
}
