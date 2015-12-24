package com.wbq.mvp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wbq.mvp.view.MyShapeView;
import com.wbq.mvp.view.TwoRoundView;

/**
 * Created by wbq501 on 2015-12-23 16:31.
 * demo
 */
public class MyZiDingYi extends Activity{
    MyShapeView myshape;
    TwoRoundView twoview;
    String msg0 = "日常办公";
    String msg1 = "业务系统";
    String msg2 = "个人应用";
    int progress = 0;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myzidingyi);
        myshape = (MyShapeView) findViewById(R.id.myshape);
        twoview = (TwoRoundView) findViewById(R.id.twoview);
        Button ceshi= (Button) findViewById(R.id.ceshi);
        ceshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (progress < 100) {
                                Thread.sleep(100);
                                progress += 1;
                                Message msgMessage = new Message();
                                msgMessage.arg1 = 1;
                                handler.sendMessage(msgMessage);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        super.run();
                    }
                };
                thread.start();
            }
        });
        myshape.setMsg1(msg1);
        myshape.setMsg0(msg0);
        myshape.setMsg2(msg2);
        myshape.setOnShapeListener(new MyShapeView.ShapeViewListener() {
            @Override
            public void onRightListener() {
                myshape.setMsg0(msg1);
                myshape.setMsg1(msg2);
                myshape.setMsg2(msg0);
                Toast.makeText(MyZiDingYi.this, "right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBottomListener() {
                Toast.makeText(MyZiDingYi.this, "bottom", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftListener() {
                myshape.setMsg0(msg2);
                myshape.setMsg1(msg0);
                myshape.setMsg2(msg1);
                Toast.makeText(MyZiDingYi.this, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCenterListener() {
                Toast.makeText(MyZiDingYi.this, "center", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1)
            {
                twoview.setMprogress(progress);
            }
        }
    };
}
