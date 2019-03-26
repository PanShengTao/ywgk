package cc.lecent.ywgk.remittance.viewmode;

import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.remittance.CommonOperations;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.RemittanceActivity;
import cc.lecent.ywgk.remittance.fragment.PayListFragment;
import cc.lecent.ywgk.remittance.fragment.RemittanceFragment;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19 上午10:26
 * 更改时间：19-2-19
 * 版本号：1
 */
public class IndexRemittanceViewModel extends BaseViewModel {
    public ObservableField<List<String>> listurlStr = new ObservableField<>();
    private Fragment fragment;

    public IndexRemittanceViewModel(Fragment fragment) {
        this.fragment = fragment;
        initView();

    }



    private void initView() {
        List<String> list = new ArrayList<>();
        list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
        list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
        listurlStr.set(list);
    }

    /**
     * 立即汇款按钮
     */
    public void remittanceNow(){
//        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), RemittanceFragment.class.getCanonicalName(), R.id.remittance, null);
        Intent intent=new Intent(fragment.getActivity(),RemittanceActivity.class);
        intent.putExtra("toPaylist","false");
        fragment.startActivity(intent);
    }

    /**
     * 查看查看汇款记录
     */
    public  void onRecord(){
//        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), PayListFragment.class.getCanonicalName(), R.id.remittance, null);
        Intent intent=new Intent(fragment.getActivity(),RemittanceActivity.class);
        intent.putExtra("toPaylist","true");
        fragment.startActivity(intent);
    }
}
