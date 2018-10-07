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

    private String name, password;



    public MenuFragment() {
        // Required empty public constructor
    }


    public static MenuFragment newInstance(String name, String password) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("password", password);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            password = getArguments().getString("password");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);



       ((TextView)getActivity().findViewById(R.id.textHeader)).setText("Меню");
       ((TextView)getActivity().findViewById(R.id.textFooter)).setText(name);

        return view;
    }






}
