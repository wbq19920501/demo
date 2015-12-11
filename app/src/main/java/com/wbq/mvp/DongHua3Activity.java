package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * Created by wbq501 on 2015-12-11 16:37.
 * demo
 */
public class DongHua3Activity extends Activity{
    AnimatorSet animatorset1,animatorset2,animatorset3;
    TextView ceshi1,ceshi2,ceshi3;
    ObjectAnimator animleftdown1,animleftdown2,animdownright1,animdownright2,animrightleft1
            ,animrightleft2,animrightleft3,animrightleft4;
    ObjectAnimator animleftdownleft1,animleftdownleft2,animdownrightleft1,animdownrightleft2,animrightleftleft1
            ,animrightleftleft2,animrightleftleft3,animrightleftleft4;
    int changleft = 1;
    int changright = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua1);
        ceshi1 = (TextView) findViewById(R.id.ceshi1);
        ceshi2 = (TextView) findViewById(R.id.ceshi2);
        ceshi3 = (TextView) findViewById(R.id.ceshi3);
        ceshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseanimright(changright);
                clickanimright();
//                chooseanimleft(changleft);
//                clickanimleft();
            }
        });
        ceshi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseanimright(changright);
                clickanimright();
//                chooseanimleft(changleft);
//                clickanimleft();
            }
        });
        ceshi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseanimright(changright);
                clickanimright();
//                chooseanimleft(changleft);
//                clickanimleft();
            }
        });
    }
    private void chooseanimleft(int i) {
        switch (i){
            case 1:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi1,"X",100,100);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", 0, -40);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi1,"X",500,500);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi1, "Y", -40, 0);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi2,"X",300,100);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", 40, 0);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi3,"X",500,300);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi3,"Y",0,40);
                break;
            case 2:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi2,"X",100,100);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", 0, -40);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi2,"X",500,500);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi2, "Y", -40, 0);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi3,"X",300,100);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", 40, 0);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi1,"X",500,300);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi1,"Y",0,40);
                break;
            case 3:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi3,"X",100,100);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", 0, -40);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi3,"X",500,500);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi3, "Y", -40, 0);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi1,"X",300,100);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", 40, 0);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi2,"X",500,300);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi2,"Y",0,40);
                break;
        }
    }
    private void chooseanimright(int i) {
        switch (i){
            case 1:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi1,"X",100,300);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi1,"Y",0,40);
                animdownright1 = ObjectAnimator.ofFloat(ceshi2,"X",300,500);
                animdownright2 = ObjectAnimator.ofFloat(ceshi2, "Y", 40, 0);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi3,"X",500,500);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", 0, -40);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi3,"X",100,100);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi3, "Y", -40, 0);
                break;
            case 2:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi3,"X",100,300);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi3,"Y",0,40);
                animdownright1 = ObjectAnimator.ofFloat(ceshi1,"X",300,500);
                animdownright2 = ObjectAnimator.ofFloat(ceshi1, "Y", 40, 0);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi2,"X",500,500);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", 0, -40);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi2,"X",100,100);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi2, "Y", -40, 0);
                break;
            case 3:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi2,"X",100,300);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi2,"Y",0,40);
                animdownright1 = ObjectAnimator.ofFloat(ceshi3,"X",300,500);
                animdownright2 = ObjectAnimator.ofFloat(ceshi3, "Y", 40, 0);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi1,"X",500,500);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", 0, -40);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi1,"X",100,100);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi1, "Y", -40, 0);
                break;
        }
    }
    private void clickanimleft() {
        animatorset1 = new AnimatorSet();
        animatorset2 = new AnimatorSet();
        animatorset3 = new AnimatorSet();
        animatorset1.setDuration(1500);
        animatorset1.setInterpolator(new LinearInterpolator());
        animatorset1.playTogether(animleftdownleft1, animleftdownleft2);
        animatorset1.start();
        animatorset2.setDuration(1500);
        animatorset2.setInterpolator(new LinearInterpolator());
        animatorset2.playTogether(animdownrightleft1, animdownrightleft2);
        animatorset2.start();
        animatorset3.setDuration(750);
        animatorset3.setInterpolator(new LinearInterpolator());
        animatorset3.playTogether(animrightleftleft1, animrightleftleft2);
        animatorset3.start();
        animatorset3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorset3 = new AnimatorSet();
                animatorset3.setDuration(750);
                animatorset3.setInterpolator(new LinearInterpolator());
                animatorset3.playTogether(animrightleftleft3, animrightleftleft4);
                animatorset3.start();
            }
        });
        animatorset1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (changleft>2){
                    changleft = 1;
                }else {
                    changleft += 1;
                }
            }
        });
    }
    private void clickanimright() {
        animatorset1 = new AnimatorSet();
        animatorset2 = new AnimatorSet();
        animatorset3 = new AnimatorSet();
        animatorset1.setDuration(1500);
        animatorset1.setInterpolator(new LinearInterpolator());
        animatorset1.playTogether(animleftdown1, animleftdown2);
        animatorset1.start();
        animatorset2.setDuration(1500);
        animatorset2.setInterpolator(new LinearInterpolator());
        animatorset2.playTogether(animdownright1, animdownright2);
        animatorset2.start();
        animatorset3.setDuration(750);
        animatorset3.setInterpolator(new LinearInterpolator());
        animatorset3.playTogether(animrightleft1, animrightleft2);
        animatorset3.start();
        animatorset3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorset3 = new AnimatorSet();
                animatorset3.setDuration(750);
                animatorset3.setInterpolator(new LinearInterpolator());
                animatorset3.playTogether(animrightleft3, animrightleft4);
                animatorset3.start();
            }
        });
        animatorset1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (changright>2){
                    changright = 1;
                }else {
                    changright += 1;
                }
            }
        });
    }
}
