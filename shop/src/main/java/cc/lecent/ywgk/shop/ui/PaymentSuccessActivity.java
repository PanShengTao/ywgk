package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.databinding.PaymentsuccessActivityBinding;
import cc.lecent.ywgk.shop.model.PaymentSuccessViewModel;
import me.jessyan.autosize.internal.CustomAdapt;


public class PaymentSuccessActivity extends BaseActivity  implements CustomAdapt {
    public PaymentsuccessActivityBinding mPaymentsuccessActivityBinding;
    public PaymentSuccessViewModel  mPaymentSuccessViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.title_color);
        mPaymentSuccessViewModel=new PaymentSuccessViewModel(this);
        mPaymentsuccessActivityBinding = DataBindingUtil.setContentView(this, R.layout.paymentsuccess_activity);
        mPaymentsuccessActivityBinding.setViewModel(mPaymentSuccessViewModel);
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
