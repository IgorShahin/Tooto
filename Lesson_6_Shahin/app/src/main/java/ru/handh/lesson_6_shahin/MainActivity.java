package ru.handh.lesson_6_shahin;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.handh.lesson_6_shahin.fragments.FragmentOne;
import ru.handh.lesson_6_shahin.fragments.FragmentPageBanner;
import ru.handh.lesson_6_shahin.fragments.FragmentThree;
import ru.handh.lesson_6_shahin.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentPageBanner.OnClickListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = menuItem -> {
        switch (menuItem.getItemId()) {
            case R.id.navigation_one:
                loadFragment(FragmentOne.newInstance());
                return true;
            case R.id.navigation_two:
                loadFragment(FragmentTwo.newInstance());
                return true;
            case R.id.navigation_three:
                loadFragment(FragmentThree.newInstance());
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_one);
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.viewContainer, fragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", bottomNavigationView.getSelectedItemId());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bottomNavigationView.setSelectedItemId(savedInstanceState.getInt("position"));
    }

    @Override
    public void onItemClick(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
