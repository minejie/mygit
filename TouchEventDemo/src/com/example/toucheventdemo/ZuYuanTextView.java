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
		Log.i(TAG, "��Ա_���յ������Ĵ�ɨ������Ϣ");
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//����� true,��������,false �������� �����¼�
		boolean flag = true;
		if (flag == false) {
			Log.i(TAG, "��Ա�Ѵ�ɨ�������������ϴ���");
		} else {
			Log.i(TAG, "��Ա��������ɨ��....");
		}
		return flag;
	}
}
