package com.example.pro5.besttourapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private MyAdapter adapter;
    private List<ListItem> mylist;

    public AboutFragment() {
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
        adapter = new MyAdapter(getActivity(),mylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareList();

        return rootView;
    }

    private void prepareList() {
        int[] images = {R.drawable.airpot,
                R.drawable.bus, R.drawable.pokhara};
        mylist.add(new ListItem(getString(R.string.airport), images[0],getString(R.string.airpot_info),getString(R.string.airpot_location)));
        mylist.add(new ListItem(getString(R.string.bustand),images[1],getString(R.string.bustand_info), getString(R.string.airpot_location)));
        mylist.add(new ListItem(getString(R.string.pokhara_itself), images[2], getString(R.string.pokhara_info), getString(R.string.airpot_location)));

        adapter.notifyDataSetChanged();
    }

}

