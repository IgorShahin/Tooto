package ru.handh.lesson_6_shahin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import ru.handh.lesson_6_shahin.R;

public class FragmentOne extends Fragment {

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_search: {
                    Toast.makeText(getContext(), "menu search", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.g1_item2: {
                    Toast.makeText(getContext(), "g1_item2", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.g2_item1: {
                    Toast.makeText(getContext(), "R.id.g2_item1", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.g2_item2: {
                    Toast.makeText(getContext(), "R.id.g2_item2", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            return false;
        });

        toolbar.inflateMenu(R.menu.menu_item_one);
    }
}
