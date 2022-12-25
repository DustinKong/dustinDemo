package com.dustin.demo.gridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.dustin.demo.R;

public class gridViewActivity extends AppCompatActivity {
    private GridView mGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv = findViewById(R.id.gv);
        mGv.setAdapter(new MyGridAdapter(gridViewActivity.this));
        //lambda
        mGv.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(gridViewActivity.this, "点击pos: " + i, Toast.LENGTH_SHORT).show());

        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                Log.i("kqc", String.valueOf(view.getResources().getResourceName(view.getId())));
                Log.i("kqc", view.getContext().getClass().getName());

                Toast.makeText(gridViewActivity.this, "长按pos: " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}