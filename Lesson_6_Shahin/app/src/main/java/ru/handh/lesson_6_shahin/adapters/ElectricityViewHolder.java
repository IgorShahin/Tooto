package ru.handh.lesson_6_shahin.adapters;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.handh.lesson_6_shahin.ElectricityInfoItem;
import ru.handh.lesson_6_shahin.R;

class ElectricityViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewMain;
    private TextView textViewTitle;
    private TextView textViewCode;
    private TextView textViewInfo;

    private ImageButton imageButtonMoreIndication;
    private ImageButton imageButtonInfoIndication;
    private ImageButton imageButtonLaunchElectricity;

    private EditText editTextDaytime;
    private EditText editTextNight;
    private EditText editTextPeak;

    ElectricityViewHolder(@NonNull View itemView) {
        super(itemView);

        imageViewMain = itemView.findViewById(R.id.imageViewIndication);
        textViewTitle = itemView.findViewById(R.id.textViewIndicationTitle);
        textViewCode = itemView.findViewById(R.id.textViewCodeIndication);
        textViewInfo = itemView.findViewById(R.id.textViewInfoElectricity);

        imageButtonInfoIndication = itemView.findViewById(R.id.imageButtonInfoIndication);
        imageButtonMoreIndication = itemView.findViewById(R.id.imageButtonMoreIndication);
        imageButtonLaunchElectricity = itemView.findViewById(R.id.imageButtonLaunchElectricity);

        editTextDaytime = itemView.findViewById(R.id.editTextDaytime);
        editTextNight = itemView.findViewById(R.id.editTextNight);
        editTextPeak = itemView.findViewById(R.id.editTextPeak);
    }

    void bind(ElectricityInfoItem item) {

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

        imageButtonLaunchElectricity.setOnClickListener(view -> {
            if(!editTextDaytime.getText().toString().equals("") && !editTextNight.getText().toString().equals("") && !editTextPeak.getText().toString().equals("")){
                item.setIndicationDaytime(Integer.parseInt(editTextDaytime.getText().toString()));
                item.setIndicationNight(Integer.parseInt(editTextNight.getText().toString()));
                item.setIndicationPeak(Integer.parseInt(editTextPeak.getText().toString()));
                Toast.makeText(imageButtonLaunchElectricity.getContext(), imageButtonLaunchElectricity.getResources().getString(R.string.text_launch,
                        editTextDaytime.getText(), editTextNight.getText(), editTextPeak.getText()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
