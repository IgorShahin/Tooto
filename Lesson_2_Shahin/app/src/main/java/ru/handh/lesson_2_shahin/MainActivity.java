package ru.handh.lesson_2_shahin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonTask1)
    void buttonTask1Click(){
        Intent intent = Task1Activity.createStartIntent(MainActivity.this);
        startActivity(intent);
    }

    @OnClick(R.id.buttonTask2)
    void buttonTask2Click(){
        Intent intent = Task2Activity.createStartIntent(MainActivity.this);
        startActivity(intent);
    }
}