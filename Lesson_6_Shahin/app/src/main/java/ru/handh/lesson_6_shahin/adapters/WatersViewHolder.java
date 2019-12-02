package ru.handh.lesson_6_shahin.adapters;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.handh.lesson_6_shahin.R;
import ru.handh.lesson_6_shahin.WatersInfoItem;

class WatersViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewMain;
    private TextView textViewTitle;
    private TextView textViewCode;
    private TextView textViewInfo;

    private ImageButton imageButtonMoreIndication;
    private ImageButton imageButtonInfoIndication;
    private ImageButton imageButtonLaunchWaters;

    private EditText editTextWaters;

    WatersViewHolder(@NonNull View itemView) {
        super(itemView);

        imageViewMain = itemView.findViewById(R.id.imageViewIndication);
        textViewTitle = itemView.findViewById(R.id.textViewIndicationTitle);
        textViewCode = itemView.findViewById(R.id.textViewCodeIndication);
        textViewInfo = itemView.findViewById(R.id.textViewInfoWaters);

        imageButtonInfoIndication = itemView.findViewById(R.id.imageButtonInfoIndication);
        imageButtonMoreIndication = itemView.findViewById(R.id.imageButtonMoreIndication);
        imageButtonLaunchWaters = itemView.findViewById(R.id.imageButtonLaunchWaters);

        editTextWaters = itemView.findViewById(R.id.editTextWaters);
    }

    void bind(WatersInfoItem item) {

        imageViewMain.setImageResource(item.getImage());
        textViewTitle.setText(item.getTextTitle());
        textViewInfo.setText(item.getTextInfo());
        textViewCode.setText(String.valueOf(item.getSerialNumber()));

        if (item.isTextInfoWarning()) {
            textViewInfo.setTextColor(textViewInfo.getResources().getColor(R.color.coral));
            textViewInfo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_alert, 0, 0, 0);
        } else {
            textViewInfo.setTextColor(textViewInfo.getResources().getColor(R.color.charcoal_grey));
            textViewInfo.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        imageButtonMoreIndication.setOnClickListener(view -> Toast.makeText(imageButtonMoreIndication.getContext(), textViewCode.getText(), Toast.LENGTH_SHORT).show());
        imageButtonInfoIndication.setOnClickListener(view -> Toast.makeText(imageButtonInfoIndication.getContext(), textViewTitle.getText(), Toast.LENGTH_SHORT).show());

        imageButtonLaunchWaters.setOnClickListener(view -> {
            if(!editTextWaters.getText().toString().equals("")){
                item.setIndication(Integer.parseInt(editTextWaters.getText().toString()));
                Toast.makeText(editTextWaters.getContext(), editTextWaters.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
