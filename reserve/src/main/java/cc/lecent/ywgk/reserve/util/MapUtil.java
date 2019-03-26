package cc.lecent.ywgk.reserve.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-20 下午12:00
 * 更改时间：19-2-20
 * 版本号：1
 */
public class MapUtil {
    private static final String BAIDU_MAP = "com.baidu.BaiduMap";//百度地图
    private static final String GAODE_MAP = "com.autonavi.minimap";//高德地图
    private static final String TENCENT_MAP = "com.autonavi.minimap";//腾讯地图


    /**选择应用商店下载导航应用
     * @param packageName
     */
    public void installMap(Context context,String packageName) {
//        Toast.makeText(context, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public static boolean isAvilible(Context context,String packageName) {
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }


    /**
     * 启动选择导航应用
     * @param address 目标地址
     */
    public static void openAllMap(Context context,String address) {
        //根据地名打开地图应用显示，字符串要记得编码！！
        String encodedName = Uri.encode(address);
        Uri locationUri = Uri.parse("geo:0,0?q=" + encodedName);
        //根据经纬度打开地图显示，?z=11表示缩放级别，范围为1-23
//        Uri locationUri = Uri.parse("geo:26.5789070770,106.7170012064?z=11");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Intent chooser = Intent.createChooser(intent, "请选择地图软件");
        intent.setData(locationUri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(chooser);
        }
    }

    /**
     * 浏览器打开导航
     * @param purpose_lon
     * @param purpose_lat
     * @param location_address
     */
    public static void openWebPage(Context context,String purpose_lon, String purpose_lat, String location_address) {
        //最好写上http协议
        String url = "http://uri.amap.com/navigation?to=" + purpose_lon + "," + purpose_lat + "," +
                location_address + "&mode=car&policy=1&src=mypage&coordinate=gaode&callnative=0";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    /**
     * 检查是否安装地图导航应用
     *
     * @return
     */
    public static boolean checkappMap(Context context) {
        if (isAvilible(context,BAIDU_MAP)) {
            return true;
        }
        if (isAvilible(context,GAODE_MAP)) {
            return true;
        }
        if (isAvilible(context,TENCENT_MAP)) {
            return true;
        }
        return false;
    }
}
