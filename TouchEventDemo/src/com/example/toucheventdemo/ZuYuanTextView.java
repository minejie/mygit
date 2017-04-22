package com.example.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class ZuYuanTextView extends TextView {

	private static final String TAG = "MainActivity";

	public ZuYuanTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		Log.i(TAG, "组员_接收到传来的打扫卫生消息");
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//如果是 true,代表消费,false 代表向上 传递事件
		boolean flag = true;
		if (flag == false) {
			Log.i(TAG, "组员把打扫卫生的事情向上传递");
		} else {
			Log.i(TAG, "组员把卫生打扫了....");
		}
		return flag;
	}
}
