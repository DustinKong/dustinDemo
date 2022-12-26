package com.dustin.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Context mContext;
    private Button dialog_btn1, dialog_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialog_btn1 = findViewById(R.id.dialog_btn1);
        dialog_btn2 = findViewById(R.id.dialog_btn2);
        OnClick onClick = new OnClick();
        dialog_btn1.setOnClickListener(onClick);
        dialog_btn2.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.dialog_btn1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("hello").setMessage("2022-12-26")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(DialogActivity.this, "good!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("refuse", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(DialogActivity.this, "bad!", Toast.LENGTH_SHORT).show();
                                }
                            }).show();

                    break;
                case R.id.dialog_btn2:
                    break;
            }
        }
    }
}