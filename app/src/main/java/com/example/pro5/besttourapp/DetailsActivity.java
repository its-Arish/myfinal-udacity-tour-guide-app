package com.example.pro5.besttourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ListItem myitem;
    TextView detailTextView;
    Button locateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent in = getIntent();
        myitem = (ListItem) in.getSerializableExtra("ItemClicked");

        detailTextView = findViewById(R.id.details);
        locateButton = findViewById(R.id.locate_button);
        ImageView imageView = findViewById(R.id.collapseimageview);
        Toolbar toolbar = findViewById(R.id.detailscreentoolbar);
        detailTextView.setText(myitem.getDescription());
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsetoolbar);
        collapsingToolbarLayout.setTitle(myitem.getName());
        Glide.with(this).load(myitem.getImageID()).into(imageView);

        locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(myitem.getLocationGeo());
                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                in.setPackage("com.google.android.apps.maps");
                startActivity(in);
            }
        });
    }


}
