package cc.lecent.ywgk.greetings.util;

import android.text.TextUtils;

/**
 * 作者：RenJiaFen
 * 创建时间：2017/7/10 17:55.
 * 功能描述：检验字符串工具类
 */

public class StringUtils {

    /**
     * 判断字符串是否为空且字符串内容是否为空
     *
     * @param string 被检验的字符串
     * @return true：如果字符串不为空且内容不为空
     */
    public static boolean checkStr(String string) {
        return (null != string && !TextUtils.isEmpty(string));
    }


    public static boolean isEmptyString(String input) {
        if (input == null || "".equals(input))
            return true;
        return false;
    }
}
