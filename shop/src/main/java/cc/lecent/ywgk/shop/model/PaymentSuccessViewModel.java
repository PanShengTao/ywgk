package cc.lecent.ywgk.shop.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.shop.ui.OrderListActivity;


public class PaymentSuccessViewModel extends BaseViewModel {
    public Activity mActivity;

    public PaymentSuccessViewModel(Activity activity) {
        this.mActivity = activity;
    }

    public void SeeOnClick(View view) {
        Intent intent = new Intent(mActivity, OrderListActivity.class);
        mActivity.startActivity(intent);
    }

    public void ReturnOClick(View view) {
        mActivity.finish();
    }

}
