package ru.handh.lesson_2_shahin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
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

    }
}
