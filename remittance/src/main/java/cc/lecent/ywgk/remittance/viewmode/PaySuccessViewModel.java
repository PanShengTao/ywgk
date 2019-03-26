package cc.lecent.ywgk.remittance.viewmode;

import android.support.v4.app.Fragment;

import cc.lecent.ywgk.remittance.CommonOperations;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.fragment.PayDetailFragment;
import cc.lecent.ywgk.remittance.fragment.PayListFragment;
import cc.lecent.ywgk.remittance.fragment.PaySuccessFragment;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19 下午2:35
 * 更改时间：19-2-19
 * 版本号：1
 */
public class PaySuccessViewModel {

    private Fragment fragment;

    public PaySuccessViewModel(Fragment fragment) {
        this.fragment = fragment;

    }

    /**
     * 查看订单
     */
    public void showDetail(){
        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), PayListFragment.class.getCanonicalName(), R.id.remittance, null);
    }

    /**
     * 返回首页
     */
    public void backIndex(){

    }
}
