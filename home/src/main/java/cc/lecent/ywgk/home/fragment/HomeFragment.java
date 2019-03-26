package cc.lecent.ywgk.home.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.home.R;
import cc.lecent.ywgk.home.databinding.FragmentHomeBinding;
import cc.lecent.ywgk.home.model.HomeModel;

public class HomeFragment extends BaseFragment {
    private FragmentHomeBinding binding;
    private HomeModel model;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         model=new HomeModel(this);
         binding =DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
         binding.setViewModel(model);

        initView();
        return binding.getRoot();
    }

    private void initView() {

    }
}
