package com.ermile.first;

import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ColoredToast {
    private static final int RED = 0xfff44336;
    private static final int BLUE = 0xff2195f3;
    private static final int ORANGE = 0xffffc107;
    private static final int GREEN = 0xff4caf50;
    private static final int IC_ALERT = R.drawable.ic_alert;
    private static final int IC_INFO= R.drawable.ic_info;
    private static final int IC_WARNING = R.drawable.ic_warning;
    private static final int IC_SUCCESS = R.drawable.ic_success;
    public static final int LENGTH_LONG  = 1;
    public static final int LENGTH_SHORT = 0;
    private View view;
    private Toast toast;
    private Context context;
    public ColoredToast(Context context){
        this.context = context;
        this.toast = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.view = inflater.inflate(R.layout.colored_toast_layout, null);
        toast.setView(view);

    }

    public View getView(){
        return view;
    }
    public void setText(String text){
        if (view == null)
            return;
        ((TextView) view.findViewById(R.id.toast_msg)).setText(text);
    }
    public void setIcon(int iconResId){
        if (view == null)
            return;
        ((ImageView) view.findViewById(R.id.toast_icon)).setImageResource(iconResId);
    }
    public Toast getToast(){
        return toast;
    }
    private static View getToastView(Toast toast){
        return (toast == null) ? null : toast.getView();
    }
    private static Toast colorToast(Toast toast, int colorId){
        View layout = getToastView(toast);
        if (layout != null) {
            layout.setBackgroundColor(colorId);
        }
        return toast;
    }


    public static Toast alert(Context context, String text, int duration){
        ColoredToast coloredToast = new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        coloredToast.setIcon(IC_ALERT);
        coloredToast.getView().setBackgroundColor(RED);
        return coloredToast.getToast();
    }

    public static Toast info(Context context, String text, int duration){
        ColoredToast coloredToast = new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        coloredToast.setIcon(IC_INFO);
        coloredToast.getView().setBackgroundColor(BLUE);
        return coloredToast.getToast();
    }
    public static Toast warning(Context context, String text, int duration){
        ColoredToast coloredToast = new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        coloredToast.setIcon(IC_WARNING);
        coloredToast.getView().setBackgroundColor(ORANGE);
        return coloredToast.getToast();
    }
    public static Toast success(Context context, String text, int duration){
        ColoredToast coloredToast = new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        coloredToast.setIcon(IC_SUCCESS);
        coloredToast.getView().setBackgroundColor(GREEN);
        return coloredToast.getToast();
    }

//    public static Toast alert(Toast toast){
//
//        return colorToast(toast, RED);
//    }
//    public static Toast success(Toast toast){
//        return colorToast(toast, GREEN);
//    }
//    public static Toast warning(Toast toast){
//        return colorToast(toast, BLUE);
//    }
//    public static Toast info(Toast toast){
//        return colorToast(toast, ORANGE);
//    }
    public static Toast imageToast(Context context, int imageRes, int duration){
        Toast toast = new Toast(context);
        ImageView iv = new ImageView(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(400, 400));
        layout.addView(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.requestLayout();
        iv.setLayoutParams(layout.getLayoutParams());
        iv.setImageResource(imageRes);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(duration);
        return toast;
    }
}
