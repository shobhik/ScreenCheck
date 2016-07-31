package com.shobhik.funstuff.screencheck.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shobhik.funstuff.screencheck.R;

/**
 * Created by brenthamby on 9/25/13.
 */
public class Toaster {

    public static final int SHORT = Toast.LENGTH_SHORT;
    public static final int LONG = Toast.LENGTH_LONG;

    public static final int FONT_SIZE = 14;
    public static final int GRAVITY = Gravity.BOTTOM;

    public static void pop(Context ctx, String txt) {
        pop(ctx, txt, SHORT, FONT_SIZE, GRAVITY);
    }

    public static void pop(Context ctx, String txt, int duration) {
        pop(ctx, txt, duration, FONT_SIZE, GRAVITY);
    }

    public static void pop(Context ctx, String txt, int duration, int fontSize) {
        pop(ctx, txt, duration, fontSize, GRAVITY);
    }

    public static void pop(Context ctx, String txt, int DURATION, int fontSize, int gravity) {
        Activity act = (Activity) ctx;
        LayoutInflater inflater = act.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) act.findViewById(R.id.toast_layout_root));
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(txt);
        Toast toast = new Toast(ctx.getApplicationContext());
        toast.setGravity(gravity, 0, 50);
        text.setTextSize(fontSize);
        toast.setDuration(DURATION);
        toast.setView(layout);
        toast.show();
    }
}
