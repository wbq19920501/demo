package com.wbq.mvp.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wbq.mvp.HuanBaoActivty;
import com.wbq.mvp.R;
import com.wbq.mvp.adapter.TwoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbq501 on 2015-12-17 16:46.
 * demo
 */
public class TwoFragment extends Fragment{
    View rootView;
    Thread thread;
    LinearLayout loadingimg,fragment_two;
    ListView twolist;
    List<String> msg = new ArrayList<String>();
    TwoAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.two, container, false);//关联布局文件
        init();
        return rootView;
    }

    private void init() {
        loadingimg = (LinearLayout) rootView.findViewById(R.id.two_loading);
        fragment_two = (LinearLayout) rootView.findViewById(R.id.fragment_two);
        twolist = (ListView) rootView.findViewById(R.id.twolist);
        List<String> msg = new ArrayList<String>();
        for (int i=1;i<=100;i++){
            msg.add("测试"+i);
        }
        adapter = new TwoAdapter(getContext(),msg);
        twolist.setAdapter(adapter);
        thread = new Thread(){
            @Override
            public void run() {
                try {
                    thread.sleep(2000);
                    Message msgMessage=new Message();
                    msgMessage.arg1=1;
                    handler.sendMessage(msgMessage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1)
            {
                loadmsg();
            }
        }
    };
    private void loadmsg() {
        loadingimg.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
        fragment_two.setVisibility(View.VISIBLE);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        AnimatorSet anim = new AnimatorSet();
        ObjectAnimator objectanim = ObjectAnimator.ofFloat(fragment_two,"Y",dm.heightPixels,0);
        anim.play(objectanim);
        anim.setDuration(500);
        anim.start();
        HuanBaoActivty huanbao = (HuanBaoActivty) getActivity();
        huanbao.upanim();
    }
}
