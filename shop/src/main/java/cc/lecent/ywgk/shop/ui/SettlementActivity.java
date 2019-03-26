package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;

import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.databinding.SettlementActivityBinding;
import cc.lecent.ywgk.shop.model.SettlementViewModel;
import me.jessyan.autosize.internal.CustomAdapt;


public class SettlementActivity  extends BaseActivity implements CustomAdapt {
    public SettlementActivityBinding mSettlementActivityBinding;
    public SettlementViewModel mSettlementViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.title_color);
        mSettlementViewModel=new SettlementViewModel(this);
        mSettlementActivityBinding = DataBindingUtil.setContentView(this, R.layout.settlement_activity);
        mSettlementActivityBinding.setViewModel(mSettlementViewModel);
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
