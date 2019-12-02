package ru.handh.lesson_6_shahin.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.handh.lesson_6_shahin.R;

public class FragmentPageBanner extends Fragment {

    public static final String ARG_IMAGE_BANNER = "bannerImg";
    public static final String ARG_TITLE_BANNER = "bannerTitle";

    private Context context;

    public static FragmentPageBanner newInstance(int imagePager, String titlePager) {
        FragmentPageBanner fragment = new FragmentPageBanner();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_BANNER, imagePager);
        args.putString(ARG_TITLE_BANNER, titlePager);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnClickListener){
            this.context = context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle extras = getArguments();

        if(extras != null){
            TextView bannerTitle = view.findViewById(R.id.textViewTitlePager);
            ImageView bannerImage = view.findViewById(R.id.imageViewImagePager);
            LinearLayout linearPager = view.findViewById(R.id.linearPager);

            bannerTitle.setText(extras.getString(ARG_TITLE_BANNER));
            bannerImage.setImageResource(extras.getInt(ARG_IMAGE_BANNER));

            if (context != null) {
                linearPager.setOnClickListener(view1 -> ((OnClickListener) context).onItemClick(extras.getString(ARG_TITLE_BANNER)));
            }
        }
    }

    public interface OnClickListener {
        void onItemClick(String text);
    }
}
