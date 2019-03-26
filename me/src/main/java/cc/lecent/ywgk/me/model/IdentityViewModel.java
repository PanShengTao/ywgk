package cc.lecent.ywgk.me.model;

import android.app.Activity;
import android.view.View;

import cc.lecent.bbc.base.BaseViewModel;

public class IdentityViewModel extends BaseViewModel {
    public Activity mActivity;
    public IdentityViewModel(Activity activity){
        this.mActivity=activity;
    }
    public void ReturnOClick(View view){
        mActivity.finish();
    }
}
