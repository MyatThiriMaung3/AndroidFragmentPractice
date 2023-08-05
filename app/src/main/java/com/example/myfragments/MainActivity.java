package com.example.myfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    TextView tvData;
    String[] descriptions;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tvData);

        descriptions = getResources().getStringArray(R.array.descriptions);

        if (findViewById(R.id.layoutLandscape) != null) {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        if (findViewById(R.id.layoutPortrait) != null) {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvData.setText(descriptions[index]);

        if (findViewById(R.id.layoutPortrait) != null) {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}