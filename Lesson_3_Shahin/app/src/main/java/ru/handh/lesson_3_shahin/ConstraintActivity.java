package ru.handh.lesson_3_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConstraintActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.textViewName)
    TextView viewName;
    @BindView(R.id.textViewSurname)
    TextView viewSurname;
    @BindView(R.id.textViewEmail)
    TextView viewEmail;
    @BindView(R.id.textViewLogin)
    TextView viewLogin;
    @BindView(R.id.textViewRegion)
    TextView viewRegion;
    @BindView(R.id.textViewNumberCard)
    TextView viewNumberCard;

    public static Intent createStartIntent(Context context) {
        return new Intent(context, ConstraintActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.toolbar_title_profile);
        }

        Profile profile = new Profile("Анастасия", "Антонина", "anykee.box@gmail.ru",
                "HIE023UOI88", "Санкт-Петербург", 7898769);

        String textNumberCard = "Карта №" + profile.getNumberCard() + "\nСпециалист";

        viewName.setText(profile.getName());
        viewSurname.setText(profile.getSurname());
        viewEmail.setText(profile.getEmail());
        viewLogin.setText(profile.getLogin());
        viewRegion.setText(profile.getRegion());
        viewNumberCard.setText(textNumberCard);
    }

    @OnClick(R.id.buttonExitAccount)
    void onClickExit() {
        Toast.makeText(ConstraintActivity.this, R.string.click_exit, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.buttonEditRegion)
    void onClickEditRegion() {
        Toast.makeText(ConstraintActivity.this, R.string.click_region, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                this.finish();
                return true;
            }
            case R.id.menuProfile: {
                Toast.makeText(ConstraintActivity.this, R.string.click_menu, Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}