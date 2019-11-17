package ru.handh.lesson_2_shahin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Task2Activity extends AppCompatActivity {

    public static Intent createStartIntent(Context context){
        return new Intent(context, Task2Activity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
    }
}
