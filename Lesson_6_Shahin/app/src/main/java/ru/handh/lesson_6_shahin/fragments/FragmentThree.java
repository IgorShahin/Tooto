package ru.handh.lesson_6_shahin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

import ru.handh.lesson_6_shahin.ModelViewPager;
import ru.handh.lesson_6_shahin.R;
import ru.handh.lesson_6_shahin.adapters.AdapterViewPager;

public class FragmentThree extends Fragment {

    private boolean isShown = false;

    public static FragmentThree newInstance() {
        return new FragmentThree();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button button = view.findViewById(R.id.buttonBanner);
        PageIndicatorView pageIndicatorView = view.findViewById(R.id.pageIndicatorView);

        List<ModelViewPager> modelViewPagers = new ArrayList<>();
        modelViewPagers.add(new ModelViewPager(R.drawable.img_1, "Картинка 1"));
        modelViewPagers.add(new ModelViewPager(R.drawable.img_2, "Картинка 2"));
        modelViewPagers.add(new ModelViewPager(R.drawable.img_3, "Картинка 3"));

        AdapterViewPager adapterViewPager = new AdapterViewPager(getChildFragmentManager(), AdapterViewPager.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, modelViewPagers);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapterViewPager);

        button.setOnClickListener(view1 -> {
            if (!isShown) {
                button.setText(R.string.collapse_banner);
                viewPager.setVisibility(View.VISIBLE);
                pageIndicatorView.setVisibility(View.VISIBLE);
                isShown = true;
            } else {
                isShown = false;
                button.setText(R.string.show_banner);
                viewPager.setVisibility(View.GONE);
                pageIndicatorView.setVisibility(View.GONE);
            }
        });
    }
}
