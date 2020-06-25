package com.example.pro5.besttourapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

// Will contain famous places in Places to Visit in Pokhara
public class PlacesFragment extends Fragment {

    private MyAdapter adapter;
    private List<ListItem> list;

    public PlacesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        adapter = new MyAdapter(getActivity(), list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareView();
        return rootView;
    }

    private void prepareView() {
        int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
        list.add(new ListItem(getString(R.string.place1), images[0],getString(R.string.about_place1),getString(R.string.location_place1)));
        list.add(new ListItem(getString(R.string.place2), images[1],getString(R.string.about_place2),getString(R.string.location_place2)));
        list.add(new ListItem(getString(R.string.place3), images[2],getString(R.string.about_place3),getString(R.string.location_place3)));
        adapter.notifyDataSetChanged();
    }
}