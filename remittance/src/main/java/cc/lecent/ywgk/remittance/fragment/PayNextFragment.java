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
import cc.lecent.ywgk.remittance.databinding.PaynextFragmentBinding;
import cc.lecent.ywgk.remittance.viewmode.PayNextViewModel;

public class PayNextFragment extends BaseFragment {

    private PaynextFragmentBinding binding;
    private PayNextViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.paynext_fragment, container, false);

        viewModel = ViewModelProviders.of(this).get(PayNextViewModel.class);
        viewModel.setFragment(this, this.getArguments());

        binding.setViewmodel(viewModel);
        getLifecycle().addObserver(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    View view;
    }

}
