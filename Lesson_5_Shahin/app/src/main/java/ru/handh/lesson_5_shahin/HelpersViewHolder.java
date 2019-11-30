package ru.handh.lesson_5_shahin;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelpersViewHolder extends RecyclerView.ViewHolder {

    Button button;
    TextView textViewAllServices;

    public HelpersViewHolder(@NonNull View itemView) {
        super(itemView);

        button = itemView.findViewById(R.id.buttonOfferService);
        textViewAllServices = itemView.findViewById(R.id.textViewAllServices);
    }

    public void bind() {
        button.setOnClickListener(view -> Toast.makeText(button.getContext(), button.getText(), Toast.LENGTH_SHORT).show());
        textViewAllServices.setOnClickListener(view -> Toast.makeText(textViewAllServices.getContext(), textViewAllServices.getText(), Toast.LENGTH_SHORT).show());
    }
}
