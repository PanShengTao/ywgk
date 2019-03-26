package cc.lecent.ywgk.me.ui;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Window;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.common.adapter.AdapterMembers;
import cc.lecent.ywgk.me.common.utlis.UtilsDecoration;
import cc.lecent.ywgk.me.common.utlis.slrecyclerview.RecyclerTouchListener;
import cc.lecent.ywgk.me.databinding.MembersActivityBinding;
import cc.lecent.ywgk.me.model.MembersViewModel;
import me.jessyan.autosize.AutoSizeCompat;
import me.jessyan.autosize.internal.CustomAdapt;

public class MembersActivity extends BaseActivity  implements CustomAdapt {
    public MembersActivityBinding mMembersActivityBinding;
    public MembersViewModel mMembersViewModel;
    public AdapterMembers mMdapterMembers;
    private RecyclerTouchListener onTouchListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.title_bg_color);
        mMembersViewModel = new MembersViewModel(this);
        mMembersActivityBinding = DataBindingUtil.setContentView(this, R.layout.members_activity);
        onTouchListener = new RecyclerTouchListener(this, mMembersActivityBinding.slMembersId);
        mMdapterMembers = new AdapterMembers(null, this);
        mMembersActivityBinding.setViewModel(mMembersViewModel);
        setUp();
        subscribeToLiveData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    //TODO 初始话数据
    private void setUp() {
        mMembersActivityBinding.slMembersId.setLayoutManager(new LinearLayoutManager(this));
        mMembersActivityBinding.slMembersId.addItemDecoration(new UtilsDecoration(this, UtilsDecoration.VERTICAL_LIST, UtilsDecoration.DividerType.TYPE_E8E8E8));
        mMembersActivityBinding.slMembersId.setAdapter(mMdapterMembers);
        onTouchListener.setIndependentViews(R.id.te_binding_id)
                //.setViewsToFade(R.id.te_binding_id)
                .setSwipeOptionViews(R.id.re_change_id)
                .setSwipeable(R.id.li_rowfg_id, R.id.li_rowbc_id, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                    }
                });
    }

    //TODO 添加数据
    private void subscribeToLiveData() {
        mMembersViewModel.getListLiveData().observe(this, blogs -> mMembersViewModel.adddata(blogs));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMembersActivityBinding.slMembersId.addOnItemTouchListener(onTouchListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMembersActivityBinding.slMembersId.removeOnItemTouchListener(onTouchListener);
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {

        Log.d("ggggggggggg",ScreenUtils.getScreenHeight(MembersActivity.this)+"");
         return ScreenUtils.getScreenWidth(MembersActivity.this);
    }

/*
    Override
    public Resources getResources() {
        //需要升级到 v1.1.2 及以上版本才能使用 AutoSizeCompat
        AutoSizeCompat.autoConvertDensityOfGlobal((super.getResources());//如果没有自定义需求用这个方法
        AutoSizeCompat.autoConvertDensity((super.getResources(), 667, false);//如果有自定义需求就用这个方法
        return super.getResources();
    }*/

}
