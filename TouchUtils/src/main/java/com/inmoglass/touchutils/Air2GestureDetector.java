package com.inmoglass.touchutils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @Author: lt
 * @Description:手势操作帮助类
 */
public class Air2GestureDetector {
    private static final int TP_LEFT = 3;
    private static final int TP_RIGHT = 1;

    public static final int KEYCODE_GESTURE_BASE = 314;
    public static final int KEYCODE_INMO_BACKSLIP_L = KEYCODE_GESTURE_BASE + 0;
    public static final int KEYCODE_INMO_BACKSLIP_R = KEYCODE_GESTURE_BASE + 1;
    public static final int KEYCODE_INNO_FRONTSLIP_L = KEYCODE_GESTURE_BASE + 2;
    public static final int KEYCODE_INNO_FRONTSLIP_R = KEYCODE_GESTURE_BASE + 3;
    public static final int KEYCODE_INNO_DOWNSLIP_L = KEYCODE_GESTURE_BASE + 4;
    public static final int KEYCODE_INNO_DOWNSLIP_R = KEYCODE_GESTURE_BASE + 5;
    public static final int KEYCODE_INNO_UPSLIP_L = KEYCODE_GESTURE_BASE + 6;
    public static final int KEYCODE_INNO_UPSLIP_R = KEYCODE_GESTURE_BASE + 7;
    //    private final int LAST_KEYCODE = KEYCODE_INWO_DTOU_R;


    /*-------------------------GestureDetector手势处理----------------------*/
    private GestureDetector leftGestureDetector;
    private GestureDetector rightGestureDetector;

    interface OnLeftTpGestureListener {
        boolean onLeftDown(MotionEvent e);

        void onLeftShowPress(MotionEvent e);

        boolean onLeftSingleTapUp(MotionEvent e);

        boolean onLeftScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

        void onLeftLongPress(MotionEvent e);

        boolean onLeftFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
    }

    private OnLeftTpGestureListener onLeftTpGestureListener;

    public void setLeftTpOnGestureListener(OnLeftTpGestureListener leftTpOnGestureListener) {
        this.onLeftTpGestureListener = leftTpOnGestureListener;
    }

    interface OnRightTpGestureListener {
        boolean onRightDown(MotionEvent e);

        void onRightShowPress(MotionEvent e);

        boolean onRightSingleTapUp(MotionEvent e);

        boolean onRightScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

        void onRightLongPress(MotionEvent e);

        boolean onRightFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
    }

    private OnRightTpGestureListener OnRightTpGestureListener;

    public void setOnRightTpGestureListener(OnRightTpGestureListener onRightTpGestureListener) {
        this.OnRightTpGestureListener = onRightTpGestureListener;
    }

    interface OnLeftTpDoubleTapListener {
        boolean onLeftSingleTapConfirmed(MotionEvent e);

        boolean onLeftDoubleTap(MotionEvent e);

        boolean onLeftDoubleTapEvent(MotionEvent e);
    }

    private OnLeftTpDoubleTapListener onLeftTpDoubleTapListener;

    public void setOnLeftTpDoubleTapListener(OnLeftTpDoubleTapListener onLeftTpDoubleTapListener) {
        this.onLeftTpDoubleTapListener = onLeftTpDoubleTapListener;
        if (leftGestureDetector == null) return;
        leftGestureDetector.setOnDoubleTapListener(onDoubleTapLeftListener);
    }

    interface OnRightTpDoubleTapListener {
        boolean onRightSingleTapConfirmed(MotionEvent e);

        boolean onRightDoubleTap(MotionEvent e);

        boolean onRightDoubleTapEvent(MotionEvent e);
    }

    private OnRightTpDoubleTapListener onRightTpDoubleTapListener;

    public void setOnRightTpDoubleTapListener(OnRightTpDoubleTapListener onRightTpDoubleTapListener) {
        this.onRightTpDoubleTapListener = onRightTpDoubleTapListener;
        if (rightGestureDetector == null) return;
        rightGestureDetector.setOnDoubleTapListener(onDoubleTapRightListener);
    }

    public Air2GestureDetector(Context context, OnLeftTpGestureListener onLeftTpGestureListener, OnRightTpGestureListener onRightTpGestureListener) {
        if (onLeftTpGestureListener != null) {
            this.onLeftTpGestureListener = onLeftTpGestureListener;
        }
        leftGestureDetector = new GestureDetector(context, onLeftGestureListener);

        if (onRightTpGestureListener != null) {
            this.OnRightTpGestureListener = onRightTpGestureListener;
        }
        rightGestureDetector = new GestureDetector(context, onRightGestureListener);
    }

