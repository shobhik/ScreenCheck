package com.shobhik.funstuff.screencheck;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.shobhik.funstuff.screencheck.utils.StringFormatting;
import com.shobhik.funstuff.screencheck.utils.Toaster;

public class DashboardTestActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;

    TextView ta1;
    TextView ta2;
    TextView tb1;
    TextView tb2;
    TextView tb3;
    TextView tc1;
    TextView tc2;
    TextView tc3;
    TextView tc4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_dashboard_test);

        TextView stats = (TextView) findViewById(R.id.text_stats);
        stats.setText(composeOverallStats());

        ta1 = (TextView) findViewById(R.id.dash_row1_item1);
        ta2 = (TextView) findViewById(R.id.dash_row1_item2);
        tb1 = (TextView) findViewById(R.id.dash_row2_item1);
        tb2 = (TextView) findViewById(R.id.dash_row2_item2);
        tb3 = (TextView) findViewById(R.id.dash_row2_item3);
        tc1 = (TextView) findViewById(R.id.dash_row3_item1);
        tc2 = (TextView) findViewById(R.id.dash_row3_item2);
        tc3 = (TextView) findViewById(R.id.dash_row3_item3);
        tc4 = (TextView) findViewById(R.id.dash_row3_item4);

        ta1.setOnClickListener(this);
        ta2.setOnClickListener(this);
        tb1.setOnClickListener(this);
        tb2.setOnClickListener(this);
        tb3.setOnClickListener(this);
        tc1.setOnClickListener(this);
        tc2.setOnClickListener(this);
        tc3.setOnClickListener(this);
        tc4.setOnClickListener(this);

        int hA = ta1.getHeight();
        int wA = ta1.getWidth();
        ta1.setText(wA + " x " + hA + "px");

        //Observe and modify first row
        ViewTreeObserver observer = ta1.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                int hA= ta1.getHeight();
                int wA = ta1.getWidth();
                ta1.setText(computeDims(wA, " x "));
                ta2.setText(computeDims(wA, " x "));
                ViewGroup.LayoutParams params = ta1.getLayoutParams();
                params.height = wA;
                ta1.setLayoutParams(params);
                ta2.setLayoutParams(params);
                ta1.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
            }
        });


        //Observe and modify second row
        ViewTreeObserver observer2 = tb1.getViewTreeObserver();
        observer2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                int hA= tb1.getHeight();
                int wA = tb1.getWidth();
                tb1.setText(computeDims(wA, "\nx\n"));
                tb2.setText(computeDims(wA, "\nx\n"));
                tb3.setText(computeDims(wA, "\nx\n"));
                ViewGroup.LayoutParams params = tb1.getLayoutParams();
                params.height = wA;
                tb1.setLayoutParams(params);
                tb2.setLayoutParams(params);
                tb3.setLayoutParams(params);
                tb1.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
            }
        });

        //Observe and modify second row
        ViewTreeObserver observer3 = tc1.getViewTreeObserver();
        observer3.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                int hA= tc1.getHeight();
                int wA = tc1.getWidth();
                tc1.setText(computeDims(wA, "\nx\n"));
                tc2.setText(computeDims(wA, "\nx\n"));
                tc3.setText(computeDims(wA, "\nx\n"));
                tc4.setText(computeDims(wA, "\nx\n"));
                ViewGroup.LayoutParams params = tc1.getLayoutParams();
                params.height = wA;
                tc1.setLayoutParams(params);
                tc2.setLayoutParams(params);
                tc3.setLayoutParams(params);
                tc4.setLayoutParams(params);
                tc1.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dash, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_main_activity) {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public SpannableStringBuilder computeDims(int number, String divider) {
        SpannableStringBuilder baseWA = StringFormatting.generateBlueAndBold(""+number);
        SpannableStringBuilder longDims = StringFormatting.generateBlueAndBold(""+number);
        longDims.append(divider);
        longDims.append(baseWA);
        return longDims;
    }

    public SpannableStringBuilder composeOverallStats() {
        SpannableStringBuilder starter = new SpannableStringBuilder("The main container padding is ");
        SpannableStringBuilder bigpadding = StringFormatting.generateBlueAndBold("16dp");
        SpannableStringBuilder intmargins = StringFormatting.generateBlueAndBold("10dp");
        starter.append(bigpadding);
        starter.append("\n");
        starter.append("Each button has a margin of ");
        starter.append(intmargins);
        return starter;
    }

    @Override
    public void onClick(View v) {
        Toaster.pop(mContext, "Clicked item!");
    }
}
