package com.example.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class BanZhangFragmeLayout extends FrameLayout {

	private static final String TAG = "MainActivity";

	public BanZhangFragmeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
//	com.example.toucheventdemo.BanZhangFragmeLayout
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(TAG, "�೤���յ��˴�ɨ��������Ϣ....");
		return super.dispatchTouchEvent(ev);
		
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean flag=false;
		if(flag==false){
			Log.i(TAG, "�೤û�������Ϣ");
		}else{
			Log.i(TAG, "�೤����Ϣ�����");
		}
		//true ������� false �������´���
		return flag;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//���Ѵ����¼�
		boolean flag =true;
		if (flag == false) {
			Log.i(TAG, "�೤�Ѵ�ɨ�������������ϴ���");
		} else {
			Log.i(TAG, "�೤��������ɨ��....");
		}
		return flag;
	}
}
