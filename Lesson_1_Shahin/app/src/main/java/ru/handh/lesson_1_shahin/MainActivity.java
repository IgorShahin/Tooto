package ru.handh.lesson_1_shahin;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final HashMap<Long, Student> listStudents = new HashMap<>();

        final EditText editText = findViewById(R.id.editText);

        Button buttonOutput = findViewById(R.id.buttonOutput);
        final TextView textViewList = findViewById(R.id.textViewList);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                    String string = editText.getText().toString();
                    String[] parts = string.split(" ");
                    String regexFullName = "[a-zA-Z-а-яА-я]+";
                    String regexGrade = "[0-9][a-zA-Z-а-яА-я]";
                    String regexBirthdayYear = "[0-9]{4}";

                    if(parts.length == 4 && parts[0].matches(regexFullName) && parts[1].matches(regexFullName)
                            && parts[2].matches(regexGrade) && parts[3].matches(regexBirthdayYear)){
                        long id = System.currentTimeMillis();
                        listStudents.put(id, new Student(id, parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
                        editText.setText(null);
                    }else{
                        Toast.makeText(MainActivity.this, "Enter correct data", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });

        buttonOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list = "";
                if(!listStudents.isEmpty()){
                    for (Map.Entry<Long, Student> entry: listStudents.entrySet()) {
                        System.out.println(entry.getValue().getId() + " " + entry.getValue().getSurname() + " " + entry.getValue().getName()
                                + " " + entry.getValue().getGrade() + " " + entry.getValue().getBirthdayYear() + "\n");
                        list += entry.getValue().getId() + " " + entry.getValue().getSurname() + " " + entry.getValue().getName()
                                + " " + entry.getValue().getGrade() + " " + entry.getValue().getBirthdayYear() + "\n";
                    }

                    textViewList.setText(list);
                }
            }
        });
    }
}