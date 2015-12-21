package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wbq.mvp.adapter.MyFragmentPagerAdapter;
import com.wbq.mvp.fragment.OneFragment;
import com.wbq.mvp.fragment.ThreeFragment;
import com.wbq.mvp.fragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by wbq501 on 2015-12-16 16:51.
 * demo
 */
public class HuanBaoActivty extends FragmentActivity implements View.OnTouchListener,GestureDetector.OnGestureListener {
    LinearLayout textitem;
    TextView text0,text1,text2,henxian;
    ImageView imganim;
    RelativeLayout item0,item1,item2;

    int item0left,item1left,item2left;
    int henxianleft,imganimleft;
    int item0right,item1right,item2right;
    int henxianright,imganimright,imganimtop;
    int item0top,item0buttom,item1top,item1buttom,item2top,item2buttom;
    int changy = 30;
    int pingmuw;

    private static final int FLING_MIN_DISTANCE = 30;
    private static final int FLING_MIN_VELOCITY = 0;
    GestureDetector mGestureDetector;

    int changanim = 1;
    ViewPager pager;
    int changpager = 1;
    private boolean huadongchangpager = true;
    private ArrayList<Fragment> fragmentList;
    LinearLayout donghua1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huanbao);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        pingmuw = dm.widthPixels;
        initview();
        menudrawlayout();
    }
    public void upanim(){
        getzuobiao();
        donghua1 = (LinearLayout) findViewById(R.id.donghua1);
        AnimatorSet anim = new AnimatorSet();
        int upchanglayout = -(donghua1.getBottom()-donghua1.getTop());
//        ObjectAnimator item0obanimx = ObjectAnimator.ofFloat(item0,"X",item0left,item0left-50);
        ObjectAnimator item0obanimy = ObjectAnimator.ofFloat(item0,"Y",item0top,imganimtop);
        ObjectAnimator item1obanimy = ObjectAnimator.ofFloat(item1,"Y",item1top,imganimtop);
//        ObjectAnimator item2obanimx = ObjectAnimator.ofFloat(item2,"X",item2right,item2right+50);
        ObjectAnimator item2obanimy = ObjectAnimator.ofFloat(item2,"Y",item0top,imganimtop);
        ObjectAnimator imgobanimy = ObjectAnimator.ofFloat(donghua1,"Y",donghua1.getTop(),upchanglayout);
        ObjectAnimator imgobanimalpha = ObjectAnimator.ofFloat(donghua1,"alpha",1f,0f);
        anim.playTogether(item0obanimy,item1obanimy,item2obanimy,imgobanimy,imgobanimalpha);
        anim.setDuration(500);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                donghua1.setVisibility(View.GONE);
                super.onAnimationEnd(animation);
            }
        });
    }
    private void menudrawlayout() {
        final DrawerLayout drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        TextView leftmenubtn = (TextView) findViewById(R.id.leftmenubtn);
        TextView rightmenubtn = (TextView) findViewById(R.id.rightmenubtn);
        leftmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(Gravity.LEFT);
            }
        });
        TextView ceshibtn = (TextView) drawerlayout.findViewById(R.id.ceshibtn);
        ceshibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HuanBaoActivty.this, "左边的点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        getzuobiao();
        if (e1.getX()-e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling left
            Toast.makeText(this, "向左手势"+changanim, Toast.LENGTH_SHORT).show();
            imgleftxianright(changanim);
            animtextleft(changanim);
            changanim -=1;
            if (changanim == -1)
                changanim = 2;
            changpager(changanim);
        } else if (e2.getX()-e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling right
            Toast.makeText(this, "向右手势"+changanim, Toast.LENGTH_SHORT).show();
            imgrightxianleft(changanim);
            animtextright(changanim);
            changanim +=1;
            if (changanim == 3)
                changanim = 0;
            changpager(changanim);
        }
        return false;
    }

    private void changpager(int i) {
        huadongchangpager = false;
        switch (changanim){
            case 0:
                i = 2;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 0;
                break;
        }
        changpager = i;
        pager.setCurrentItem(i);
        huadongchangpager = true;
    }

    private void animtextright(int i) {
        final AnimatorSet animtext0 = new AnimatorSet();
        final AnimatorSet animtext1 = new AnimatorSet();
        final AnimatorSet animtext2 = new AnimatorSet();
        ObjectAnimator text0x = null;
        ObjectAnimator text0y = null;
        ObjectAnimator text1x = null;
        ObjectAnimator text1y = null;
        ObjectAnimator text2x = null;
        ObjectAnimator text2y = null;
        switch (i){
            case 2:
                text0x = ObjectAnimator.ofFloat(item2,"X",item0left,item1left);
                text0y = ObjectAnimator.ofFloat(item2,"Y",item0top,changy);
                text1x = ObjectAnimator.ofFloat(item0,"X",item1left,item2left);
                text1y = ObjectAnimator.ofFloat(item0,"Y",item1top,item2top);
                text2x = ObjectAnimator.ofFloat(item1,"X",item2left,item2left);
                text2y = ObjectAnimator.ofFloat(item1,"Y",item2top,-changy);
                animtext0.playTogether(text2x, text2y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item1, "X", item0left, item0left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item1, "Y", -changy, item0top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text0x,text0y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
            case 1:
                text0x = ObjectAnimator.ofFloat(item0,"X",item0left,item1left);
                text0y = ObjectAnimator.ofFloat(item0,"Y",item0top,changy);
                text1x = ObjectAnimator.ofFloat(item1,"X",item1left,item2left);
                text1y = ObjectAnimator.ofFloat(item1,"Y",item1top,item2top);
                text2x = ObjectAnimator.ofFloat(item2,"X",item2left,item2left);
                text2y = ObjectAnimator.ofFloat(item2,"Y",item2top,-changy);
                animtext0.playTogether(text2x, text2y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item2, "X", item0left, item0left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item2, "Y", -changy, item0top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text0x,text0y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
            case 0:
                text0x = ObjectAnimator.ofFloat(item1,"X",item0left,item1left);
                text0y = ObjectAnimator.ofFloat(item1,"Y",item0top,changy);
                text1x = ObjectAnimator.ofFloat(item2,"X",item1left,item2left);
                text1y = ObjectAnimator.ofFloat(item2,"Y",item1top,item2top);
                text2x = ObjectAnimator.ofFloat(item0,"X",item2left,item2left);
                text2y = ObjectAnimator.ofFloat(item0,"Y",item2top,-changy);
                animtext0.playTogether(text2x, text2y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item0, "X", item0left, item0left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item0, "Y", -changy, item0top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text0x,text0y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
        }
    }

    private void imgrightxianleft(int i) {
        switch (i){
            case 0:
                imganimright(i);
                break;
            case 1:
                imganimright(i);
                break;
            case 2:
                imganimright(i);
                break;
        }
        ObjectAnimator oaxian = ObjectAnimator.ofFloat(henxian,"X",henxian.getLeft()+100,henxian.getLeft());
        AnimatorSet asxian = new AnimatorSet();
        asxian.play(oaxian);
        asxian.setDuration(500);
        asxian.start();
    }

    private void imganimright(final int i) {
        ObjectAnimator imgright1_2 = ObjectAnimator.ofFloat(imganim,"X",imganimright,pingmuw+(imganimright-imganimleft));
        ObjectAnimator imgout = ObjectAnimator.ofFloat(imganim,"alpha",1f,0f);
        AnimatorSet imganim1_2 = new AnimatorSet();
        imganim1_2.playTogether(imgright1_2, imgout);
        imganim1_2.setDuration(300);
        imganim1_2.start();
        imganim1_2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator imgleft0_1 = null;
                ObjectAnimator imgint = null;
                switch (i){
                    case 0:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text_0));
                        break;
                    case 1:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text1));
                        break;
                    case 2:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text_1));
                        break;
                }
                imgleft0_1 = ObjectAnimator.ofFloat(imganim,"X",-(imganimright-imganimleft),imganimleft);
                imgint = ObjectAnimator.ofFloat(imganim,"alpha",0f,1f);
                AnimatorSet imganim0_1 = new AnimatorSet();
                imganim0_1.playTogether(imgleft0_1, imgint);
                imganim0_1.setDuration(300);
                imganim0_1.start();
                super.onAnimationEnd(animation);
            }
        });
    }

    private void getzuobiao() {
        item0left = item0.getLeft();
        item1left = item1.getLeft();
        item2left = item2.getLeft();
        henxianleft = henxian.getLeft();
        imganimleft = imganim.getLeft();
        item0right = item0.getRight();
        item1right = item1.getRight();
        item2right = item2.getRight();
        henxianright = henxian.getRight();
        imganimright = imganim.getRight();
        imganimtop = imganim.getTop();
        item0top = item0.getTop();
        item0buttom = item0.getBottom();
        item1top = item1.getTop();
        item1buttom = item1.getBottom();
        item2top = item2.getTop();
        item2buttom = item2.getBottom();
    }

    private void imgleftxianright(int i) {
        switch (i){
            case 0:
                imganimleft(i);
                break;
            case 1:
                imganimleft(i);
                break;
            case 2:
                imganimleft(i);
                break;
        }
        ObjectAnimator oaxian = ObjectAnimator.ofFloat(henxian,"X",henxian.getLeft()-100,henxian.getLeft());
        AnimatorSet asxian = new AnimatorSet();
        asxian.play(oaxian);
        asxian.setDuration(500);
        asxian.start();
    }

    private void imganimleft(final int i) {
        ObjectAnimator imgleft1_0 = ObjectAnimator.ofFloat(imganim,"X",imganimleft,-(imganimright-imganimleft));
        ObjectAnimator imgout = ObjectAnimator.ofFloat(imganim,"alpha",1f,0f);
        AnimatorSet imganim1_0 = new AnimatorSet();
        imganim1_0.playTogether(imgleft1_0, imgout);
        imganim1_0.setDuration(300);
        imganim1_0.start();
        imganim1_0.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator imgleft2_1 = null;
                ObjectAnimator imgint = null;
                switch (i){
                    case 0:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text1));
                        break;
                    case 1:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text_1));
                        break;
                    case 2:
                        imganim.setImageDrawable(getResources().getDrawable(R.drawable.text_0));
                        break;
                }
                imgleft2_1 = ObjectAnimator.ofFloat(imganim,"X",pingmuw,imganimleft);
                imgint = ObjectAnimator.ofFloat(imganim,"alpha",0f,1f);
                AnimatorSet imganim2_1 = new AnimatorSet();
                imganim2_1.playTogether(imgleft2_1, imgint);
                imganim2_1.setDuration(300);
                imganim2_1.start();
                super.onAnimationEnd(animation);
            }
        });
    }

    private void animtextleft(int i) {
        final AnimatorSet animtext0 = new AnimatorSet();
        final AnimatorSet animtext1 = new AnimatorSet();
        final AnimatorSet animtext2 = new AnimatorSet();
        ObjectAnimator text0x = null;
        ObjectAnimator text0y = null;
        ObjectAnimator text1x = null;
        ObjectAnimator text1y = null;
        ObjectAnimator text2x = null;
        ObjectAnimator text2y = null;
        switch (i){
            case 0:
                text0x = ObjectAnimator.ofFloat(item1,"X",item0left,item0left);
                text0y = ObjectAnimator.ofFloat(item1,"Y",item0top,-changy);
                text1x = ObjectAnimator.ofFloat(item2,"X",item1left,item0left);
                text1y = ObjectAnimator.ofFloat(item2,"Y",item1top,item0top);
                text2x = ObjectAnimator.ofFloat(item0,"X",item2left,item1left);
                text2y = ObjectAnimator.ofFloat(item0,"Y",item2top,item1top);
                animtext0.playTogether(text0x, text0y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item1, "X", item2left, item2left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item1, "Y", -changy, item2top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text2x,text2y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
            case 1:
                text0x = ObjectAnimator.ofFloat(item0,"X",item0left,item0left);
                text0y = ObjectAnimator.ofFloat(item0,"Y",item0top,-changy);
                text1x = ObjectAnimator.ofFloat(item1,"X",item1left,item0left);
                text1y = ObjectAnimator.ofFloat(item1,"Y",item1top,item0top);
                text2x = ObjectAnimator.ofFloat(item2,"X",item2left,item1left);
                text2y = ObjectAnimator.ofFloat(item2,"Y",item2top,item1top);
                animtext0.playTogether(text0x, text0y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item0, "X", item2left, item2left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item0, "Y", -changy, item2top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text2x,text2y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
            case 2:
                text0x = ObjectAnimator.ofFloat(item2,"X",item0left,item0left);
                text0y = ObjectAnimator.ofFloat(item2,"Y",item0top,-changy);
                text1x = ObjectAnimator.ofFloat(item0,"X",item1left,item0left);
                text1y = ObjectAnimator.ofFloat(item0,"Y",item1top,item0top);
                text2x = ObjectAnimator.ofFloat(item1,"X",item2left,item1left);
                text2y = ObjectAnimator.ofFloat(item1,"Y",item2top,item1top);
                animtext0.playTogether(text0x, text0y);
                animtext0.setDuration(300);
                animtext0.start();
                animtext0.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator textcopyx = ObjectAnimator.ofFloat(item2, "X", item2left, item2left);
                        ObjectAnimator textcopyy = ObjectAnimator.ofFloat(item2, "Y", -changy, item2top);
                        AnimatorSet animcopy = new AnimatorSet();
                        animcopy.playTogether(textcopyx, textcopyy);
                        animcopy.setDuration(300);
                        animcopy.start();
                    }
                });
                animtext1.playTogether(text1x, text1y);
                animtext1.setDuration(600);
                animtext1.start();
                animtext2.playTogether(text2x,text2y);
                animtext2.setDuration(600);
                animtext2.start();
                break;
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    @Override
    public void onLongPress(MotionEvent e) {
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
    private void initview() {
        mGestureDetector = new GestureDetector(this);
        textitem = (LinearLayout) findViewById(R.id.textitem);
        textitem.setOnTouchListener(this);
        textitem.setLongClickable(true);
        text0 = (TextView) findViewById(R.id.text0);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        henxian = (TextView) findViewById(R.id.henxian);
        imganim = (ImageView) findViewById(R.id.imganim);
        item0 = (RelativeLayout) findViewById(R.id.item0);
        item1 = (RelativeLayout) findViewById(R.id.item1);
        item2 = (RelativeLayout) findViewById(R.id.item2);
        pager = (ViewPager) findViewById(R.id.pager);
        fragmentList = new ArrayList<Fragment>();
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        fragmentList.add(threeFragment);
        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        pager.setCurrentItem(1);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (huadongchangpager){
                    Toast.makeText(HuanBaoActivty.this,"position"+position,Toast.LENGTH_SHORT).show();
                    getzuobiao();
                    switch (position){
                        case 2:
                            imgleftxianright(1);
                            animtextleft(1);
                            changanim -=1;
                            break;
                        case 0:
                            imgrightxianleft(1);
                            animtextright(1);
                            changanim +=1;
                            break;
                        case 1:
                            int i = changpager - position;
                            switch (i){
                                case 0:
                                    break;
                                case 1:
                                    imgrightxianleft(changanim);
                                    animtextright(changanim);
                                    changanim +=1;
                                    if (changanim == 3)
                                        changanim = 0;
                                    break;
                                case -1:
                                    imgleftxianright(changanim);
                                    animtextleft(changanim);
                                    changanim -=1;
                                    if (changanim == -1)
                                        changanim = 2;
                                    break;
                            }
                            break;
                    }
                    changpager = position;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
