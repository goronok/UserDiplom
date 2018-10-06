package com.example.goron.userdiplom.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.goron.userdiplom.Fragments.ActivityFragment;
import com.example.goron.userdiplom.R;

import java.util.List;

// Адаптер для главного меню

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.AdapterAdapterMenuVH> {


    List<String> listNameMenu;
    Context context;


    // Конструктор с параметрами принемает коллекцию строк с именами меню
    public AdapterMenu(List<String> listNameMenu, Context context) {
        this.listNameMenu = listNameMenu;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAdapterMenuVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_menu, viewGroup, false);
        return new AdapterAdapterMenuVH(view);
    }//AdapterAdapterMenuVH

    @Override
    public void onBindViewHolder(@NonNull AdapterAdapterMenuVH adapterAdapterMenuVH, int i) {

        final String name = listNameMenu.get(i);
        adapterAdapterMenuVH.nameMenu.setText(name);






        adapterAdapterMenuVH.layoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFragment(name);

            }
        });

    }//onBindViewHolder



    private void showFragment(String name) {

        switch (name){
            case "Активности": ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new ActivityFragment()).addToBackStack(null).commit();break;
        }

    }

    @Override
    public int getItemCount() {
        return listNameMenu.size();
    }

    public class AdapterAdapterMenuVH extends RecyclerView.ViewHolder {

        TextView nameMenu;
        LinearLayout layoutMenu;
        public AdapterAdapterMenuVH(@NonNull View itemView) {
            super(itemView);
            nameMenu = itemView.findViewById(R.id.nameMenu);
            layoutMenu = itemView.findViewById(R.id.layoutMenu);
        }
    }
}
