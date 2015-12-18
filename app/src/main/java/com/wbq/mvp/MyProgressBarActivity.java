package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wbq.mvp.view.MyYuan;
import com.wbq.mvp.view.ProgressView;
import com.wbq.mvp.view.RoundProgressBar;

import java.util.Random;

/**
 * Created by wbq501 on 2015-12-18 10:47.
 * demo
 */
public class MyProgressBarActivity extends Activity{
    private RoundProgressBar mRoundProgressBar1, mRoundProgressBar2 ,mRoundProgressBar3, mRoundProgressBar4, mRoundProgressBar5;
    private int progress = 0;

    private ProgressView mProgressView;
    private Button test;
    private int value;
    private Random random = new Random(System.currentTimeMillis());
    private MyYuan myviewyuan;
    private int num=107;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        mRoundProgressBar1 = (RoundProgressBar) findViewById(R.id.roundProgressBar1);
        mRoundProgressBar2 = (RoundProgressBar) findViewById(R.id.roundProgressBar2);
        mRoundProgressBar3 = (RoundProgressBar) findViewById(R.id.roundProgressBar3);
        mRoundProgressBar4 = (RoundProgressBar) findViewById(R.id.roundProgressBar4);
        mRoundProgressBar5 = (RoundProgressBar) findViewById(R.id.roundProgressBar5);

        ((Button)findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress <= 100) {
                            progress += 3;
                            System.out.println(progress);
                            mRoundProgressBar1.setProgress(progress);
                            mRoundProgressBar2.setProgress(progress);
                            mRoundProgressBar3.setProgress(progress);
                            mRoundProgressBar4.setProgress(progress);
                            mRoundProgressBar5.setProgress(progress);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        mProgressView = (ProgressView)findViewById(R.id.my_progress);
        test = (Button)findViewById(R.id.btn1);
        mProgressView.setMaxCount(100.0f);
        value = random.nextInt(100)+1;
        mProgressView.setCurrentCount(value);
        mProgressView.setScore(value);
        test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                value = 100;
//                value = random.nextInt(100) + 1;
                mProgressView.setCurrentCount(value);
                mProgressView.setScore(value);
            }
        });
        myviewyuan = (MyYuan) findViewById(R.id.myviewyuan);
        myviewyuan.setMaxCount(200);
        ((Button)findViewById(R.id.btn3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 107;
                myviewyuan.setCurrentCount(num);
                myviewyuan.setScore(num);
            }
        });
    }
}
