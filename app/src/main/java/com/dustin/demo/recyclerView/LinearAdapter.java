package com.dustin.demo.recyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dustin.demo.R;

/**
 * 自定义了一个Adapter
 * <h3>LinearAdapter extends MyViewHolder extends RecyclerView.ViewHolder</h3>
 * 利用viewType，让文字和图片交叉显示
 */
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.MyViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;

    public RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            Log.d("kqc", String.valueOf(dy));
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new AssertionError();
            }
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            Log.d("kqc", "First visible item position: " + firstVisibleItemPosition);

            int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            Log.d("kqc", "Last visible item position: " + lastVisibleItemPosition);
        }
    };
    //初始化时把这个监听click的listener传入，可以在外部监听click
    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mlistener = listener;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        } else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item2, parent, false));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder) holder).textView.setText("Hello!");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float x = view.getX();
                    float y = view.getY();
                    Log.i("kqc", "Click position: (" + x + ", " + y + ")");
                    Log.i("kqc", String.valueOf(view.getResources()));
                    Log.i("kqc", view.getContext().getClass().getName());
                    mlistener.onClick(position);
                }
            });
        } else {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float x = view.getX();
                    float y = view.getY();
                    Log.i("kqc", "Click position: (" + x + ", " + y + ")");
                    Log.i("kqc", String.valueOf(view.getResources()));
                    Log.i("kqc", view.getContext().getClass().getName());
                    mlistener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class LinearViewHolder extends MyViewHolder {
        private final TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);

        }
    }

    class LinearViewHolder2 extends MyViewHolder {
        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
