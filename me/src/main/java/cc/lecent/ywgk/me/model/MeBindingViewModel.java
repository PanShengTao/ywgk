package cc.lecent.ywgk.me.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.me.ui.IdentityActivity;

public class MeBindingViewModel extends BaseViewModel {

    public Activity mActivity;

    public MeBindingViewModel(Activity activity) {
        this.mActivity = activity;
    }

    public void NextStepOnClick(View view) {
        Intent intent = new Intent(mActivity, IdentityActivity.class);
        mActivity.startActivity(intent);

    }
    public void ReturnOClick(View view){
        mActivity.finish();
    }
}
