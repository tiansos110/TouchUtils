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

    public interface OnLeftTpGestureListener {
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

    public interface OnRightTpGestureListener {
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

    public interface OnLeftTpDoubleTapListener {
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

    public interface OnRightTpDoubleTapListener {
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
    public interface OnTpTouchEventListener {
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
        /**
         * 左-后滑
         */
        void onBackSlipL();

        /**
         * 左-前滑动
         */
        void onFrontSlipL();

        /**
         * 左-下滑
         */
        void onDownSlipL();

        /**
         * 左-上滑
         */
        void onUpSlipL();
    }

    /*---------------------右TP keyCode事件-------------------*/
    public interface RightTpSlipActionListener {
        /**
         * 右-后滑
         */
        void onBackSlipR();

        /**
         * 右-前滑
         */
        void onFrontSlipR();

        /**
         * 右-下滑-返回
         */
        void onAirBackPressed();

        /**
         * 右-上滑
         */
        void onUpSlipR();
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
                    leftTpSlipActionListener.onBackSlipL();
                }
                break;
            case KEYCODE_INMO_BACKSLIP_R://右后滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.onBackSlipR();
                }
                break;
            case KEYCODE_INNO_FRONTSLIP_L://左前滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.onFrontSlipL();
                }
                break;
            case KEYCODE_INNO_FRONTSLIP_R://右前滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.onFrontSlipR();
                }
                break;
            case KEYCODE_INNO_DOWNSLIP_L://左下滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.onDownSlipL();
                }
                break;
            case KEYCODE_INNO_DOWNSLIP_R://右下滑,定义为返回
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.onAirBackPressed();
                }
                break;
            case KEYCODE_INNO_UPSLIP_L://左上滑
                if (leftTpSlipActionListener != null) {
                    leftTpSlipActionListener.onUpSlipL();
                }
                break;
            case KEYCODE_INNO_UPSLIP_R://右上滑
                if (rightTpSlipActionListener != null) {
                    rightTpSlipActionListener.onUpSlipR();
                }
                break;
        }
    }

    /*-------------------------触摸事件监听-------------------------*/
    public interface OnAirTouchListener {
        /**
         * 左TP触摸事件
         *
         * @param ev
         */
        void onLeftEvent(MotionEvent ev);

        /**
         * 右TP触摸事件
         *
         * @param ev
         */
        void onRightEvent(MotionEvent ev);
    }

    private static OnAirTouchListener airTouchListener;
    private static final int FINGER_SINGLE = 1;
    private static final int FINGER_DOUBLE = 2;

    public static void dispatchTouchEvent(MotionEvent ev) {
        if (airTouchListener != null) {
            if (ev.getPointerCount() == FINGER_SINGLE) {
                if (ev.getDeviceId() == TP_LEFT) {
                    airTouchListener.onLeftEvent(ev);
                } else if (ev.getDeviceId() == TP_RIGHT) {
                    airTouchListener.onRightEvent(ev);
                }
            }
        }
    }

    public static void registerTouchListener(OnAirTouchListener airTouchListener) {
        Air2GestureDetector.airTouchListener = airTouchListener;
    }
