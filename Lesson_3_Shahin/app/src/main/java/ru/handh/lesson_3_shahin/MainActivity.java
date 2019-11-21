package ru.handh.lesson_3_shahin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.toolbar_title_main);
        }
    }

    @OnClick(R.id.buttonConstraint)
    void onClickConstraint() {
        Intent intent = ConstraintActivity.createStartIntent(MainActivity.this);
        startActivity(intent);
    }

    @OnClick(R.id.buttonLinear)
    void onClickLinear() {
        Intent intent = LinearActivity.createStartIntent(MainActivity.this);
        startActivity(intent);
    }
}