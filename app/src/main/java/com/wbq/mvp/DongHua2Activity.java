package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.wbq.mvp.view.MyDialog;


/**
 * Created by wbq501 on 2015-12-10 17:30.
 * demo
 */
public class DongHua2Activity extends Activity{
    int change = 0;
    int changeh = 0;
    AnimatorSet set3,set2,set1,set0;
    TextView dian1,dian2,dian3;
    ObjectAnimator oadian1,oadian2,oadian3;
    AnimatorSet andian1;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua1);
        final TextView ceshi1 = (TextView) findViewById(R.id.ceshi1);
        final TextView ceshi2 = (TextView) findViewById(R.id.ceshi2);
        final TextView ceshi3 = (TextView) findViewById(R.id.ceshi3);
        dian1 = (TextView) findViewById(R.id.dian1);
        dian2 = (TextView) findViewById(R.id.dian2);
        dian3 = (TextView) findViewById(R.id.dian3);
        thread = new Thread(){
            @Override
            public void run() {
                try {
                    for (;;){
                        Thread.sleep(500);
                        Message msgMessage=new Message();
                        msgMessage.arg1=1;
                        handler.sendMessage(msgMessage);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();

//        oadian1.setRepeatCount(-1);
//        oadian2.setRepeatCount(-1);
//        oadian3.setRepeatCount(-1);
//        andian1.play(oadian2).before(andian1);
//        andian1.play(oadian3).after(oadian2);
//        andian1.playSequentially(oadian1, oadian2, oadian3);
//        andian1.start();
//        andian1.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                super.onAnimationRepeat(animation);
//            }
//        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1)
            {
                andian1 = new AnimatorSet();
                oadian1 = ObjectAnimator.ofFloat(dian1, "alpha", 0f, 1f);
                oadian2 = ObjectAnimator.ofFloat(dian2, "alpha", 0f, 1f);
                oadian3 = ObjectAnimator.ofFloat(dian3, "alpha", 0f, 1f);
                andian1.playSequentially(oadian1, oadian2, oadian3);
                andian1.start();
            }
        }
    };
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int changx = Integer.valueOf((int) event.getX());
//        handler.getLooper().quit();
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
