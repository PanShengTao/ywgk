package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.adapter.AdapterOrderList;
import cc.lecent.ywgk.shop.databinding.OrderlistActivityBinding;
import cc.lecent.ywgk.shop.model.OrderListViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class OrderListActivity extends BaseActivity implements CustomAdapt {
    public OrderlistActivityBinding mOrderlistActivityBinding;
    public OrderListViewModel mOrderListViewModel;
    public AdapterOrderList mAdapterOrderList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.title_color);
        mAdapterOrderList=new AdapterOrderList(getSupportFragmentManager());
        mOrderListViewModel=new OrderListViewModel(this);
        mOrderlistActivityBinding = DataBindingUtil.setContentView(this, R.layout.orderlist_activity);
        mOrderlistActivityBinding.setViewModel(mOrderListViewModel);
        setUp();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    //TODO 初始话数据
    private void setUp() {
       mOrderlistActivityBinding.vpSlideId.setAdapter(mAdapterOrderList);
       mOrderlistActivityBinding.tbSindicatorId.setViewPager(mOrderlistActivityBinding.vpSlideId);
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
