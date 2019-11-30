package ru.handh.lesson_5_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity {

    public static final int MESSAGE_REQUEST = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.buttonOpenActivity5)
    Button buttonOpenActivity5;

    @BindView(R.id.buttonOpenActivity1)
    Button buttonOpenActivity1;

    @BindView(R.id.linearThirdActivity)
    LinearLayout linearLayout;

    public static Intent createInstance(Context context) {
        return new Intent(context, ThirdActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ButterKnife.bind(this);

        toolbar.setTitle(getLocalClassName());
        toolbar.setNavigationOnClickListener(event -> finish());

        buttonOpenActivity1.setOnClickListener(view -> startActivity(MainActivity.createInstance(ThirdActivity.this)));
        buttonOpenActivity5.setOnClickListener(view -> startActivityForResult(FifthActivity.createInstance(ThirdActivity.this), MESSAGE_REQUEST));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MESSAGE_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Snackbar.make(linearLayout, Objects.requireNonNull(data.getStringExtra("result")), Snackbar.LENGTH_SHORT).show();
                }
            }
        }
    }
}
