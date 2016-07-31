package com.shobhik.funstuff.screencheck;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        TextView dimensionsView = (TextView) findViewById(R.id.dimcheck);
        TextView sizeBucketView = (TextView) findViewById(R.id.reported_bucket);

        //Get computed measurements, i.e. density, screen-size bucket etc
        Configuration configuration = mContext.getResources().getConfiguration();
        int sizeMask = configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        int screenHeightDp = configuration.screenHeightDp;
        int screenWidthDp = configuration.screenWidthDp; //The current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        int smallestScreenWidthDp = configuration.smallestScreenWidthDp; //The smallest screen size an application will see in normal operation, corresponding to smallest screen width resource qualifier.
        String sizeValue = "";
        switch (sizeMask) {
            case 1:
                sizeValue = "Small";
                break;
            case 2:
                sizeValue = "Normal";
                break;
            case 3:
                sizeValue = "Large";
                break;
            case 4:
                sizeValue = "Extra Large";
                break;
            case 0:
                sizeValue = "Undefined!!";
                break;
            default:
                sizeValue = "Invalid!! " + sizeMask;
                break;
        }

        //Get device hardware measurements, i.e. resolution
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float pxHeight = displayMetrics.heightPixels;
        float pxWidth = displayMetrics.widthPixels;

        //Statistics are a pair of black text and blue number
        SpannableStringBuilder baseA = createStatistic("Usable screen size is ", screenWidthDp+"dp");
        SpannableStringBuilder baseB = createStatistic(" x ", screenHeightDp+"dp");
        SpannableStringBuilder usableA = createStatistic("Resolution is ", pxWidth+"px");
        SpannableStringBuilder usableB = createStatistic(" x ", pxHeight+"px");
        SpannableStringBuilder b = createStatistic("Smallest screen width is", ""+smallestScreenWidthDp);
        SpannableStringBuilder effective = addSpans(baseA, baseB, false);
        SpannableStringBuilder usable = addSpans(usableA, usableB, false);
        SpannableStringBuilder finalText = addSpans(effective, usable, true);
        dimensionsView.setText(finalText);

//        String previousFindings = sizeBucketView.getText().toString();
        String newFindings = "Size Bucket Check at Runtime: " + sizeValue;
        SpannableStringBuilder sizeBucketFindings = createStatistic("Size Bucket Check at Runtime: ", sizeValue + "!");
        sizeBucketView.setText(sizeBucketFindings);



        Button widthBtn = (Button) findViewById(R.id.width_button);
        Button heightBtn = (Button) findViewById(R.id.height_button);

        widthBtn.setOnClickListener(checkWidth);

        heightBtn.setOnClickListener(checkHeight);
    }

    private View.OnClickListener checkWidth = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DimensionCheckerActivity.class);
            intent.putExtra("dimension", Codes.WIDTH);
            startActivity(intent);
        }

    };

    private View.OnClickListener checkHeight = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DimensionCheckerActivity.class);
            intent.putExtra("dimension", Codes.HEIGHT);
            startActivity(intent);
        }

    };

    public SpannableStringBuilder addSpans(SpannableStringBuilder a, SpannableStringBuilder b, boolean newline) {
        SpannableStringBuilder fin = new SpannableStringBuilder("");
        fin.append(a);
        if(newline) {
            fin.append("\n");
        }
        fin.append(b);
        return fin;
    }
    public SpannableStringBuilder createStatistic(String text, String number) {
        SpannableStringBuilder beginning = new SpannableStringBuilder(text);
        SpannableStringBuilder end = new SpannableStringBuilder(number);
        end = makeBlueAndBold(end);
        SpannableStringBuilder fin = new SpannableStringBuilder("");
        fin.append(beginning);
        fin.append(end);
        return fin;
    }
    public SpannableStringBuilder makeBlueAndBold(SpannableStringBuilder subject) {
        int bluecolor = Color.parseColor("#035995");
        SpannableStringBuilder result = subject;
        result.setSpan(new StyleSpan(Typeface.BOLD), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        result.setSpan(new ForegroundColorSpan(bluecolor), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

}
