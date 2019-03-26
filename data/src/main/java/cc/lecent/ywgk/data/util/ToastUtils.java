package cc.lecent.ywgk.data.util;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class ToastUtils {

    public static Toast toast;

    public static Toast showToast(Context context, String text) {
        if (context != null) {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            // 可以控制toast显示的位置
//            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();
        }
        return toast;
    }



}
