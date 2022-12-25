package com.dustin.demo.listView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dustin.demo.R;
import com.dustin.demo.gridView.gridViewActivity;

public class listViewActivity extends Activity {
    private ListView mLv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv1 = findViewById(R.id.lv_1);
        mLv1.setAdapter(new MyListAdapter(listViewActivity.this));
        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.i("kqc", String.valueOf(view.getId()));
//                Log.i("kqc", String.valueOf(view.getResources()));
//                Log.i("kqc", view.getContext().getClass().getName());

                Toast.makeText(listViewActivity.this, "长按pos: " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
