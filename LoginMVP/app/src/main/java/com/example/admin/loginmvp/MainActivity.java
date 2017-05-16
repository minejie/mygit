package com.example.admin.loginmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.loginmvp.persenter.LoginPerView;
import com.example.admin.loginmvp.persenter.LoginPersenter;
import com.example.admin.loginmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{
              private EditText text;
    private Button but;
          private LoginPerView persenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText) findViewById(R.id.edit);
        but=(Button) findViewById(R.id.but);
        but.setOnClickListener(this);
        persenter=new LoginPersenter(this);
    }

    @Override
    public void IsRightName() {
        Toast.makeText(this,"It is right",Toast.LENGTH_LONG).show();
    }

    @Override
    public void IsErrorName() {
        Toast.makeText(this,"It is error",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
                persenter.getName(text.getText().toString());
    }
}
