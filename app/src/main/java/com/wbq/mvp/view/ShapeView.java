package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wbq501 on 2015-12-23 15:59.
 * demo
 */
public class ShapeView extends View implements View.OnTouchListener {

    private int radius = 40; // 中间小圆的半径
    private Paint mPaint;
    private RectF oval;
    private int width, height;
    private boolean top, right, bottom, left, center;
    private ShapeViewListener onShapListener;

    //回调，进行各个部分的事件监听
    public interface ShapeViewListener {
        public void onTopListener();
        public void onRightListener();
        public void onBottomListener();
        public void onLeftListener();
        public void onCenterListener();
    }

    public void setOnShapeListener(ShapeViewListener onShapListener) {
        this.onShapListener = onShapListener;
    }

    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        //设置背景为天蓝色
        setBackgroundColor(0xFF436EEE);
        setOnTouchListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到布局的宽度
        width = this.getMeasuredWidth();
        height = 2 * width / 3;
        //画椭圆的矩形区域
        oval = new RectF(5, 5, width - 5, height - 5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xffffffff);
        canvas.drawArc(oval, 0, 360, false, mPaint);
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);
        if (center) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xaaffffff);
            canvas.drawCircle(width / 2, height / 2, radius, mPaint);
        }

        //下面这里的扇形范围-56， 112是我调试出来的，MD，不知道为什么-45， 90这样的写法就是有问题，
        //各位看官，如果知道为什么，还望不吝指教
        if (right) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xaaffffff);
            canvas.drawArc(oval, -56, 112, true, mPaint);
        }

        if (bottom) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xaaffffff);
            canvas.drawArc(oval, 57, 66, true, mPaint);
        }

        if (left) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xaaffffff);
            canvas.drawArc(oval, 124, 112, true, mPaint);
        }

        if (top) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xaaffffff);
            canvas.drawArc(oval, 237, 66, true, mPaint);
        }

        //如果上下左右被按了，为了中间的部分不显示，这里画圆遮住了那部分白色
        if (right || top || bottom || left) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0xFF436EEE);
            canvas.drawCircle(width / 2, height / 2, 38, mPaint);
        }

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xffffffff);
        mPaint.setStrokeWidth(1);
        mPaint.setAlpha(100);
        //根据标准椭圆公式，求得的一个量，我们这里只用再进行坐标变换，就可以得到四个在椭圆上的点了
        float t = getCoordinate(width - 10, height - 10);
        //四条区域分割线的起始坐标
        float[] pts = {
                width / 2 + getSF(radius), height / 2 + getSF(radius), width / 2 + t, height / 2 + t,
                width / 2 - getSF(radius), height / 2 + getSF(radius), width / 2 - t, height / 2 + t,
                width / 2 + getSF(radius), height / 2 - getSF(radius), width / 2 + t, height / 2 - t,
                width / 2 - getSF(radius), height / 2 - getSF(radius), width / 2 - t, height / 2 - t};
        canvas.drawLines(pts, mPaint);
    }

    private float getCoordinate(int w, int h) {
        return (float) ((w * h) / (Math.sqrt(w*w + h*h) * 2));
    }

    /** 得到圆形的直角边的长度 */
    private float getSF(int a) {
        return (float) (a / Math.sqrt(2));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                //不在椭圆内，什么处理都不做
                if (!isInOval(x, y)) {
                    return false;
                }
                if (isInCricle(x,y)) {
                    center = true;
                    if (onShapListener != null) {
                        onShapListener.onCenterListener();
                    }
                } else {
                    float a = x - y - (width - height) / 2;
                    float b = x + y - (width + height) / 2;
                    if (a > 0) {
                        if (b > 0) {
                            right = true;
                            if (onShapListener != null) {
                                onShapListener.onRightListener();
                            }
                        } else {
                            top = true;
                            if (onShapListener != null) {
                                onShapListener.onTopListener();
                            }
                        }
                    } else {
                        if (b > 0) {
                            bottom = true;
                            if (onShapListener != null) {
                                onShapListener.onBottomListener();
                            }
                        } else {
                            left = true;
                            if (onShapListener != null) {
                                onShapListener.onLeftListener();
                            }
                        }
                    }
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                top = false;
                right = false;
                bottom = false;
                left = false;
                center = false;
                invalidate();
                break;
        }
        return true;
    }

    /** (x, y)是否在椭圆内部 */
    private boolean isInOval(float x, float y) {
        float tmp = (2*x/width - 1) * (2*x/width - 1) + (2*y/height - 1) * (2*y/height - 1);
        if (tmp <= 1) {
            return true;
        } else {
            return false;
        }
    }

    /** (x, y)是否在中间圆里面 */
    private boolean isInCricle(float x, float y) {
        float tmp = (x - width/2) * (x - width/2) + (y - height/2) * (y - height/2);
        if (tmp <= radius * radius) {
            return true;
        } else {
            return false;
        }
    }
}
//private ShapeView.ShapeViewListener listener;
//
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ShapeView view = new ShapeView(this);
//        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
//        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        view.setLayoutParams(lp);
//        setContentView(view);
//
//        listener = new ShapeView.ShapeViewListener() {
//
//@Override
//public void onTopListener() {
//        show("top");
//        }
//
//@Override
//public void onRightListener() {
//        show("right");
//        }
//
//@Override
//public void onLeftListener() {
//        show("left");
//        }
//
//@Override
//public void onCenterListener() {
//        show("center");
//        }
//
//@Override
//public void onBottomListener() {
//        show("bottom");
//        }
//        };
//        view.setOnShapeListener(listener);
//}
