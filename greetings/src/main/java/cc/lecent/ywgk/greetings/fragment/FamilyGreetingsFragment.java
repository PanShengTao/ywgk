package cc.lecent.ywgk.greetings.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.databinding.FragmentFamilyGeetingsBinding;
import cc.lecent.ywgk.greetings.model.FamilyGreetingsModel;

/**
 * 亲情问候
 */
public class FamilyGreetingsFragment extends BaseFragment {

    private FamilyGreetingsModel model;
    private FragmentFamilyGeetingsBinding binding;

    public static FamilyGreetingsFragment newInstance() {

        FamilyGreetingsFragment fragment = new FamilyGreetingsFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         model=new FamilyGreetingsModel(this);
         binding =DataBindingUtil.inflate(inflater, R.layout.fragment_family_geetings,container,false);
        binding.setViewModel(model);
        return binding.getRoot();

    }
}
