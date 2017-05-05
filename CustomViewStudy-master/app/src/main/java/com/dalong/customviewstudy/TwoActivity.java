package com.dalong.customviewstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Date：2017/5/5
 * author: 曹政杰Administrator.
 * function：
 */

public class TwoActivity extends Activity{
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_view);
        text=(TextView) findViewById(R.id.texts);
        Intent it=getIntent();
        String day=it.getStringExtra("week");
        text.setText("Today is "+day);
    }
}
