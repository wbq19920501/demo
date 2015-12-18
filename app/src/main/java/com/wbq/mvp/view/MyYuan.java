package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wbq501 on 2015-12-18 16:31.
 * demo
 */
public class MyYuan extends View{
    /**
     * RoundColor 定义圆圈的颜色
     */
    private static final int RoundColor = Color.RED;
    /**
     * mPaint 圆圈的画笔
     */
    private Paint mPaint;
    /**
     * mTextPaint 字体画笔
     */
    private Paint mTextPaint;
    /**
     * maxCount 最大污染值
     */
    private float maxCount;
    /**
     * currentCount 实际污染值
     */
    private float currentCount;
    /**
     * score 污染参数值
     */
    private int score;
    /**
     * msg 污染信息
     */
    private String msg;

    private int mWidth, mHeight;

    public MyYuan(Context context) {
        this(context, null);
    }
    public MyYuan(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public MyYuan(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        mPaint = new Paint();
        mTextPaint = new Paint();
    }

    /**
     * 画圆圈
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();RectF rectBlackBg = new RectF(20, 20, mWidth - 20, mHeight - 20);
        canvas.drawArc(rectBlackBg, 145, 250, false, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawText(score + "分", mWidth / 2, mHeight / 2, mTextPaint);
        canvas.drawText("-轻度污染-", mWidth / 2, mHeight / 2 + 50,mTextPaint);
        mTextPaint.setTextSize(40);
    }
    private void initPaint() {
        mPaint.setAntiAlias(true);//消除锯齿
        mPaint.setStrokeWidth(10);//设置圆环的宽度
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        mPaint.setStrokeCap(Paint.Cap.ROUND);//画笔笔刷类型
        mPaint.setColor(Color.YELLOW);//设置圆环的颜色

        mTextPaint.setAntiAlias(true);//消除锯齿
        mTextPaint.setStrokeWidth((float) 3.0);//设置圆环的宽度
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.RED);
    }
    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY
                || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST
                || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = dipToPx(15);
        } else {
            mHeight = heightSpecSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    public float getMaxCount() {
        return maxCount;
    }

    /**
     * 设置最大的进度值
     * @param maxCount
     */
    public void setMaxCount(float maxCount) {
        this.maxCount = maxCount;
    }

    public float getCurrentCount() {
        return currentCount;
    }

    /**
     * 设置当前的进度值
     * @param currentCount
     */
    public void setCurrentCount(float currentCount) {
        this.currentCount = currentCount > maxCount ? maxCount : currentCount;
        invalidate();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        this.msg = "-轻度污染-";
        invalidate();
    }
}
