package com.example.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ZuZhangRelativeLayout extends RelativeLayout {

	private static final String TAG = "MainActivity";

	public ZuZhangRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(TAG, "�鳤���յ��˴�ɨ��������Ϣ....");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean flag = false;
		if (flag == false) {
			Log.i(TAG, "�鳤û�������Ϣ");
		} else {
			Log.i(TAG, "�鳤����Ϣ�����");
		}
		return flag;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean flag = false;
		if (flag == false) {
			Log.i(TAG, "�鳤�Ѵ�ɨ�������������ϴ���");
		} else {
			Log.i(TAG, "�鳤��������ɨ��....");
		}
		return flag;
	}
}
