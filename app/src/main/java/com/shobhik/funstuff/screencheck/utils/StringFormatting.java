package com.shobhik.funstuff.screencheck.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/**
 * Created by Shobhik Ghosh on 7/31/2016.
 */
public class StringFormatting {
    public static SpannableStringBuilder addSpans(SpannableStringBuilder a, SpannableStringBuilder b, boolean newline) {
        SpannableStringBuilder fin = new SpannableStringBuilder("");
        fin.append(a);
        if(newline) {
            fin.append("\n");
        }
        fin.append(b);
        return fin;
    }
    public static SpannableStringBuilder createStatistic(String text, String number) {
        SpannableStringBuilder beginning = new SpannableStringBuilder(text);
        SpannableStringBuilder end = new SpannableStringBuilder(number);
        end = makeBlueAndBold(end);
        SpannableStringBuilder fin = new SpannableStringBuilder("");
        fin.append(beginning);
        fin.append(end);
        return fin;
    }
    public static SpannableStringBuilder makeBlueAndBold(SpannableStringBuilder subject) {
        int bluecolor = Color.parseColor("#035995");
        SpannableStringBuilder result = subject;
        result.setSpan(new StyleSpan(Typeface.BOLD), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        result.setSpan(new ForegroundColorSpan(bluecolor), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

    public static SpannableStringBuilder generateBlueAndBold(String subject) {
        int bluecolor = Color.parseColor("#035995");
        SpannableStringBuilder result = new SpannableStringBuilder(subject);
        result.setSpan(new StyleSpan(Typeface.BOLD), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        result.setSpan(new ForegroundColorSpan(bluecolor), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

}
