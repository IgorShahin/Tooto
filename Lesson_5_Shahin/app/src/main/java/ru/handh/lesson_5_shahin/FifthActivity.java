package ru.handh.lesson_5_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FifthActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.buttonSave)
    Button buttonSave;

    @BindView(R.id.buttonDeliverResult)
    Button buttonDeliverResult;

    @BindView(R.id.editTextActivityFifth)
    EditText editTextActivityFifth;

    @BindView(R.id.textViewActivityFifth)
    TextView textView;

    Data data;

    public static Intent createInstance(Context context) {
        return new Intent(context, FifthActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        ButterKnife.bind(this);

        data = new Data();

        toolbar.setTitle(getLocalClassName());
        toolbar.setNavigationOnClickListener(view -> finish());

        buttonDeliverResult.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", editTextActivityFifth.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        buttonSave.setOnClickListener(view -> {
            data.setValue(editTextActivityFifth.getText().toString());
            textView.setText(data.getValue());
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("text", data);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        data = savedInstanceState.getParcelable("text");
        textView.setText(data.getValue());
    }
}
