package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.adapter.AdapterDetails;
import cc.lecent.ywgk.shop.common.utlis.UtilsDecoratione;
import cc.lecent.ywgk.shop.databinding.DetailsActivityBinding;
import cc.lecent.ywgk.shop.model.DetailsViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class DetailsActivity extends BaseActivity  implements CustomAdapt{
    public DetailsActivityBinding mDetailsActivityBinding;
    public DetailsViewModel mDetailsViewModel;
    public AdapterDetails mAdapterDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.title_color);
        mAdapterDetails=new AdapterDetails(null,this);
        mDetailsViewModel=new DetailsViewModel(this);
        mDetailsActivityBinding = DataBindingUtil.setContentView(this, R.layout.details_activity);
        mDetailsActivityBinding.setViewModel(mDetailsViewModel);
        setUp();
        setUpdata();
    }
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    //TODO 初始话数据
    private void setUp() {
        mDetailsActivityBinding.reDetailsId.setLayoutManager(new LinearLayoutManager(this));
        mDetailsActivityBinding.reDetailsId.addItemDecoration(new UtilsDecoratione(this, UtilsDecoratione.VERTICAL_LIST, UtilsDecoratione.DividerType.TYPE_FFFFFF));
        mDetailsActivityBinding.reDetailsId.setAdapter(mAdapterDetails);
    }
    private void  setUpdata(){
        mDetailsViewModel.getListLiveData().observe(this, blogs -> mDetailsViewModel.addlistdata(blogs));

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
