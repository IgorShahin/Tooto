package ru.handh.lesson_6_shahin.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import ru.handh.lesson_6_shahin.ModelViewPager;
import ru.handh.lesson_6_shahin.fragments.FragmentPageBanner;

public class AdapterViewPager extends FragmentPagerAdapter {

    private List<ModelViewPager> modelViewPagers;


    public AdapterViewPager(@NonNull FragmentManager fm, int behavior, List<ModelViewPager> modelViewPagers) {
        super(fm, behavior);
        this.modelViewPagers = modelViewPagers;
    }

    @Override
    public int getCount() {
        return modelViewPagers.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Log.d("adasd", "getItem");
        ModelViewPager modelViewPager = modelViewPagers.get(position);

        return FragmentPageBanner.newInstance(modelViewPager.getImageView(), modelViewPager.getTitle());
    }
}
