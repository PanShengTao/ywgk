package cc.lecent.ywgk.remittance.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.databinding.PaylistFragmentBinding;
import cc.lecent.ywgk.remittance.viewmode.PayListViewModel;

public class PayListFragment extends BaseFragment {

    private PaylistFragmentBinding binding;
    private PayListViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.paylist_fragment, container, false);

        viewModel=new PayListViewModel(this);

        binding.setViewModel(viewModel);

        binding.setLifecycleOwner(this);

//        initData();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
