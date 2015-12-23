package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wbq501 on 2015-12-23 16:29.
 * demo
 */
public class MyShapeView extends View{
    private static final int yColor = Color.RED;
    private Paint yPaint;//椭圆画笔
    private Paint tPaint;//字体画笔
    private int width, height;
    String msg0 = "日常办公";
    String msg1 = "业务系统";
    String msg2 = "个人应用";
    private ShapeViewListener onShapListener;
    //回调，进行各个部分的事件监听
    public interface ShapeViewListener {
        public void onRightListener();
        public void onBottomListener();
        public void onLeftListener();
        public void onCenterListener();
    }
    public void setOnShapeListener(ShapeViewListener onShapListener) {
        this.onShapListener = onShapListener;
    }

    public MyShapeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        yPaint = new Paint();
        tPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        RectF oval = new RectF(50, 20, width - 50, height - 20);
        canvas.drawArc(oval, 0, 180, true, yPaint);
        canvas.drawText(msg0, 60, height / 2+10, tPaint);
        canvas.drawText(msg1,width/2,height - 10,tPaint);
        canvas.drawText(msg2,width - 60,height/2+10,tPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x1 = event.getX();
                float y1 = event.getY();
                int x = Integer.valueOf((int) x1);
                int y = Integer.valueOf((int) y1);
                if (x>=0 && x<=60 || y>=(height/2+10) && y<=(height/2-10)){
                    onShapListener.onLeftListener();
                }else if (x>=(width/2+width/4) && x<=width || y>=(height/2+10) && y<=(height/2-10)){
                    onShapListener.onRightListener();
                }else if ((width/4)<= x && x <=(width/2+width/4) || height/2<=y && y<= height){
                    onShapListener.onBottomListener();
                }
                break;
        }
        return true;
    }

    private void initPaint() {
        yPaint.setAntiAlias(true);
        yPaint.setStrokeWidth(5);
        yPaint.setColor(Color.YELLOW);
        yPaint.setStyle(Paint.Style.STROKE);
        yPaint.setStrokeCap(Paint.Cap.ROUND);

        tPaint.setAntiAlias(true);
        tPaint.setStrokeWidth(10);
        tPaint.setTextAlign(Paint.Align.CENTER);
        tPaint.setColor(Color.RED);
        tPaint.setTextSize(30);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY
                || widthSpecMode == MeasureSpec.AT_MOST) {
            width = widthSpecSize;
        } else {
            width = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST
                || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            height = dipToPx(15);
        } else {
            height = heightSpecSize;
        }
        setMeasuredDimension(width, height);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
