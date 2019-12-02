package ru.handh.lesson_6_shahin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.handh.lesson_6_shahin.ElectricityInfoItem;
import ru.handh.lesson_6_shahin.R;
import ru.handh.lesson_6_shahin.RowType;
import ru.handh.lesson_6_shahin.WatersInfoItem;

public class AdapterIndications extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RowType> dataSet;

    public AdapterIndications(List<RowType> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case RowType.WATERS_ROW_TYPE: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_waters, parent, false);
                return new WatersViewHolder(view);
            }
            case RowType.ELECTRICITY_ROW_TYPE: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_electricity, parent, false);
                return new ElectricityViewHolder(view);
            }
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WatersViewHolder) {
            ((WatersViewHolder) holder).bind((WatersInfoItem) dataSet.get(position));
        } else if(holder instanceof ElectricityViewHolder){
            ((ElectricityViewHolder) holder).bind((ElectricityInfoItem) dataSet.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dataSet.get(position) instanceof WatersInfoItem) {
            return RowType.WATERS_ROW_TYPE;
        } else if (dataSet.get(position) instanceof ElectricityInfoItem) {
            return RowType.ELECTRICITY_ROW_TYPE;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
