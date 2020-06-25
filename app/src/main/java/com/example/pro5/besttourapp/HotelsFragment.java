package com.example.pro5.besttourapp;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class HotelsFragment extends Fragment {

    private MyAdapter adapter;
    private List<ListItem> mylist;

    public HotelsFragment(){
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
        mylist = new ArrayList<>();
        adapter = new MyAdapter(getActivity(), mylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareView();

        return rootView;
    }

    private void prepareView() {
        int[] images = {R.drawable.motel1, R.drawable.hotel2, R.drawable.hotel3};

        mylist.add(new ListItem(getString(R.string.hotel1), images[0],getString(R.string.about_hotel1),getString(R.string.location_hotel1)));
        mylist.add(new ListItem(getString(R.string.hotel2), images[1],getString(R.string.about_hotel2),getString(R.string.location_hotel2)));

        mylist.add(new ListItem(getString(R.string.hotel3), images[2],getString(R.string.about_hotel3),getString(R.string.location_hotel3)));


        adapter.notifyDataSetChanged();
    }
}
