package ru.handh.lesson_4_shahin;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DetailInfoViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageDetailInfo;
    private TextView textViewTitleDetail;
    private TextView textViewInfoDetail;
    private CardView cardViewDetail;

    private CategoriesAdapter.OnClickListener onClickListener;

    public DetailInfoViewHolder(@NonNull View itemView, CategoriesAdapter.OnClickListener onClickListener) {
        super(itemView);

        imageDetailInfo = itemView.findViewById(R.id.imageDetailInfo);
        textViewTitleDetail = itemView.findViewById(R.id.textViewDetailTitle);
        textViewInfoDetail = itemView.findViewById(R.id.textViewDetailInfo);
        cardViewDetail = itemView.findViewById(R.id.cardViewDetail);

        this.onClickListener = onClickListener;
    }

    public void bind(DetailInfoItem item) {
        imageDetailInfo.setImageDrawable(item.getDrawableImage());
        textViewTitleDetail.setText(item.getTextTitle());
        textViewInfoDetail.setText(item.getTextInfo());
        if (item.isTextInfoWarning()) {
            textViewInfoDetail.setTextColor(textViewInfoDetail.getResources().getColor(R.color.coral));
        }else{

        }

        cardViewDetail.setOnClickListener(view -> onClickListener.onItemClick(textViewTitleDetail.getText().toString()));
    }
}
