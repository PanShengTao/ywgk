package cc.lecent.ywgk.remittance.util;

import java.text.DecimalFormat;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-3-5 上午9:27
 * 更改时间：19-3-5
 * 版本号：1
 */
public class TimeUtil {
    public static String formatSeconds(int seconds) {
        String timeStr;
        int second = seconds % 60;
        int min = seconds / 60;
        if (seconds > 60) {

            if (min>=10){

                if (second>=10){
                    timeStr =min+":" +second;
                }else {
                    timeStr =min+":0"+second;
                }
            }else {

                if (second>=10){
                    timeStr ="0"+min+":" +second;
                }else {
                    timeStr ="0"+min+":0"+second;
                }
            }
        }else {
            if (second>=10){
                 timeStr ="00:" +second;
            }else {
                 timeStr ="00:" +"0"+second;
            }
        }
        return timeStr;
    }
}