//    public interface OnAirLeftTpTouchListener {
//        /**
//         * 左右滑动
//         *
//         * @param ev
//         */
//        void onLeftTpLRSliding(MotionEvent ev);
//
//        /**
//         * 单指触摸
//         *
//         * @param ev
//         */
//        void onLeftTpSingleTouch(MotionEvent ev);
//
//        /**
//         * 双指触摸
//         *
//         * @param ev
//         */
//        void onLeftTpDoubleTouch(MotionEvent ev);
//    }
//
//    public static OnAirLeftTpTouchListener onAirLeftTpTouchListener;
//
//
//    public interface OnAirRightTpTouchListener {
//        /**
//         * 左右滑动
//         *
//         * @param ev
//         */
//        void onRightTpLRSliding(MotionEvent ev);
//
//        /**
//         * 单指触摸
//         *
//         * @param ev
//         */
//        void onRightTpSingleTouch(MotionEvent ev);
//
//        /**
//         * 双指触摸
//         *
//         * @param ev
//         */
//        void onRightTpDoubleTouch(MotionEvent ev);
//    }
//
//    public static OnAirRightTpTouchListener onAirRightTpTouchListener;
//
//
//    private static float downX, downY;
//    private static final float SLIDE_ANGLE = 45;
//    private static boolean mIsSlideHorizontally;//是否是水平滑动
//
//
//    public static void dispatchTouchEvent(MotionEvent ev) {
//        if (onAirLeftTpTouchListener != null && ev.getDeviceId() == TP_LEFT) {
//            if (ev.getPointerCount() == 1) {
//                onAirLeftTpTouchListener.onLeftTpSingleTouch(ev);
//            } else if (ev.getPointerCount() == 2) {
//                onAirLeftTpTouchListener.onLeftTpDoubleTouch(ev);
//            }
//        }
//
//        if (onAirRightTpTouchListener != null && ev.getDeviceId() == TP_RIGHT) {
//            if (ev.getPointerCount() == 1) {
//                onAirRightTpTouchListener.onRightTpSingleTouch(ev);
//            } else if (ev.getPointerCount() == 2) {
//                onAirRightTpTouchListener.onRightTpDoubleTouch(ev);
//            }
//        }
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downX = ev.getX();
//                downY = ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//            case MotionEvent.ACTION_UP:
//                float moveX = ev.getX();
//                float moveY = ev.getY();
//
//                float xDiff = Math.abs(moveX - downX);
//                float yDiff = Math.abs(moveY - downY);
//
//                double squareRoot = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
//
//                //滑动的角度
//                int yAngle = Math.round((float) (Math.asin(yDiff / squareRoot) / Math.PI * 180));
//                int xAngle = Math.round((float) (Math.asin(xDiff / squareRoot) / Math.PI * 180));
//
//                boolean isMeetSlidingYAngle = yAngle > SLIDE_ANGLE;//滑动角度是否大于45du
//                boolean isMeetSlidingXAngle = xAngle > SLIDE_ANGLE;//滑动角度是否大于45du
//
//                boolean isSlideUp = moveY < downY && isMeetSlidingYAngle;
//                boolean isSlideDown = moveY > downY && isMeetSlidingYAngle;
//                boolean isSlideLeft = moveX < downX && isMeetSlidingXAngle;
//                boolean isSlideRight = moveX > downX && isMeetSlidingXAngle;
//
//                if (isSlideUp) {
//                    mIsSlideHorizontally = false;
//                } else if (isSlideDown) {
//                    mIsSlideHorizontally = false;
//                } else if (isSlideLeft) {
//                    mIsSlideHorizontally = true;
//                    if (onAirLeftTpTouchListener != null && ev.getDeviceId() == TP_LEFT) {
//                        onAirLeftTpTouchListener.onLeftTpLRSliding(ev);
//                    }
//                    if (onAirRightTpTouchListener != null && ev.getDeviceId() == TP_RIGHT) {
//                        onAirRightTpTouchListener.onRightTpLRSliding(ev);
//                    }
//                } else if (isSlideRight) {
//                    mIsSlideHorizontally = true;
//                    if (onAirLeftTpTouchListener != null && ev.getDeviceId() == TP_LEFT) {
//                        onAirLeftTpTouchListener.onLeftTpLRSliding(ev);
//                    }
//                    if (onAirRightTpTouchListener != null && ev.getDeviceId() == TP_RIGHT) {
//                        onAirRightTpTouchListener.onRightTpLRSliding(ev);
//                    }
//                }
//                break;
//            default:
//                break;
//        }
//    }
//
//    public static void registerLeftTpTouchListener(OnAirLeftTpTouchListener onAirLeftTpTouchListener) {
//        Air2GestureDetector.onAirLeftTpTouchListener = onAirLeftTpTouchListener;
//    }
//
//    public static void registerRightTpTouchListener(OnAirRightTpTouchListener onAirRightTpTouchListener) {
//        Air2GestureDetector.onAirRightTpTouchListener = onAirRightTpTouchListener;
//    }
}
