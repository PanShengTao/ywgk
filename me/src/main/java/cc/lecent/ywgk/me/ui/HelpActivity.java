package cc.lecent.ywgk.me.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.common.adapter.AdapterHelp;
import cc.lecent.ywgk.me.common.utlis.UtilsDecoration;
import cc.lecent.ywgk.me.databinding.ActivityHelpBinding;
import cc.lecent.ywgk.me.model.HelpViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class HelpActivity extends BaseActivity  implements CustomAdapt {

    public ActivityHelpBinding mActivityHelpBinding;
    public HelpViewModel mHelpViewModel;
    public AdapterHelp mAdapterHelp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.title_bg_color);
        mAdapterHelp=new AdapterHelp(null,this);
        mHelpViewModel = new HelpViewModel(this);
        mActivityHelpBinding = DataBindingUtil.setContentView(this, R.layout.activity_help);
        mActivityHelpBinding.setViewModel(mHelpViewModel);
        setUp();
        subscribeToLiveData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    //TODO 初始话数据
    private void setUp() {
        mActivityHelpBinding.reHelpIe.setLayoutManager(new LinearLayoutManager(this));
        mActivityHelpBinding.reHelpIe.addItemDecoration(new UtilsDecoration(this, UtilsDecoration.VERTICAL_LIST, UtilsDecoration.DividerType.TYPE_E10E10E10));
        mActivityHelpBinding.reHelpIe.setAdapter(mAdapterHelp);
    }

    //TODO 添加数据
    private void subscribeToLiveData() {
        mHelpViewModel.getListLiveData().observe(this, blogs -> mHelpViewModel.adddata(blogs));
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return ScreenUtils.getScreenWidth(this);
    }
}
