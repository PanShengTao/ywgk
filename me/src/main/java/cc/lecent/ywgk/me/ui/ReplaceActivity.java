package cc.lecent.ywgk.me.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.databinding.ActivityReplaceBinding;

import cc.lecent.ywgk.me.model.ReplaceViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class ReplaceActivity extends BaseActivity implements CustomAdapt {
    public ReplaceViewModel replaceViewModel;
    public ActivityReplaceBinding mActivityReplaceBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.title_bg_color);
        replaceViewModel = new ReplaceViewModel(this);
        mActivityReplaceBinding = DataBindingUtil.setContentView(this, R.layout.activity_replace);
        mActivityReplaceBinding.setViewModel(replaceViewModel);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

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
