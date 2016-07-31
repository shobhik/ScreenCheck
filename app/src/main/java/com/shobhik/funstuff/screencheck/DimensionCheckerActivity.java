package com.shobhik.funstuff.screencheck;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.shobhik.funstuff.screencheck.utils.Codes;

public class DimensionCheckerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimension_checker);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Dimensions");

        Intent intent = getIntent();
        int dim = intent.getIntExtra("dimension", 0);
        if(dim == Codes.HEIGHT) {
            actionBar.setTitle("Height Checker");
            setContentView(R.layout.height_checker);
        } else {
            actionBar.setTitle("Width Checker");
            setContentView(R.layout.width_checker);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }

        return true;
    }

}
