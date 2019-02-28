package com.scy.component.common.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
   private static Toast toast;

    public static void showToast(Context context, String msg){
        if (toast == null){
            toast = new Toast(context);
        }
        toast.setText(msg);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