    private GestureDetector.OnDoubleTapListener onDoubleTapLeftListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (onLeftTpDoubleTapListener != null) {
                return onLeftTpDoubleTapListener.onLeftSingleTapConfirmed(e);
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (onLeftTpDoubleTapListener != null) {
                return onLeftTpDoubleTapListener.onLeftDoubleTap(e);
            }
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            if (onLeftTpDoubleTapListener != null) {
                return onLeftTpDoubleTapListener.onLeftDoubleTapEvent(e);
            }
            return false;
        }
    };

    private GestureDetector.OnDoubleTapListener onDoubleTapRightListener = new GestureDetector.OnDoubleTapListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (onRightTpDoubleTapListener != null) {
                return onRightTpDoubleTapListener.onRightSingleTapConfirmed(e);
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (onRightTpDoubleTapListener != null) {
                return onRightTpDoubleTapListener.onRightDoubleTap(e);
            }
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            if (onRightTpDoubleTapListener != null) {
                return onRightTpDoubleTapListener.onRightDoubleTapEvent(e);
            }
            return false;
        }
    };

    private GestureDetector.OnGestureListener onLeftGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            if (onLeftTpGestureListener != null) {
                return onLeftTpGestureListener.onLeftDown(e);
            }
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            if (onLeftTpGestureListener != null) {
                onLeftTpGestureListener.onLeftShowPress(e);
            }
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (onLeftTpGestureListener != null) {
                return onLeftTpGestureListener.onLeftSingleTapUp(e);
            }
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (onLeftTpGestureListener != null) {
                return onLeftTpGestureListener.onLeftScroll(e1, e2, distanceX, distanceY);
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            if (onLeftTpGestureListener != null) {
                onLeftTpGestureListener.onLeftLongPress(e);
            }
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (onLeftTpGestureListener != null) {
                return onLeftTpGestureListener.onLeftFling(e1, e2, velocityX, velocityY);
            }
            return false;
        }
    };

    private GestureDetector.OnGestureListener onRightGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            if (OnRightTpGestureListener != null) {
                return OnRightTpGestureListener.onRightDown(e);
            }
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            if (OnRightTpGestureListener != null) {
                OnRightTpGestureListener.onRightShowPress(e);
            }
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (OnRightTpGestureListener != null) {
                return OnRightTpGestureListener.onRightSingleTapUp(e);
            }
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (OnRightTpGestureListener != null) {
                return OnRightTpGestureListener.onRightScroll(e1, e2, distanceX, distanceY);
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            if (OnRightTpGestureListener != null) {
                OnRightTpGestureListener.onRightLongPress(e);
            }
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (OnRightTpGestureListener != null) {
                return OnRightTpGestureListener.onRightFling(e1, e2, velocityX, velocityY);
            }
            return false;
        }
    };

    public void onTouchEventGestureDetector(MotionEvent event) {
        switch (event.getDeviceId()) {
            case TP_LEFT:
                leftGestureDetector.onTouchEvent(event);
                break;
            case TP_RIGHT:
                rightGestureDetector.onTouchEvent(event);
                break;
        }
    }

    /*-----------------------开发者自己处理onTouchEvent事件---------------------*/
    interface OnTpTouchEventListener {
        void onRightTpTouchEvent(MotionEvent event);

        void onLeftTpTouchEvent(MotionEvent event);
    }

    public static void onTouchEvent(MotionEvent event, OnTpTouchEventListener onTpTouchEventListener) {
        switch (event.getDeviceId()) {
            case TP_LEFT:
                if (onTpTouchEventListener != null) {
                    onTpTouchEventListener.onLeftTpTouchEvent(event);
                }
                break;
            case TP_RIGHT:
                if (onTpTouchEventListener != null) {
                    onTpTouchEventListener.onRightTpTouchEvent(event);
                }
                break;
        }
    }


    /*---------------------左TP keyCode事件-------------------*/
    public interface LeftTpSlipActionListener {
        void backSlipL();

        void frontSlipL();

        void downSlipL();

        void upSlipL();
    }

    /*---------------------右TP keyCode事件-------------------*/
    public interface RightTpSlipActionListener {
        void backSlipR();

        void frontSlipR();

        void onAirBackPressed();

        void upSlipR();
    }

    /**
     * 单独退出事件回调
     */
    public interface OnBackPressedListener {
        void onAirBackPressed();
    }

    public static void onKeyDownBackPressed(int keyCode, OnBackPressedListener onBackPressedListener) {
        if (keyCode == KEYCODE_INNO_DOWNSLIP_R) {
            if (onBackPressedListener != null) {
                onBackPressedListener.onAirBackPressed();
            }
        }
    }

    /**
     * keycode事件回调
     *
     * @param keyCode
     * @param leftTpSlipActionListener  左tp动作回调
     * @param rightTpSlipActionListener 右tp动作回调
     */
    public static void onKeyDownAction(int keyCode, LeftTpSlipActionListener leftTpSlipActionListener, RightTpSlipActionListener rightTpSlipActionListener) {
        switch (keyCode) {
            case KEYCODE_INMO_BACKSLIP_L://左后滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.backSlipL();
                }
                break;
            case KEYCODE_INMO_BACKSLIP_R://右后滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.backSlipR();
                }
                break;
            case KEYCODE_INNO_FRONTSLIP_L://左前滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.frontSlipL();
                }
                break;
            case KEYCODE_INNO_FRONTSLIP_R://右前滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.frontSlipR();
                }
                break;
            case KEYCODE_INNO_DOWNSLIP_L://左下滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.downSlipL();
                }
                break;
            case KEYCODE_INNO_DOWNSLIP_R://右下滑,定义为返回
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.onAirBackPressed();
                }
                break;
            case KEYCODE_INNO_UPSLIP_L://左上滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.upSlipL();
                }
                break;
            case KEYCODE_INNO_UPSLIP_R://右上滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.upSlipR();
                }
                break;
        }
    }
}
