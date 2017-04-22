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
		Log.i(TAG, "��ʦ���յ�ѧУҪ��ɨ��������Ϣ");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//������õ�����ķ���,˵���±ߵ��ӿؼ����¼������ϱ�����.�������еĿؼ���û�д�������¼�...
		Log.i(TAG, "û���˴�ɨ����...");
		return super.onTouchEvent(event);
	}
}
