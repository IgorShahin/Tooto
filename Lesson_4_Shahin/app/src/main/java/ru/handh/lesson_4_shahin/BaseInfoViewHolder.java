package ru.handh.lesson_4_shahin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BaseInfoViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageBaseInfo;
    private TextView textViewTitleBase;
    private TextView textViewInfoBase;
    private CardView cardViewBase;

    private CategoriesAdapter.OnClickListener onClickListener;

    public BaseInfoViewHolder(@NonNull View itemView, CategoriesAdapter.OnClickListener onClickListener) {
        super(itemView);

        imageBaseInfo = itemView.findViewById(R.id.imageBaseInfo);
        textViewTitleBase = itemView.findViewById(R.id.textViewBaseTitle);
        textViewInfoBase = itemView.findViewById(R.id.textViewBaseInfo);
        cardViewBase = itemView.findViewById(R.id.cardViewBase);

        this.onClickListener = onClickListener;
    }

    public void bind(BaseInfoItem item) {
        imageBaseInfo.setImageDrawable(item.getDrawableImage());
        textViewTitleBase.setText(item.getTextTitle());

        DetailInfoItem detailItem = (DetailInfoItem) item;
        textViewInfoBase.setText(detailItem.getTextInfo());

        if (textViewInfoBase.getText() == "") {
            textViewInfoBase.setVisibility(View.GONE);
        }else{
            textViewInfoBase.setVisibility(View.VISIBLE);
        }
        cardViewBase.setOnClickListener(view -> onClickListener.onItemClick(textViewTitleBase.getText().toString()));
    }
}