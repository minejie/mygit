package com.example.toucheventdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(TAG, "老师接收到学校要打扫卫生的消息");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//假如调用到这里的方法,说明下边的子控件把事件传递上边来了.就是所有的控件都没有处理这个事件...
		Log.i(TAG, "没有人打扫卫生...");
		return super.onTouchEvent(event);
	}
}
