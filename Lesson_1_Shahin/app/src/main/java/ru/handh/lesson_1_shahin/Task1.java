package ru.handh.lesson_1_shahin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;
import java.util.TreeSet;

public class Task1 extends AppCompatActivity {

    public static Intent createIntent(Context context){
        return new Intent(context, Task1.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        final Set<String> listStudents = new TreeSet<>();

        final EditText editText = findViewById(R.id.editText);
        final Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonOutput = findViewById(R.id.buttonOutput);
        final TextView textViewList = findViewById(R.id.textViewList);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")){
                    listStudents.add(editText.getText().toString());
                    editText.setText(null);
                }
            }
        });

        buttonOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNewStudent = "";

                for (String list : listStudents) {
                    System.out.println(list);
                    textNewStudent += list + "\n";
                }

                textViewList.setText(textNewStudent);
            }
        });
    }
}
