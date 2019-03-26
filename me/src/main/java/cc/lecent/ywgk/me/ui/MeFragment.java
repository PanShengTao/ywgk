package cc.lecent.ywgk.me.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.common.adapter.AdapterMe;
import cc.lecent.ywgk.me.common.utlis.UtilsDecoration;
import cc.lecent.ywgk.me.databinding.FragmentMeBinding;
import cc.lecent.ywgk.me.model.MeModelViewModel;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 * 我的
 */

@Route(path = "/me/MeFragment")
public class MeFragment extends BaseFragment  implements CustomAdapt {
    public FragmentMeBinding binding;
    public AdapterMe mAdapterMe;
    public MeModelViewModel meModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoSizeConfig.getInstance().setCustomFragment(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAdapterMe = new AdapterMe(null, this);
        meModel = new MeModelViewModel(this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);
        binding.setViewModel(meModel);
       // binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
        subscribeToLiveData();
    }

    //TODO 初始话数据
    private void setUp() {
        binding.reMeId.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.reMeId.addItemDecoration(new UtilsDecoration(getContext(), UtilsDecoration.VERTICAL_LIST, UtilsDecoration.DividerType.TYPE_F2F2F2));
        binding.reMeId.setAdapter(mAdapterMe);
    }


    //TODO 添加数据
    private void subscribeToLiveData() {
        meModel.getListLiveData().observe(this, blogs -> meModel.adddata(blogs));
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return ScreenUtils.getScreenWidth(getActivity());
    }
}
