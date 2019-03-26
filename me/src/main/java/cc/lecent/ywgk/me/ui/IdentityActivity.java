package cc.lecent.ywgk.me.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.databinding.ActivityIdentityBinding;
import cc.lecent.ywgk.me.model.IdentityViewModel;
import me.jessyan.autosize.internal.CustomAdapt;


public class IdentityActivity extends BaseActivity implements CustomAdapt {
    public IdentityViewModel mIdentityViewModel;
    public ActivityIdentityBinding mActivityIdentityBinding;
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.title_bg_color);
        mIdentityViewModel = new IdentityViewModel(this);
        mActivityIdentityBinding = DataBindingUtil.setContentView(this, R.layout.activity_identity);
        mActivityIdentityBinding.setViewModel(mIdentityViewModel);
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
