package com.inmoglass.touchutils.utils;

import android.view.MotionEvent;

/**
 * @author Jack
 * @date 2022/10/10 15:10
 */
public class SingleTapUtil {

    long mDownTime;
    double mDownX;
    double mDownY;
    double mRange = 20;
    long mSingleTapTime = 200;

    private SingleTapListener mSingleTapListener;

    private void processSingleTap(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mDownTime = System.currentTimeMillis();
            mDownX = event.getX();
            mDownY = event.getY();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            long nowTime = System.currentTimeMillis();
            if (nowTime - mDownTime < mSingleTapTime) {
                if (isInCircles(mDownX, mDownY, event)) {
                    if (mSingleTapListener != null) {
                        mSingleTapListener.onSingleTapConfirmed();
                    }
                }
            }
        }
    }

    private boolean isInCircles(double lat, double lon, MotionEvent event) {
        return getDistance(event.getX(), event.getY(), lat, lon) <= mRange;
    }

    private double getDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.abs((lat1 - lat2) * (lat1 - lat2)) + Math.abs((lon1 - lon2) * (lon1 - lon2)));
    }

    /**
     * 设置触摸判断的范围
     * @param range 坐标点半径，默认为20
     */
    public void setRange(double range) {
        mRange = range;
    }

    /**
     * 设置单击回调监听
     * @param singleTapListener 单击回调监听
     */
    public void setSingleTapListener(SingleTapListener singleTapListener) {
        mSingleTapListener = singleTapListener;
    }

    /**
     * 设置判断单击的时间
     * @param singleTapTime 默认单击的时间，单位毫秒，默认是200ms
     */
    public void setSingleTapTime(long singleTapTime) {
        mSingleTapTime = singleTapTime;
    }
}
