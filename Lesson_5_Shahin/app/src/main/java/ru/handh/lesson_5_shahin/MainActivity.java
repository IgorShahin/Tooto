package ru.handh.lesson_5_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.buttonOpenActivity4)
    Button buttonOpenActivity4;

    @BindView(R.id.buttonOpenActivity2)
    Button buttonOpenActivity2;

    public static Intent createInstance(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        toolbar.setTitle(getLocalClassName());
        toolbar.setNavigationOnClickListener(view -> finish());

        buttonOpenActivity4.setOnClickListener(view -> startActivity(FourthActivity.createInstance(MainActivity.this, System.currentTimeMillis())));
        buttonOpenActivity2.setOnClickListener(view -> startActivity(SecondActivity.createInstance(MainActivity.this)));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        buttonOpenActivity4.setOnClickListener(view -> startActivity(FourthActivity.createInstance(MainActivity.this, System.currentTimeMillis())));
        buttonOpenActivity2.setOnClickListener(view -> startActivity(SecondActivity.createInstance(MainActivity.this)));
    }
}
