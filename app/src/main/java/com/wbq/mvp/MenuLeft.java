package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.wbq.mvp.adapter.ContentAdapter;
import com.wbq.mvp.adapter.ContentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbq501 on 2015-12-14 10:04.
 * demo
 */
public class MenuLeft extends Activity{
    DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuleft);
        drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
    }
}
