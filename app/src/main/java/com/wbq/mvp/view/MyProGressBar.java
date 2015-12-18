package com.wbq.mvp.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wbq501 on 2015-12-18 10:45.
 * demo
 */
public class MyProGressBar extends View{
    private Paint mArcPaint;
    private Paint mArcBGPaint;

    private RectF mOval;
    private float mSweep = 0;
    private int mSpeedMax = 200;
    private int mThreshold = 100;
    private int mIncSpeedValue = 0;
    private int mCurrentSpeedValue = 0;
    private float mCenterX;
    private float mCenterY;
    private float mSpeedArcWidth;

    private final float SPEED_VALUE_INC = 2;

    public MyProGressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        super.onSizeChanged(w, h, ow, oh);
        Log.i("onSizeChanged w", w + "");
        Log.i("onSizeChanged h", h+"");
        mCenterX = w * 0.5f;  // remember the center of the screen
        mCenterY = h - mSpeedArcWidth;
        mOval = new RectF(mCenterX - mCenterY, mSpeedArcWidth, mCenterX + mCenterY, mCenterY * 2);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(mSpeedArcWidth);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mArcPaint.setColor(0xff81ccd6);
        BlurMaskFilter mBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.INNER);
        mArcPaint.setMaskFilter(mBlur);

        mArcBGPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcBGPaint.setStyle(Paint.Style.STROKE);
        mArcBGPaint.setStrokeWidth(mSpeedArcWidth+8);
        mArcBGPaint.setColor(0xff171717);

        BlurMaskFilter mBGBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.INNER);
        mArcBGPaint.setMaskFilter(mBGBlur);
        drawSpeed(canvas);
        calcSpeed();
        super.onDraw(canvas);
    }
    private void drawSpeed(Canvas canvas) {
        canvas.drawArc(mOval, 179, 181, false, mArcBGPaint);

        mSweep = (float) mIncSpeedValue / mSpeedMax * 180;
        if (mIncSpeedValue > mThreshold) {
            mArcPaint.setColor(0xFFFF0000);
        }
        else {
            mArcPaint.setColor(0xFF00B0F0);
        }

        canvas.drawArc(mOval, 180, mSweep, false, mArcPaint);
    }

    private void calcSpeed() {
        if (mIncSpeedValue < mCurrentSpeedValue) {
            mIncSpeedValue += SPEED_VALUE_INC;
            if (mIncSpeedValue > mCurrentSpeedValue) {
                mIncSpeedValue = mCurrentSpeedValue;
            }
            invalidate();
        }
        else if (mIncSpeedValue > mCurrentSpeedValue) {
            mIncSpeedValue -= SPEED_VALUE_INC;
            if (mIncSpeedValue < mCurrentSpeedValue) {
                mIncSpeedValue = mCurrentSpeedValue;
            }
            invalidate();
        }
    }
}
