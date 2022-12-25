package com.dustin.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dustin.demo.listView.listViewActivity;
import com.dustin.demo.gridView.gridViewActivity;
import com.dustin.demo.recyclerView.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mEditButton;
    private Button mListViewButton;
    private Button mGridViewButton;
    private Button mRecyclerViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditButton = findViewById(R.id.btn_text);
        mListViewButton = findViewById(R.id.list_view);
        mGridViewButton = findViewById(R.id.grid_view);
        mRecyclerViewButton=findViewById(R.id.recycler_view);
        setListener();
    }

    private void setListener() {
        onClick onclick = new onClick();
        mEditButton.setOnClickListener(onclick);
        mListViewButton.setOnClickListener(onclick);
        mGridViewButton.setOnClickListener(onclick);
        mRecyclerViewButton.setOnClickListener(onclick);
    }

    private class onClick implements View.OnClickListener {
        Intent intent = null;

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_text:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.list_view:
                    intent = new Intent(MainActivity.this, listViewActivity.class);
                    break;
                case R.id.grid_view:
                    intent = new Intent(MainActivity.this, gridViewActivity.class);
                    break;
                case R.id.recycler_view:
                    intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
            }
            startActivity(intent);
        }
    }
}