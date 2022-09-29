**InmoAir手势操作帮助**<br>

**用法和GestureDetector类似**<br>
  ```java
     air2GestureDetector = new Air2GestureDetector(this,Air2GestureDetector.OnLeftTpGestureListener(),this,Air2GestureDetector.OnRightTpGestureListener());
```
**在OnTouch中调用**<br>
  ```java
     air2GestureDetector.onTouchEventGestureDetector(event);

    或者开发者可以自己处理触摸事件 
        Air2GestureDetector.onTouchEvent(event, new Air2GestureDetector.OnTpTouchEventListener());
```