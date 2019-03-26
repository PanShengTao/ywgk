package cc.lecent.ywgk.meet.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.meet.R;
import cc.lecent.ywgk.meet.databinding.FragmentRemoteMeetBinding;
import cc.lecent.ywgk.meet.model.RemoteMeetModel;


/**
 * 远程会见
 */
public class RemoteMeetFragment extends BaseFragment {

    public static RemoteMeetFragment newInstance(){

        return new RemoteMeetFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RemoteMeetModel model=new RemoteMeetModel(this);
        FragmentRemoteMeetBinding binding =DataBindingUtil.inflate(inflater, R.layout.fragment_remote_meet,container,false);
        binding.setViewModel(model);
        return binding.getRoot();
    }
}
