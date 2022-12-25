package com.dustin.demo.recyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dustin.demo.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;

    public GridAdapter(Context context, OnItemClickListener listener) {
        this.mlistener = listener;
        this.mContext = context;
    }

    @NonNull
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recycler_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText("Hello!Hor");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("kqc", String.valueOf(view.getId()));
                Log.i("kqc", String.valueOf(view.getResources()));
                Log.i("kqc", view.getContext().getClass().getName());
                mlistener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);

        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
