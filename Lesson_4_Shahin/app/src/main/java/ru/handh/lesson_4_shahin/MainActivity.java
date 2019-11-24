package ru.handh.lesson_4_shahin;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    final static int GRID_SPAN_COUNT_ONE = 1;
    final static int GRID_SPAN_COUNT_TWO = 2;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerBaseInfo)
    RecyclerView recyclerBaseInfo;

    @BindView(R.id.linerLayoutMain)
    LinearLayout linearLayoutMain;

    private ArrayList<DetailInfoItem> detailInfoItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        detailInfoItemList = new ArrayList<>();

        toolbar.setNavigationOnClickListener(view -> this.finish());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Open info")
                .setCancelable(false)
                .setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.cancel())
                .create();

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menuInfo: {
                    builder.show();
                    break;
                }
                case R.id.menuHome: {
                    Toast.makeText(MainActivity.this, "click Home", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            return false;
        });

        toolbar.inflateMenu(R.menu.menu_main);

        recyclerBaseInfo.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, GRID_SPAN_COUNT_TWO);
        recyclerBaseInfo.setLayoutManager(gridLayoutManager);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getCategoriesDetail(), this);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (categoriesAdapter.getItemViewType(position)) {
                    case DetailInfoItem.LINE_TYPE: {
                        return GRID_SPAN_COUNT_TWO;
                    }
                    case DetailInfoItem.GRID_TYPE: {
                        return GRID_SPAN_COUNT_ONE;
                    }
                    default:
                        return -1;
                }
            }
        });
        recyclerBaseInfo.addItemDecoration(new CharacterItemDecoration(25));
        categoriesAdapter.setOnClickListener(text -> Snackbar.make(linearLayoutMain, text, Snackbar.LENGTH_SHORT).show());
        recyclerBaseInfo.setAdapter(categoriesAdapter);
    }

    public ArrayList<DetailInfoItem> getCategoriesDetail() {
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_bill), getString(R.string.title_receipt), getString(R.string.info_receipt), true));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_counter), getString(R.string.title_meter), getString(R.string.info_meter), true));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_installment), getString(R.string.title_installment_plan), getString(R.string.info_installment_plan), false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_insurance), getString(R.string.title_insurance), getString(R.string.info_insurance), false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_tv), getString(R.string.title_internet_and_tv), getString(R.string.info_internet_and_tv), false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.GRID_TYPE, getResources().getDrawable(R.drawable.ic_homephone), getString(R.string.title_intercom), getString(R.string.info_intercom), false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.LINE_TYPE, getResources().getDrawable(R.drawable.ic_guard), getString(R.string.title_security), getString(R.string.info_security), false));

        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.LINE_TYPE, getResources().getDrawable(R.drawable.ic_uk_contacts), getString(R.string.title_contacts), null, false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.LINE_TYPE, getResources().getDrawable(R.drawable.ic_request), getString(R.string.title_my_application), null, false));
        detailInfoItemList.add(new DetailInfoItem(DetailInfoItem.LINE_TYPE, getResources().getDrawable(R.drawable.ic_about), getString(R.string.title_memo), null, false));

        return detailInfoItemList;
    }
}
