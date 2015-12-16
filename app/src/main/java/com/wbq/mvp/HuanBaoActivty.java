package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wbq501 on 2015-12-16 16:51.
 * demo
 */
public class HuanBaoActivty extends Activity{
    TextView text0,text1,text2,henxian;
    ImageView imganim;
    RelativeLayout item0,item1,item2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huanbao);
        text0 = (TextView) findViewById(R.id.text0);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        henxian = (TextView) findViewById(R.id.henxian);
        imganim = (ImageView) findViewById(R.id.imganim);
        item0 = (RelativeLayout) findViewById(R.id.item0);
        item1 = (RelativeLayout) findViewById(R.id.item1);
        item2 = (RelativeLayout) findViewById(R.id.item2);
    }
}
