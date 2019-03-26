package cc.lecent.ywgk.home.model;

import android.databinding.ObservableInt;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class HomeItemRecyclerviewModel {

    private Fragment fragment;

    public HomeItemRecyclerviewModel(Fragment fragment) {
        this.fragment=fragment;
        initView();
    }

    public ObservableInt ss=new ObservableInt(5);

    private void initView() {

    }


}
