package cc.lecent.ywgk.remittance.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.databinding.PaydetailFragmentBinding;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19
 * 更改时间：19-2-19
 * 版本号：1
 */
public class PayDetailFragment extends BaseFragment {
    private PaydetailFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=DataBindingUtil.inflate(inflater, R.layout.paydetail_fragment,container,false);

        binding.setLifecycleOwner(this);

        return binding.getRoot();

    }
}
