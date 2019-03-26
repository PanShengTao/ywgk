package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.databinding.ActivityShopBinding;
import cc.lecent.ywgk.shop.model.ShopActivitViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

@Route(path = "/shop/ShopActivity")
public class ShopActivity extends BaseActivity implements CustomAdapt {
   public ShopActivitViewModel mShopActivitViewModel;
   public ActivityShopBinding mActivityShopBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.title_color);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ShopFragment fragment = new ShopFragment();
        transaction.add(R.id.fr_displaydata_id, fragment);
        transaction.commit();
        mShopActivitViewModel=new ShopActivitViewModel();
        mActivityShopBinding = DataBindingUtil.setContentView(this, R.layout.activity_shop);
        mActivityShopBinding.setViewModel(mShopActivitViewModel);
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
