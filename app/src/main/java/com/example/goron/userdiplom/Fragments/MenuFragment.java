package com.example.goron.userdiplom.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goron.userdiplom.R;


public class MenuFragment extends Fragment {


    RecyclerView recyclerMenu;
    AdapterMenu adapterMenu;

    public MenuFragment() {
        // Required empty public constructor
    }


    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

       // recyclerMenu = view.findViewById(R.id.recyclerMenu);
       // recyclerMenu.setLayoutManager(new LinearLayoutManager(getActivity()));




       TextView header =  getActivity().findViewById(R.id.textHeader);
       header.setText("Меню /n Добро пожаловать /n Donbass Extreme Fest ");


        return view;
    }






}
