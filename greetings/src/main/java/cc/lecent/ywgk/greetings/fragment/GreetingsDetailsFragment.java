package cc.lecent.ywgk.greetings.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.model.GreetingsDetailsModel;
import cc.lecent.ywgk.greetings.databinding.FragmentGreetingsDetailsBinding;

/**
 * 亲情问候详情
 */
public class GreetingsDetailsFragment extends BaseFragment {
    private  GreetingsDetailsModel model;
    private  FragmentGreetingsDetailsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        model=new GreetingsDetailsModel(this);
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_greetings_details,container,false);
        binding.setViewModel(model);
        return binding.getRoot();
    }
}
