使用
```java
implementation 'com.github.tiansos110:TouchUtils:1.0.4'
```

1.返回事件
只需在onKeyDown中调用
```java
Air2GestureDetector.onKeyDownBackPressed(keyCode, new Air2GestureDetector.OnBackPressedListener() {
    @Override
    public void onAirBackPressed() {
        finish();
    }
});
```

2.InmoAir系统手势
需在onKeyDown中调用,区分左右Tp手势 listener可为null
```java
Air2GestureDetector.onKeyDownAction(int keyCode, LeftTpSlipActionListener leftTpSlipActionListener, RightTpSlipActionListener rightTpSlipActionListener)

其中回调
后滑 onBackSlip 
前滑 onFrontSlip 
下滑 onDownSlip (右TP为onAirBackPressed)
上滑 onUpSlip
```

3.Air2GestureDetector手势处理
与GestureDetector使用类似,listener可为空
```java
air2GestureDetector = new Air2GestureDetector(Context context, OnLeftTpGestureListener onLeftTpGestureListener, OnRightTpGestureListener onRightTpGestureListener)
```
然后在onTouchEvent中设置
```java
air2GestureDetector.onTouchEventGestureDetector(event);
```

若想自己处理直接调用此方法,已区分左右TP
```java
Air2GestureDetector.onTouchEvent(event, new Air2GestureDetector.OnTpTouchEventListener());
```
