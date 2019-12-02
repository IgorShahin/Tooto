package ru.handh.lesson_4_shahin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int GRID_TYPE = 0;
    public static final int LINE_TYPE = 1;

    private ArrayList<DetailInfoItem> listDetailInfo;
    private OnClickListener onClickListener;

    public CategoriesAdapter(ArrayList<DetailInfoItem> listDetailInfo) {
        this.listDetailInfo = listDetailInfo;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == GRID_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_info, parent, false);
            return new DetailInfoViewHolder(view, onClickListener);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_info, parent, false);
            return new BaseInfoViewHolder(view, onClickListener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DetailInfoViewHolder) {
            ((DetailInfoViewHolder) holder).bind(listDetailInfo.get(position));
        } else {
            ((BaseInfoViewHolder) holder).bind(listDetailInfo.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listDetailInfo.get(position) instanceof DetailInfoItem) {
            if (position == listDetailInfo.size() - 1) {
                return (position % 2 == 0) ? LINE_TYPE : GRID_TYPE;
            } else {
                return (position % 2 == 0 && !(listDetailInfo.get(position + 1) instanceof DetailInfoItem)) ? LINE_TYPE : GRID_TYPE;
            }
        } else return LINE_TYPE;
    }

    @Override
    public int getItemCount() {
        return listDetailInfo.size();
    }

    public interface OnClickListener {

        void onItemClick(String text);
    }
}
