package cc.lecent.ywgk.reserve.fragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.viewmodel.RecordViewMode;
import cc.lecent.ywgk.reserve.databinding.RecordFragmentBinding;

@SuppressLint("ValidFragment")
public class RecordFragment extends BaseFragment {


    private RecordViewMode viewMode;
    private RecordFragmentBinding binding;
    private  int pageIndex=0;
    public  RecordFragment(int pageIndex){
        this.pageIndex=pageIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.record_fragment, container, false);
        viewMode=new RecordViewMode(this);
//        viewMode = ViewModelProviders.of(this).get(RecordViewMode.class);
        binding.setViewModel(viewMode);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
