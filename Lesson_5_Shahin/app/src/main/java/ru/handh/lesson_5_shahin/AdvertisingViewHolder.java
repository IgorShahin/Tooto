package ru.handh.lesson_5_shahin;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import ru.handh.lesson_5_shahin.adapter.CategoriesAdapter;

public class AdvertisingViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewAdvertising;
    TextView textViewTitle;
    TextView textViewInfo;
    TextView textViewAddress;
    ConstraintLayout constraintAdvertising;
    FrameLayout frameRecyclerMenu;

    private CategoriesAdapter.OnClickListener onClickListener;

    public AdvertisingViewHolder(@NonNull View itemView, CategoriesAdapter.OnClickListener onClickListener) {
        super(itemView);

        imageViewAdvertising = itemView.findViewById(R.id.imageViewAdvertising);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewInfo = itemView.findViewById(R.id.textViewInfo);
        textViewAddress = itemView.findViewById(R.id.textViewAddress);
        frameRecyclerMenu = itemView.findViewById(R.id.frameRecyclerMenu);
        constraintAdvertising = itemView.findViewById(R.id.constraintAdvertising);

        this.onClickListener = onClickListener;
    }

    public void bind(AdvertisingItem item) {

        Glide.with(imageViewAdvertising.getContext()).load(item.getImageURL()).into(imageViewAdvertising);

        textViewTitle.setText(item.getTitle());
        textViewInfo.setText(item.getInfo());
        textViewAddress.setText(item.getAddress());

        frameRecyclerMenu.setOnClickListener(view -> Snackbar.make(view, textViewInfo.getText(), Snackbar.LENGTH_SHORT).show());
        constraintAdvertising.setOnClickListener(view -> onClickListener.onItemClick(textViewTitle.getText().toString()));
    }
}