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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.handh.lesson_6_shahin.ElectricityInfoItem;
import ru.handh.lesson_6_shahin.ItemDecoration;
import ru.handh.lesson_6_shahin.MainActivity;
import ru.handh.lesson_6_shahin.R;
import ru.handh.lesson_6_shahin.RowType;
import ru.handh.lesson_6_shahin.WatersInfoItem;
import ru.handh.lesson_6_shahin.adapters.AdapterIndications;

public class FragmentTwo extends Fragment {

    private List<RowType> dataSet;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_flash) {
                    Toast.makeText(getContext(), "click flash", Toast.LENGTH_SHORT).show();
            }
            return false;
        });

        toolbar.inflateMenu(R.menu.menu_item_two);

        dataSet = new ArrayList<>();
        dataSet.add(new WatersInfoItem(R.drawable.ic_water_cold, "Холодная вода", 54656553, "Необходимо подать показания до 25.03.18", true));
        dataSet.add(new WatersInfoItem(R.drawable.ic_water_hot, "Горячая вода", 54656553, "Необходимо подать показания до 25.03.18", true));
        dataSet.add(new ElectricityInfoItem(R.drawable.ic_electro_copy, "Электроэнергия", 54656553, "Показания сданы 16.02.18 и будут учтены при следующем расчете 25.02.18", false));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        AdapterIndications adapterIndications = new AdapterIndications(dataSet);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new ItemDecoration(8));
        recyclerView.setAdapter(adapterIndications);
    }
}
