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
import cc.lecent.ywgk.remittance.databinding.IndexRenittanceFragmentBinding;
import cc.lecent.ywgk.remittance.viewmode.IndexRemittanceViewModel;

public class IndexRemittanceFragment extends BaseFragment {

    private IndexRenittanceFragmentBinding binding;
    private IndexRemittanceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.index_renittance_fragment, container, false);

        viewModel = new IndexRemittanceViewModel(this);
        binding.setModel(viewModel);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
