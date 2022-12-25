package com.dustin.demo.recyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dustin.demo.R;

/**
 * 创建了一个线性的RecyclerView布局，内置的Adapter写在外部LinearAdapter
 **/
public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;
    private LinearAdapter adapter;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // your code here
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        adapter = new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            //这里通过LinearAdapter的interface接口，在这里重写onClick事件
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        });
        mRvMain = findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvMain.addItemDecoration(new MyDecoration());
        mRvMain.addOnScrollListener(adapter.mScrollListener);
        mRvMain.setAdapter(adapter);
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.cardview_compat_inset_shadow));
        }
    }
}