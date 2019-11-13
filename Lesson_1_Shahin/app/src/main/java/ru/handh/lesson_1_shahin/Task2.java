package ru.handh.lesson_1_shahin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Task2 extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, Task2.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        final HashMap<Long, Student> listStudents = new HashMap<>();

        final EditText editText = findViewById(R.id.editText);

        Button buttonOutput = findViewById(R.id.buttonOutput);
        final TextView textViewList = findViewById(R.id.textViewList);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if (i == EditorInfo.IME_ACTION_DONE) {
                    String string = editText.getText().toString();
                    String[] parts = string.split(" ");
                    String regexFullName = "[a-zA-Z-а-яА-я]+";
                    String regexGrade = "[0-9][a-zA-Z-а-яА-я]";
                    String regexBirthdayYear = "[0-9]{4}";

                    if (parts.length == 4 && parts[0].matches(regexFullName) && parts[1].matches(regexFullName)
                            && parts[2].matches(regexGrade) && parts[3].matches(regexBirthdayYear)) {
                        long id = System.currentTimeMillis();
                        listStudents.put(id, new Student(id, parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
                        editText.setText(null);
                    } else {
                        Toast.makeText(Task2.this, R.string.warning_input, Toast.LENGTH_SHORT).show();
                    }
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });

        buttonOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String list = "";
                if (!listStudents.isEmpty()) {
                    for (Map.Entry<Long, Student> entry : listStudents.entrySet()) {
                        list += entry.getValue().getId() + " " + entry.getValue().getSurname() + " " + entry.getValue().getName()
                                + " " + entry.getValue().getGrade() + " " + entry.getValue().getBirthdayYear() + "\n";
                    }
                    textViewList.setText(list);
                }
            }
        });
    }
}
