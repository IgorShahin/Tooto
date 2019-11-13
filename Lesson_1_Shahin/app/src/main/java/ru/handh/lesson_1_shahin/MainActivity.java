package ru.handh.lesson_1_shahin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTask1 = findViewById(R.id.buttonTask1);
        Button buttonTask2 = findViewById(R.id.buttonTask2);

        buttonTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Task1.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        buttonTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Task2.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}