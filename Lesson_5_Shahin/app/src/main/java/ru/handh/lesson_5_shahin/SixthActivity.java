package ru.handh.lesson_5_shahin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.handh.lesson_5_shahin.adapter.CategoriesAdapter;

public class SixthActivity extends AppCompatActivity {

    @BindView(R.id.imageViewToolbar)
    ImageView imageViewToolbar;

    @BindView(R.id.recyclerAdvertising)
    RecyclerView recyclerAdvertising;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private ArrayList<AdvertisingItem> listAdvertising;

    public static Intent createInstance(Context context) {
        return new Intent(context, SixthActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        ButterKnife.bind(this);

        listAdvertising = new ArrayList<>();

        Glide
                .with(SixthActivity.this)
                .load("https://novostroev.ru/upload/medialibrary/5a1/bel-noch-new_mQIu0OC.jpg")
                .into(imageViewToolbar);

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getCategoriesAdvertising());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SixthActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerAdvertising.setLayoutManager(linearLayoutManager);
        recyclerAdvertising.addItemDecoration(new ItemDecoration(20));
        categoriesAdapter.setOnClickListener(text -> Snackbar.make(coordinatorLayout, text, Snackbar.LENGTH_SHORT).show());
        recyclerAdvertising.setAdapter(categoriesAdapter);
    }

    public ArrayList<AdvertisingItem> getCategoriesAdvertising() {
        listAdvertising.add(new AdvertisingItem("https://king-pyshka.ru/images/news/pryazhenci.jpg", "Царь пышка", "Скидка 10% на выпечку \n" +
                "по коду", "Лермонтовский пр, 52, МО №1"));
        listAdvertising.add(new AdvertisingItem("https://www.diplomatman.ru/upload/iblock/917/917c44f199a71408f49d3522f7fda5aa.jpg", "Химчистка «МАЙ?»", "Скидка 5% на чистку пальто", "Лермонтовский пр, 48"));
        listAdvertising.add(new AdvertisingItem("https://i.pinimg.com/originals/4b/16/f1/4b16f13816b4dc84693f4c364591faca.jpg", "Шаверма У Ашота", "При покупке шавермы, \n" +
                "фалафель бесплатно", "Лермонтовский пр, 52, МО №1"));

        return listAdvertising;
    }
}
