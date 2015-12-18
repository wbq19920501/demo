package com.wbq.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wbq.mvp.R;

/**
 * Created by wbq501 on 2015-12-17 16:46.
 * demo
 */
public class ThreeFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.three, container, false);//关联布局文件
        return rootView;
    }
}
