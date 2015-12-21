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

import com.wbq.mvp.R;

/**
 * Created by wbq501 on 2015-12-17 16:46.
 * demo
 */
public class ThreeFragment extends Fragment{
    View rootView;
    Thread thread;
    LinearLayout loadingimg,fragment_three;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.three, container, false);//关联布局文件
        init();
        return rootView;
    }
    private void init() {
        loadingimg = (LinearLayout) rootView.findViewById(R.id.three_loading);
        fragment_three = (LinearLayout) rootView.findViewById(R.id.fragment_three);
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
        fragment_three.setVisibility(View.VISIBLE);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        AnimatorSet anim = new AnimatorSet();
        ObjectAnimator objectanim = ObjectAnimator.ofFloat(fragment_three,"Y",dm.heightPixels,0);
        anim.play(objectanim);
        anim.setDuration(500);
        anim.start();
    }
}
