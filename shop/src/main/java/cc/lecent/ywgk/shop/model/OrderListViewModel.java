package cc.lecent.ywgk.shop.model;

import android.app.Activity;
import android.view.View;

import cc.lecent.bbc.base.BaseViewModel;

public class OrderListViewModel extends BaseViewModel {
    public Activity mActivity;
    public OrderListViewModel(Activity activity){
        this.mActivity=activity;
    }


    public void ReturnOClick(View view) {
      mActivity.finish();
    }

}
