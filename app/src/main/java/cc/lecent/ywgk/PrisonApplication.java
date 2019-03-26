package cc.lecent.ywgk;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.lecent.bbc.base.BaseApplication;
import cc.lecent.bbc.utils.Utils;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-1-10
 *     desc   :
 * </pre>
 */
public class PrisonApplication extends BaseApplication {

    @Override
    public void init() {

        // 初始化路由
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        // 工具初始化
        Utils.init(this);


    }



}
