package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.wbq.mvp.view.MyShapeView;

/**
 * Created by wbq501 on 2015-12-23 16:31.
 * demo
 */
public class MyZiDingYi extends Activity{
    MyShapeView myshape;
    String msg0 = "日常办公";
    String msg1 = "业务系统";
    String msg2 = "个人应用";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myzidingyi);
        myshape = (MyShapeView) findViewById(R.id.myshape);
        myshape.setMsg1(msg1);
        myshape.setMsg0(msg0);
        myshape.setMsg2(msg2);
        myshape.setOnShapeListener(new MyShapeView.ShapeViewListener() {
            @Override
            public void onRightListener() {
                myshape.setMsg0(msg1);
                myshape.setMsg1(msg2);
                myshape.setMsg2(msg0);
                Toast.makeText(MyZiDingYi.this,"right",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBottomListener() {
                Toast.makeText(MyZiDingYi.this,"bottom",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftListener() {
                myshape.setMsg0(msg2);
                myshape.setMsg1(msg0);
                myshape.setMsg2(msg1);
                Toast.makeText(MyZiDingYi.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCenterListener() {
                Toast.makeText(MyZiDingYi.this,"center",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
