package cc.lecent.ywgk.ca.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiongwenjie
 */
public final class StringUtil {

    private static SimpleDateFormat FORMAT;
    private static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e',
            'f'};

    static {
        FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    }

    /**
     * @param date
     * @return
     */
    public static String getFormatedDate(Date date) {
        if (date != null) {
            return FORMAT.format(date);
        }
        return "";
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\" +
                    ".)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * @param src
     * @return
     */
    public static boolean isMobilePhoneNum(CharSequence src) {
        Pattern regex = Pattern.compile("^\\d{11}$");
        Matcher matcher = regex.matcher(src);
        return matcher.matches();
    }


    /**
     * @param account
     * @return
     */
    public static boolean checkAccount(String account) {
        Pattern regex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{5,20}");
        Matcher matcher = regex.matcher(account);
        return matcher.matches();

    }

    /**
     * @param nickName
     * @return
     */
    public static boolean checkNickName(String nickName) {
        Pattern regex = Pattern.compile("(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$");
        Matcher matcher = regex.matcher(nickName);
        return matcher.matches();
    }

    /**
     * 验证用户密码设置
     *
     * @param password
     * @return
     */
    public static boolean checkPassWord(String password) {
        boolean flag = false;
        try {
            String check = "((?=.*\\d)(?=.*\\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{6,15}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(password);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * @param input
     * @return
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * MD5加密
     * @param src 要加密的字符
     */
    public static String calculateMd5(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte tmp[] = md.digest();
            char strs[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                strs[k++] = hexDigits[byte0 >>> 4 & 0xf];
                strs[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(strs);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return
     * 得到图片原始宽高
     */

    public static int[] getImageWidthHeight(String path){
        BitmapFactory.Options options = new BitmapFactory.Options();

        /**
         * 最关键在此，把options.inJustDecodeBounds = true;
         * 这里再decodeFile()，返回的bitmap为空，但此时调用options.outHeight时，已经包含了图片的高了
         */
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options); // 此时返回的bitmap为null
        /**
         *options.outHeight为原始图片的高
         */
        return new int[]{options.outWidth,options.outHeight};
    }





    /**
     * @param src
     * @return
     */
    public static boolean notEmpty(CharSequence src) {
        return !TextUtils.isEmpty(src);
    }

    /**
     * 按照宽获取图片单边固定缩略Url处理后缀,如果指定的目标缩略图大于原图则不进行处理。
     *
     * @param context
     * @param widthDpValue
     * @return
     */
//    public static String getImgDealSuffixByWidth(Context context, int widthDpValue) {
//        int px = DeviceUtil.dp2px(context, widthDpValue);
//        // see :
//        // https://help.aliyun.com/document_detail/oss/oss-img-guide/resize/resize.html?spm=5176
//        // .docoss/oss-img-guide/resize/resize.6.402.FY9gbe
//        return "@" + px + "w" + "_1l";
//    }

    /**
     * 按照高获取图片单边固定缩略Url处理后缀,如果指定的目标缩略图大于原图则不进行处理。
     *
     * @param context
     * @param heightDpValue
     * @return
     */
//    public static String getImgDealSuffixByHeight(Context context, int heightDpValue) {
//        int px = DeviceUtil.dp2px(context, heightDpValue);
//        // see :
//        // https://help.aliyun.com/document_detail/oss/oss-img-guide/resize/resize.html?spm=5176
//        // .docoss/oss-img-guide/resize/resize.6.402.FY9gbe
//        return "@" + px + "h" + "_1l";
//    }

    /**
     * 按照宽高获取图片单边固定缩略Url处理后缀,如果指定的目标缩略图大于原图则不进行处理。
     *
     * @param context
     * @param widthDpValue
     * @param heightDpValue
     * @return
     */
//    public static String getImgDealSuffix(Context context, int widthDpValue, int heightDpValue) {
//        int width = DeviceUtil.dp2px(context, widthDpValue);
//        int height = DeviceUtil.dp2px(context, heightDpValue);
//        return "@" + width + "w_" + height + "h" + "_1l";
//    }


    /**
     * @param money
     * @return
     */
    public static String formatMoneyRMB(BigDecimal money) {
        DecimalFormat myformat = new DecimalFormat("0.00");
        return "¥ " + myformat.format(money);
    }

    /**
     * 保留目标数据对应的小数位数
     * @param target
     * @param decimalDigits
     * @return
     */
    public static String round(BigDecimal target,String decimalDigits){
        DecimalFormat myformat = new DecimalFormat(decimalDigits);
        return myformat.format(target);
    }

    /**
     * 字符串替换
     *
     * @param target      目标字符串
     * @param orignal     要替换的目标
     * @param replacement 替换后的字符串
     * @return
     */
    public static CharSequence replece(CharSequence target, CharSequence orignal, CharSequence
            replacement) {
        if (target == null) {
            return "";
        }
        return target.toString().replace(orignal, replacement);
    }

    /**
     * 从字符串中提取数字
     *
     * @param target
     * @return 如果字符串为空或者没有数字返回 null
     */
    public static String extractDigital(String target) {
        if (TextUtils.isEmpty(target)) {
            return null;
        }
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(target);
        return matcher.replaceAll("").trim();
    }

    /**
     * 把服务器返回的类似价格格式("280.00,CNY")，提取数字
     *
     * @param target
     * @return
     */
    public static String getMoney(String target) {
        if (TextUtils.isEmpty(target)) {
            return "";
        }
        return target.replace(",", "").replace("CNY", "").trim();
    }

    /**
     * 格式日期
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String format2 = format.format(date);
        return format2;
    }

    /**
     * 截取时间
     */
    public static String subDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String format2 = format.format(date);
        String dateOnly = format2.substring(0, 11);
        return dateOnly;
    }

    public static String subTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String format2 = format.format(date);
        String timeOnly = format2.substring(5, 16);
        return timeOnly;
    }



    /**
     * 获取随机32uuid并aes加密
     * @return
     */
//    public static String get32EncrypteUuId(){
//        UUID randomUUID = UUID.randomUUID();
//        String uuidStr = randomUUID.toString().replaceAll("-", "");
//        String encryptuuId = EncryptUtil.encrypt(uuidStr);
//        return encryptuuId;
//    }
}
