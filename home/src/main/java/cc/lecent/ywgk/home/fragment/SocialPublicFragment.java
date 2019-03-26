package cc.lecent.ywgk.home.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.home.R;
import cc.lecent.ywgk.home.databinding.FragmentSocialPublicBinding;
import cc.lecent.ywgk.home.model.SocialPublicModel;

public class SocialPublicFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SocialPublicModel model =new SocialPublicModel(this);
        FragmentSocialPublicBinding binding=DataBindingUtil.inflate(inflater, R.layout.fragment_social_public,container,false);
        binding.setViewModel(model);
        return binding.getRoot();
    }
}
