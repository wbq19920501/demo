package com.wbq.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wbq.mvp.view.CircleMenuLayout;
import com.wbq.mvp.view.YuanView;

/**
 * Created by wbq501 on 2015-12-7 22:06.
 * demo
 */
public class YuanActivity extends Activity{
    private String[] mItemTexts = new String[] { "安全中心 ", "特色服务", "投资理财"};
    private int[] mItemImgs = new int[] { R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuan);
        CircleMenuLayout yuanquan = (CircleMenuLayout)findViewById(R.id.myyuan);
        yuanquan.setMenuItemIconsAndTexts(mItemImgs,mItemTexts);
    }
}
