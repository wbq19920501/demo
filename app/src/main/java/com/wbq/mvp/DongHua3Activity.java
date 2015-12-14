package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wbq501 on 2015-12-11 16:37.
 * demo
 */
public class DongHua3Activity extends Activity{
    AnimatorSet animatorset1,animatorset2,animatorset3;
    TextView ceshi1,ceshi2,ceshi3,henxian;
    ObjectAnimator animleftdown1,animleftdown2,animdownright1,animdownright2,animrightleft1
            ,animrightleft2,animrightleft3,animrightleft4;
    ObjectAnimator animleftdownleft1,animleftdownleft2,animdownrightleft1,animdownrightleft2,animrightleftleft1
            ,animrightleftleft2,animrightleftleft3,animrightleftleft4;
    int changleft = 1;
    int changright = 1;
    int xleft,x,xright,y,downy;
    ImageView imganim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua2);
        ceshi1 = (TextView) findViewById(R.id.ceshi1);
        ceshi2 = (TextView) findViewById(R.id.ceshi2);
        ceshi3 = (TextView) findViewById(R.id.ceshi3);
        henxian = (TextView) findViewById(R.id.henxian);
        imganim = (ImageView) findViewById(R.id.imganim);
        ceshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
            }
        });
        ceshi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
            }
        });
        ceshi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(DongHua3Activity.this,"2222222",Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }
    private void imganimleft() {
        Toast.makeText(DongHua3Activity.this,"111111",Toast.LENGTH_SHORT).show();
        int x1 = imganim.getLeft();
        int imgw = imganim.getRight()-x1;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int x2 = dm.widthPixels;
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imganim,"X",x1,-imgw);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imganim,"X",x2,x1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator2).after(objectAnimator1);
        animatorSet.setDuration(350);
        animatorSet.start();
        ObjectAnimator oaxian = ObjectAnimator.ofFloat(henxian,"X",ceshi1.getLeft(),henxian.getLeft());
        AnimatorSet asxian = new AnimatorSet();
        asxian.play(oaxian);
        asxian.setDuration(800);
        asxian.start();
    }

    private void chooseanimleft(int i) {
        changxy();
        switch (i){
            case 1:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi1,"X",xleft,xleft);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", y, -downy);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi1,"X",xright,xright);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi1, "Y", -downy, y);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi2,"X",x,xleft);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", downy, y);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi3,"X",xright,x);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi3,"Y",y,downy);
                break;
            case 2:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi2,"X",xleft,xleft);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", y, -downy);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi2,"X",xright,xright);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi2, "Y", -downy, y);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi3,"X",x,xleft);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", downy, y);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi1,"X",xright,x);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi1,"Y",y,downy);
                break;
            case 3:
                animrightleftleft1 = ObjectAnimator.ofFloat(ceshi3,"X",xleft,xleft);
                animrightleftleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", y, -downy);
                animrightleftleft3 = ObjectAnimator.ofFloat(ceshi3,"X",xright,xright);
                animrightleftleft4 = ObjectAnimator.ofFloat(ceshi3, "Y", -downy, y);
                animdownrightleft1 = ObjectAnimator.ofFloat(ceshi1,"X",x,xleft);
                animdownrightleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", downy, y);
                animleftdownleft1 = ObjectAnimator.ofFloat(ceshi2,"X",xright,x);
                animleftdownleft2 = ObjectAnimator.ofFloat(ceshi2,"Y",y,downy);
                break;
        }
    }

    private void changxy() {
        xleft = ceshi1.getLeft();
        x = ceshi2.getLeft();
        xright = ceshi3.getLeft();
        y = ceshi1.getTop();
        downy = ceshi2.getTop();
    }

    private void chooseanimright(int i) {
        changxy();
        switch (i){
            case 1:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi1,"X",xleft,x);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi1,"Y",y,downy);
                animdownright1 = ObjectAnimator.ofFloat(ceshi2,"X",x,xright);
                animdownright2 = ObjectAnimator.ofFloat(ceshi2, "Y", downy, y);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi3,"X",xright,xright);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi3, "Y", y, -downy);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi3,"X",xleft,xleft);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi3, "Y", -downy, y);
                break;
            case 2:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi3,"X",xleft,x);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi3,"Y",y,downy);
                animdownright1 = ObjectAnimator.ofFloat(ceshi1,"X",x,xright);
                animdownright2 = ObjectAnimator.ofFloat(ceshi1, "Y", downy, y);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi2,"X",xright,xright);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi2, "Y", y, -downy);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi2,"X",xleft,xleft);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi2, "Y", -downy, y);
                break;
            case 3:
                animleftdown1 = ObjectAnimator.ofFloat(ceshi2,"X",xleft,x);
                animleftdown2 = ObjectAnimator.ofFloat(ceshi2,"Y",y,downy);
                animdownright1 = ObjectAnimator.ofFloat(ceshi3,"X",x,xright);
                animdownright2 = ObjectAnimator.ofFloat(ceshi3, "Y", downy, y);
                animrightleft1 = ObjectAnimator.ofFloat(ceshi1,"X",xright,xright);
                animrightleft2 = ObjectAnimator.ofFloat(ceshi1, "Y", y, -downy);
                animrightleft3 = ObjectAnimator.ofFloat(ceshi1,"X",xleft,xleft);
                animrightleft4 = ObjectAnimator.ofFloat(ceshi1, "Y", -downy, y);
                break;
        }
    }
    private void clickanimleft() {
        animatorset1 = new AnimatorSet();
        animatorset2 = new AnimatorSet();
        animatorset3 = new AnimatorSet();
        animatorset1.setDuration(800);
        animatorset1.setInterpolator(new LinearInterpolator());
        animatorset1.playTogether(animleftdownleft1, animleftdownleft2);
        animatorset1.start();
        animatorset2.setDuration(800);
        animatorset2.setInterpolator(new LinearInterpolator());
        animatorset2.playTogether(animdownrightleft1, animdownrightleft2);
        animatorset2.start();
        animatorset3.setDuration(400);
        animatorset3.setInterpolator(new LinearInterpolator());
        animatorset3.playTogether(animrightleftleft1, animrightleftleft2);
        animatorset3.start();
        animatorset3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorset3 = new AnimatorSet();
                animatorset3.setDuration(400);
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
