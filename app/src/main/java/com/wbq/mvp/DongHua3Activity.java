package com.wbq.mvp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
/**
 * Created by wbq501 on 2015-12-11 16:37.
 * demo
 */
public class DongHua3Activity extends FragmentActivity {
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
    ViewPager pager;
    private int pagerchange=1;
    /**
     * changpagerimg ==0 不切换 1右切换 2左切换
     */
    private int changpagerimg = 0;
    private int viewpageleft = 1;
    private int viewpageright = 1;
    private boolean btnchange = false;
    private boolean viewpagechang = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donghua2);
        ceshi1 = (TextView) findViewById(R.id.ceshi1);
        ceshi2 = (TextView) findViewById(R.id.ceshi2);
        ceshi3 = (TextView) findViewById(R.id.ceshi3);
        henxian = (TextView) findViewById(R.id.henxian);
        imganim = (ImageView) findViewById(R.id.imganim);
        pager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(pager);
        ceshi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                btnchange = true;
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
                btnchange = false;
            }
        });
        ceshi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                btnchange = true;
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
                btnchange = false;
            }
        });
        ceshi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseanimright(changright);
//                clickanimright();
                btnchange = true;
                imganimleft();
                chooseanimleft(changleft);
                clickanimleft();
                btnchange = false;
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment(), "Tab 1");
        adapter.addFrag(new TabFragment(), "Tab 2");
        adapter.addFrag(new TabFragment(), "Tab 3");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (viewpagechang) {
                    int changnum = pagerchange - position;
                    switch (changnum) {
                        case 0:
                            changpagerimg = 0;
                            break;
                        case 1:
                            changpagerimg = 1;
                            break;
                        case -1:
                            changpagerimg = 2;
                            break;
                    }
                    pagerchange = position;
                    switch (position) {
                        case 0:
                            viewpageimgchang();
                            break;
                        case 1:
                            viewpageimgchang();
                            break;
                        case 2:
                            viewpageimgchang();
                            break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void viewpageimgchang() {
        switch (changpagerimg){
            case 0:
                break;
            case 1://viewpage向右
                imganimright();
                chooseanimright(viewpageright);
                clickanimright();
                viewpageleft +=2;
                if (viewpageright == 3){
                    viewpageright = 1;
                    viewpageleft = 1;
                    changright = 3;
                }else if (viewpageright == 1){
                    viewpageleft = 3;
                    viewpageright = 1;
                }
                break;
            case 2://viewpage向左
                imganimleft();
                chooseanimleft(viewpageleft);
                clickanimleft();
                viewpageright +=2;
                if (viewpageleft == 3){
                    viewpageright = 1;
                    viewpageleft = 1;
                    changleft = 3;
                }else if (viewpageleft == 1){
                    viewpageright = 3;
                    viewpageleft = 1;
                }
                break;
        }
    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
        private final List<String> mFragmentTitleList = new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /**
     * 图片左，横线右
     */
    private void imganimleft() {
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
        ObjectAnimator oaxian = ObjectAnimator.ofFloat(henxian,"X",henxian.getLeft()-100,henxian.getLeft());
        AnimatorSet asxian = new AnimatorSet();
        asxian.play(oaxian);
        asxian.setDuration(800);
        asxian.start();
    }

    /**
     * 图片右，横线左
     */
    private void imganimright() {
        int x1 = imganim.getLeft();
        int imgw = imganim.getRight()-x1;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int x2 = dm.widthPixels;
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imganim,"X",x1,x2);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imganim,"X",-imgw,x1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator2).after(objectAnimator1);
        animatorSet.setDuration(350);
        animatorSet.start();
        ObjectAnimator oaxian = ObjectAnimator.ofFloat(henxian,"X",henxian.getLeft()+100,henxian.getLeft());
        AnimatorSet asxian = new AnimatorSet();
        asxian.play(oaxian);
        asxian.setDuration(800);
        asxian.start();
    }

    /**
     * 顺时针动画改变
     * @param i
     */
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

    /**
     * changxy 三个按钮坐标
     */
    private void changxy() {
        xleft = ceshi1.getLeft();
        x = ceshi2.getLeft();
        xright = ceshi3.getLeft();
        y = ceshi1.getTop();
        downy = ceshi2.getTop();
    }

    /**
     * 逆时针动画的改变
     * @param i
     */
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

    /**
     * clickanimleft 顺时针动画
     */
    private void clickanimleft() {
        if (btnchange){
            viewpagechang = false;
            switch (changleft){
                case 1:
                    pager.setCurrentItem(2);
                    viewpageright = 3;
                    break;
                case 2:
                    pager.setCurrentItem(0);
                    viewpageleft = 1;
                    viewpageright = 1;
                    break;
                case 3:
                    pager.setCurrentItem(1);
                    viewpageleft = 3;
                    break;
            }
            viewpagechang = true;
        }
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

    /**
     * clickanimright 逆时针动画
     */
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
