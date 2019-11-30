package ru.handh.lesson_5_shahin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.handh.lesson_5_shahin.AdvertisingItem;
import ru.handh.lesson_5_shahin.AdvertisingViewHolder;
import ru.handh.lesson_5_shahin.HelpersViewHolder;
import ru.handh.lesson_5_shahin.R;

public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ADVERTISING = 0;
    private static final int VIEW_TYPE_HELPERS = 1;

    private ArrayList<AdvertisingItem> listAdvertising;

    private OnClickListener onClickListener;

    public CategoriesAdapter(ArrayList<AdvertisingItem> listAdvertising) {
        this.listAdvertising = listAdvertising;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HELPERS) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_sevices, parent, false);
            return new HelpersViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_advertising, parent, false);
            return new AdvertisingViewHolder(view, onClickListener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AdvertisingViewHolder) {
            ((AdvertisingViewHolder) holder).bind(listAdvertising.get(position - 1));
        } else {
            ((HelpersViewHolder) holder).bind();
        }
    }

    @Override
    public int getItemCount() {
        return listAdvertising.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position != 0) ? VIEW_TYPE_ADVERTISING : VIEW_TYPE_HELPERS;
    }

    public interface OnClickListener {
        void onItemClick(String text);
    }
}
