package ru.handh.lesson_5_shahin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.buttonOpenActivity3)
    Button buttonOpenActivity3;

    public static Intent createInstance(Context context) {
        return new Intent(context, SecondActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        toolbar.setTitle(getLocalClassName());
        toolbar.setNavigationOnClickListener(event -> finish());

        buttonOpenActivity3.setOnClickListener(view -> startActivity(ThirdActivity.createInstance(SecondActivity.this)));
    }
}
