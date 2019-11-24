package ru.handh.lesson_4_shahin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter {

    private ArrayList<DetailInfoItem> listDetailInfo;
    private OnClickListener onClickListener;
    Context context;

    public CategoriesAdapter(ArrayList<DetailInfoItem> listDetailInfo, Context context) {
        this.listDetailInfo = listDetailInfo;
        this.context = context;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case DetailInfoItem.GRID_TYPE: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_info, parent, false);
                return new DetailInfoViewHolder(view, onClickListener);
            }
            case DetailInfoItem.LINE_TYPE: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_info, parent, false);
                return new BaseInfoViewHolder(view, onClickListener);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DetailInfoItem object = listDetailInfo.get(position);
        if (object != null) {
            switch (object.getType()) {
                case DetailInfoItem.GRID_TYPE:
                    ((DetailInfoViewHolder) holder).bind(object, context);
                    break;
                case DetailInfoItem.LINE_TYPE:
                    ((BaseInfoViewHolder) holder).bind(object);
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (listDetailInfo.get(position).getType()) {
            case 0:
                return DetailInfoItem.GRID_TYPE;
            case 1:
                return DetailInfoItem.LINE_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return listDetailInfo.size();
    }

    public interface OnClickListener {

        void onItemClick(String text);
    }
}
