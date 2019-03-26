package cc.lecent.ywgk.shop.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.shop.ui.PaymentSuccessActivity;


public class SettlementViewModel extends BaseViewModel {
    public Activity mActivity;
 public SettlementViewModel(Activity activity){
     this.mActivity=activity;
 }

    public void SettlementOnClick(View view) {
        Intent intent = new Intent(mActivity,PaymentSuccessActivity.class);
        mActivity.startActivity(intent);
    }


    public void ReturnOClick(View view){
        mActivity.finish();
    }

}
