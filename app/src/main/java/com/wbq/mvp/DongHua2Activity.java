package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wbq501 on 2015-12-10 17:30.
 * demo
 */
public class DongHua2Activity extends Activity{
    int change = 0;
    int changeh = 0;
    AnimatorSet set3,set2,set1,set0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua1);
        final TextView ceshi1 = (TextView) findViewById(R.id.ceshi1);
        final TextView ceshi2 = (TextView) findViewById(R.id.ceshi2);
        final TextView ceshi3 = (TextView) findViewById(R.id.ceshi3);
        ceshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changxy(ceshi1, ceshi2, ceshi3);
            }
        });
        ceshi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changxy(ceshi1, ceshi2, ceshi3);
            }
        });
        ceshi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changxy(ceshi1, ceshi2, ceshi3);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int changx = Integer.valueOf((int) event.getX());
        return super.onTouchEvent(event);
    }

    private void changxy(TextView ceshi1, TextView ceshi2, TextView ceshi3) {
//        chooseleft(ceshi1, ceshi2, ceshi3);
        chooseright(ceshi1, ceshi2, ceshi3);
    }
    private void chooseright(TextView ceshi1, TextView ceshi2, TextView ceshi3) {
        set0 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.rightup);
        switch (changeh){
            case 0:
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_left);
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_right);
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_down);
                animchangright(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
            case 1:
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_right);
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_down);
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_left);
                animchangright(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
            case 2:
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_left);
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_down);
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_right);
                animchangright(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
        }
    }

    private void chooseleft(TextView ceshi1, TextView ceshi2, TextView ceshi3) {
//        AnimatorSet an = new AnimatorSet();
        set0 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.leftup);
        switch (change){
            case 0:
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_down);
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_left);
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_right);
                animchangleft(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
            case 1:
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_down);
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_left);
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_right);
                animchangleft(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
            case 2:
                set2 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.right_down);
                set1 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.down_left);
                set3 = (AnimatorSet) AnimatorInflater.loadAnimator(DongHua2Activity.this, R.animator.left_right);
                animchangleft(set1, set2, set3, ceshi1, ceshi2, ceshi3);
                break;
        }
    }
    private void animchangright(final AnimatorSet set1, AnimatorSet set2, AnimatorSet set3, final TextView ceshi1, final TextView ceshi2, final TextView ceshi3) {
        set1.setTarget(ceshi1);
        set2.setTarget(ceshi2);
        set3.setTarget(ceshi3);
        set1.start();
        set2.start();
        set3.start();
        set1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(DongHua2Activity.this,"数字"+changeh,Toast.LENGTH_SHORT).show();
                if (changeh==2){
                    changeh = 0;
                }else {
                    changeh+=1;
                }
            }
        });
    }
    private void animchangleft(final AnimatorSet set1, AnimatorSet set2, AnimatorSet set3, final TextView ceshi1, final TextView ceshi2, final TextView ceshi3) {
        set1.setTarget(ceshi1);
        set2.setTarget(ceshi2);
        set3.setTarget(ceshi3);
        set1.start();
        set2.start();
        set3.start();
        set1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(DongHua2Activity.this,"数字"+change,Toast.LENGTH_SHORT).show();
                if (change==2){
                    change = 0;
                }else {
                    change+=1;
                }
            }
        });
    }
}
