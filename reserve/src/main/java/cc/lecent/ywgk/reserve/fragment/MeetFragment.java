package cc.lecent.ywgk.reserve.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.databinding.MeetFragmentBinding;
import cc.lecent.ywgk.reserve.viewmodel.MeetModel;


/**
 * 会见预约
 */
public class MeetFragment extends BaseFragment {
    private MeetFragmentBinding binding;
    private MeetModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.meet_fragment, container,false);
        model = new MeetModel(this);
        binding.setViewModel(model);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
