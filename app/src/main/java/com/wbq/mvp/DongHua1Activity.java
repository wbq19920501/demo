package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wbq501 on 2015-12-10 15:13.
 * demo
 */
public class DongHua1Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua1);
        final TextView ceshi1 = (TextView) findViewById(R.id.ceshi3);
        final TextView ceshi2 = (TextView) findViewById(R.id.ceshi2);
        final TextView ceshi3 = (TextView) findViewById(R.id.ceshi3);
        final Animation animation = AnimationUtils.loadAnimation(DongHua1Activity.this, R.anim.donghua2);
        final Animation animation2 = AnimationUtils.loadAnimation(DongHua1Activity.this, R.anim.lefttop);
        final Animation animation3 = AnimationUtils.loadAnimation(DongHua1Activity.this, R.anim.donghua2);
        ceshi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceshi3.startAnimation(animation);
            }
        });
        ceshi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceshi2.startAnimation(animation2);
            }
        });
    }
}
