package ru.handh.lesson_5_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FourthActivity extends AppCompatActivity {

    private static final String EXTRA_TIME = "time";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.textViewTime)
    TextView textViewTime;

    @BindView(R.id.buttonActivity4)
    Button buttonActivity4;

    Bundle extras;

    public static Intent createInstance(Context context, long time) {
        Intent intent = new Intent(context, FourthActivity.class);
        intent.putExtra(EXTRA_TIME, time);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        ButterKnife.bind(this);

        toolbar.setTitle(getLocalClassName());
        toolbar.setNavigationOnClickListener(event -> finish());

        extras = getIntent().getExtras();

        buttonActivity4.setOnClickListener(view -> startActivity(FourthActivity.createInstance(FourthActivity.this, System.currentTimeMillis())));

        if (extras != null) {
            Date date = new Date(extras.getLong(EXTRA_TIME));
            textViewTime.setText(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date));
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        extras = intent.getExtras();

        if (extras != null) {
            Date date = new Date(extras.getLong(EXTRA_TIME));
            textViewTime.setText(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date));
        }
    }
}
