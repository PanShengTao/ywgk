package cc.lecent.ywgk.me.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.databinding.ActivityMebindingBinding;
import cc.lecent.ywgk.me.model.MeBindingViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class MeBindingActivity extends BaseActivity  implements CustomAdapt {
    public ActivityMebindingBinding mActivityMebindingBinding;
    public MeBindingViewModel mMeBindingViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.title_bg_color);
        mMeBindingViewModel = new MeBindingViewModel(this);
        mActivityMebindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_mebinding);
        mActivityMebindingBinding.setViewModel(mMeBindingViewModel);

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
