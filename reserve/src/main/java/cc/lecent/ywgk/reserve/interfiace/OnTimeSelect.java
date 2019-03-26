package cc.lecent.ywgk.reserve.interfiace;

/**
 * 文件描述：选择时间回调接口
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-3-4 下午3:32
 * 更改时间：19-3-4
 * 版本号：1
 */
public interface OnTimeSelect {
    /**
     * @param date 时间年月日
     * @param time 时间 时分秒
     */
    void onSelect(String date,String time);
}
