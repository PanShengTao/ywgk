package cc.lecent.ywgk.reserve.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.viewmodel.ReserverViewMode;
import cc.lecent.ywgk.reserve.databinding.ReserveFragmentBinding;

public class ReserveFragment extends BaseFragment {

    private ReserveFragmentBinding binding;
    private ReserverViewMode viewModel;
    private List<String> spinnerData = new LinkedList<>(Arrays.asList("现场会见", "远程会见"));


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.reserve_fragment, container, false);
        viewModel=new ReserverViewMode(this);
//        viewModel = ViewModelProviders.of(this).get(ReserverViewMode.class);

        binding.setFtVM(viewModel);

        binding.setLifecycleOwner(this);

//        initData();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.niceSpinner.attachDataSource(spinnerData);
        binding. niceSpinner.setTextColor(Color.BLACK);
    }
}
