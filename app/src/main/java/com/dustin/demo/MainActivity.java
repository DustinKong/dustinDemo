package com.dustin.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUi=findViewById(R.id.btn_ui);
        OnClick click=new OnClick();
        mBtnUi.setOnClickListener(click);
    }

    class OnClick implements View.OnClickListener{
        Intent intent=null;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_ui:
                    intent=new Intent(MainActivity.this, UIActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}