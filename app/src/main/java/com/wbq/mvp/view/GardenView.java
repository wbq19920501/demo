package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by wbq501 on 2015-11-19 14:36.
 * demo
 */
public class GardenView extends ViewGroup{
    private Context context;
    private LayoutInflater inflater;
    /**
     * isDrawFinished 是否绘制完成，如果绘制完成后，将不再重绘
     */
    private boolean isDrawFinished = false;
    /**
     * value 设置预警项目的值
     */
    private float value = 0;
    /**
     * isloadfinished 判断是否加载完成
     */
    private boolean isloadfinished = false;
    // 当前用户名
    private String username = "张三";
    /**
     * 设置项目正常个数
     */
    private int normalValue;
    private boolean islongRotate = false;
    private int length = 0;
    /**
     * 显示预警项目在总共工程中占的比例
     */
    private int RATIO = 0;
    private int i = 0;
    /**
     * 获取屏幕分辨率大小
     */
    private DisplayMetrics dm;
    /**
     * 画笔对象，在使用过程中，只实例化了一个对象，其他地方使用时，调用了reset();
     */
    private Paint p;
    /**
     * 宽度的一半
     */
    private int moietyWidth;
    /**
     * 获取屏幕高度的四分之一
     */
    private int mQuarterHeight;
    public GardenView(Context context) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public GardenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public GardenView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    /**
     * setIsFinished 加载完成，停止加载
     */
    public void setIsFinished(Boolean boo){
        this.isDrawFinished = boo;
    }

    /**
     * 设置预警项目值
     * @param value
     */
    public void setValue(float value){
        this.value = value;
    }

    /**
     * 设置是否加载完成
     * @param boo
     */
    public void setLoadFinished(boolean boo){
        this.isloadfinished = boo;
    }

    /**
     * 设置用户名字
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * 设置正常项目个数
     * @param normalValue
     */
    public void setNormalValue(int normalValue) {
        this.normalValue = normalValue;
    }

    /**
     * ①当数据加载完成时，isloadfinished 为true ②初始化其它数据
     * @param boo
     */
    public void setIsloadfinished(boolean boo){
        isloadfinished = boo;
        islongRotate = false;
        length = 0;
        i = 0;
    }
    private int execount = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        // 初始化全局使用的对象
        init();
        // 如果正常项目个数为0，默认给值为1，饭后，赋回原值；
        if (normalValue == 0) {
            normalValue = 1;
            // 设置白色全占到的百分比
            RATIO = (int) ((value / (normalValue + value)) * 90);
            normalValue = 0;
        } else {
            RATIO = (int) ((value / (normalValue + value)) * 90);
        }
        if (RATIO == 0) {
            RATIO = 1;
        }
        drawUNW(canvas);
        super.onDraw(canvas);
    }

    private void drawUNW(Canvas canvas) {
        p.reset();
        p.setAntiAlias(true);
    }

    /**
     * 初始化基本参数对象
     */
    private void init() {
        // 初始化DisplayMetrics对象
        dm = getResources().getDisplayMetrics();
        // 初始化画笔
        p = new Paint();
        // 获取屏幕的宽度的一半
        moietyWidth = dm.widthPixels / 2;
        // 获取屏幕高度的四分之一
        mQuarterHeight = dm.heightPixels / 4;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
