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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myzidingyi);
        myshape = (MyShapeView) findViewById(R.id.myshape);
        myshape.setOnShapeListener(new MyShapeView.ShapeViewListener() {
            @Override
            public void onRightListener() {
                Toast.makeText(MyZiDingYi.this,"right",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBottomListener() {
                Toast.makeText(MyZiDingYi.this,"bottom",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftListener() {
                Toast.makeText(MyZiDingYi.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCenterListener() {
                Toast.makeText(MyZiDingYi.this,"center",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
