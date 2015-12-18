package com.wbq.mvp;

import android.animation.Animator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import at.markushi.ui.ActionView;
import at.markushi.ui.RevealColorView;
import at.markushi.ui.action.BackAction;
import at.markushi.ui.action.CloseAction;
import at.markushi.ui.action.DrawerAction;
import at.markushi.ui.action.PlusAction;

/**
 * Created by wbq501 on 2015-11-17 16:06.
 * demo
 */
public class OneActivity extends Activity{
    private Button btn_down,btn_open;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;
    private final int NOTIFICATION_BASE_NUMBER=110;
    private Notification.Builder builder = null;
    private Notification n = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(this,OneActivity.class);
        pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        btn_down = (Button) findViewById(R.id.btn_down);
        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) OneActivity.this.getSystemService(NOTIFICATION_SERVICE);
                Resources resources = OneActivity.this.getResources();
                builder = new Notification.Builder(OneActivity.this);
                builder.setContentIntent(pendingIntent).setSmallIcon(R.drawable.ic_launcher)//设置状态栏里面的图标（小图标)
                        .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher))//下拉下拉列表里面的图标
                        .setTicker("这是啥")//设置状态栏的显示的信息
                        .setWhen(System.currentTimeMillis())//设置时间发生时间
                        .setAutoCancel(false)//设置可以清除
                        .setContentTitle("这是下拉标题")//设置下拉列表里的标题
                        .setContentText("这是内容");//设置上下文内容
                n = builder.getNotification();//获取一个Notification
                n.defaults = Notification.DEFAULT_SOUND;//设置为默认的声音
                nm.notify(NOTIFICATION_BASE_NUMBER, n);//显示通知
            }
        });
        btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过包名获取要跳转的app，创建intent对象
                Intent intent2 = getPackageManager().getLaunchIntentForPackage("com.jokeep.portal");
                if (intent2!=null) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    ComponentName comp = new ComponentName("com.jokeep.portal", "com.jokeep.portal.activity.login.LoginActivity");
                    intent.setComponent(comp);
                    int launchFlags = Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED;
                    intent.setFlags(launchFlags);
                    intent.setAction("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putString("opentype", "1");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "赶紧下载安装这个APP吧", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button yuanquan = (Button) findViewById(R.id.yuanquan);
        yuanquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,YuanActivity.class);
                startActivity(intent);
            }
        });
        Button donghua1 = (Button) findViewById(R.id.donghua1);
        donghua1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,DongHua1Activity.class);
                startActivity(intent);
            }
        });
        Button donghua2 = (Button) findViewById(R.id.donghua2);
        donghua2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,DongHua2Activity.class);
                startActivity(intent);
            }
        });
        final Button donghua3 = (Button) findViewById(R.id.donghua3);
        donghua3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionView actionView = new ActionView(OneActivity.this);
                actionView.setAction(new BackAction(),ActionView.ROTATE_COUNTER_CLOCKWISE);
                Intent intent = new Intent(OneActivity.this,DongHua3Activity.class);
                startActivity(intent);
            }
        });
        Button chouti = (Button) findViewById(R.id.chouti);
        chouti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,MenuLeft.class);
                startActivity(intent);
            }
        });
        Button kuosan = (Button) findViewById(R.id.kuosan);
        kuosan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,KuoSan.class);
                startActivity(intent);
            }
        });
        Button myview = (Button) findViewById(R.id.myview);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,MyViewActivity.class);
                startActivity(intent);
            }
        });
        Button item_btn = (Button) findViewById(R.id.item_btn);
        item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,HuanBaoActivty.class);
                startActivity(intent);
            }
        });
        Button progressBar1 = (Button) findViewById(R.id.progressBar1);
        progressBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this,MyProgressBarActivity.class);
                startActivity(intent);
            }
        });
    }
}
