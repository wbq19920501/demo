package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wbq501 on 2015-12-24 11:32.
 * demo
 */
public class TwoRoundView extends View{
    private Paint bPaint;
    private Paint sPaint;
    private Paint tPaint;
    private int progress = 100;
    private int mprogress = 0;
    private int width,height;

    public int getMprogress() {
        return mprogress;
    }

    public void setMprogress(int mprogress) {
        this.mprogress = mprogress;
        invalidate();
    }

    public TwoRoundView(Context context) {
        this(context,null);
    }

    public TwoRoundView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoRoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        bPaint = new Paint();
        sPaint = new Paint();
        tPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initPaint();
        RectF brectf = new RectF(20,20,width-20,height-20);
        RectF srectf = new RectF(25,25,width-25,height-25);
        canvas.drawArc(srectf,0,360,false,sPaint);
        canvas.drawText(mprogress + "%", width / 2+10, height / 2+10, tPaint);
        canvas.drawArc(brectf,-90,360*((float)mprogress / progress),false,bPaint);
        super.onDraw(canvas);
    }

    private void initPaint() {
        sPaint.setAntiAlias(true);
        sPaint.setStrokeWidth(5);
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setColor(Color.GREEN);
        sPaint.setStrokeCap(Paint.Cap.ROUND);

        bPaint.setAntiAlias(true);
        bPaint.setStrokeWidth(10);
        bPaint.setStyle(Paint.Style.STROKE);
        bPaint.setColor(Color.RED);
        bPaint.setStrokeCap(Paint.Cap.ROUND);

        tPaint.setAntiAlias(true);
        tPaint.setStrokeWidth(10);
        tPaint.setTextAlign(Paint.Align.CENTER);
        tPaint.setColor(Color.WHITE);
        tPaint.setTextSize(50);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modewidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeheight = MeasureSpec.getMode(heightMeasureSpec);
        int sizewidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeheight = MeasureSpec.getSize(heightMeasureSpec);
        if (modewidth == MeasureSpec.AT_MOST || modewidth == MeasureSpec.EXACTLY){
            width = sizewidth;
        }else {
            width = 0;
        }
        if (modeheight == MeasureSpec.AT_MOST || modeheight == MeasureSpec.UNSPECIFIED){
            height = dipToPx(15);
        }else {
            height = sizeheight;
        }
        setMeasuredDimension(width, height);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
