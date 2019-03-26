package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.adapter.AdapterShop;
import cc.lecent.ywgk.shop.common.adapter.AdapterShopData;
import cc.lecent.ywgk.shop.common.utlis.UtilsDecoratione;
import cc.lecent.ywgk.shop.databinding.FragmentShopBinding;
import cc.lecent.ywgk.shop.model.ShopViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

public class ShopFragment extends BaseFragment implements CustomAdapt {

    public ShopViewModel mShopViewModel;
    public FragmentShopBinding mFragmentShopBinding;
    public AdapterShop mAdapterShop;
    public AdapterShopData mAdapterShopData;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAdapterShop=new AdapterShop(null,this);
        mAdapterShopData=new AdapterShopData(null,this);
        mShopViewModel = new ShopViewModel(this);
        mFragmentShopBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);
        mFragmentShopBinding.setViewModel(mShopViewModel);
        return mFragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
        subscribeToLiveData();
    }

    //TODO 初始话数据
    private void setUp() {
        mFragmentShopBinding.reClassificationId.setLayoutManager(new LinearLayoutManager(getContext()));
       // mFragmentShopBinding.reClassificationId.addItemDecoration(new UtilsDecoratione(getContext(), UtilsDecoratione.VERTICAL_LIST, UtilsDecoratione.DividerType.TYPE_E4E4E4));
        mFragmentShopBinding.reClassificationId.setAdapter(mAdapterShop);

        mFragmentShopBinding.reShopdataId.setLayoutManager(new LinearLayoutManager(getContext()));
       // mFragmentShopBinding.reShopdataId.addItemDecoration(new UtilsDecoratione(getContext(), UtilsDecoratione.VERTICAL_LIST, UtilsDecoratione.DividerType.TYPE_F2F2F2));
        mFragmentShopBinding.reShopdataId.setAdapter(mAdapterShopData);


        mAdapterShop.setShopClickListener(new AdapterShop.shopClickListener() {
            @Override
            public void ClassificationOneOnClick() {
              mShopViewModel.fetchBlogs1(5);
            }
        });

        mAdapterShopData.setonShopClickListener(new AdapterShopData.onShopClickListener() {
            @Override
            public void AddShopOnClick(Bundle bundle) {
                mShopViewModel.addshop(bundle);
            }
        });
    }

    //TODO 添加数据
    private void subscribeToLiveData() {
        mShopViewModel.getBlogListLiveData().observe(this, blogs -> mShopViewModel.addBlogItemsToList(blogs));
        mShopViewModel.getmListMutableLiveData().observe(this,blogsdat -> mShopViewModel.addBlogItemsTolistdata(blogsdat));
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return ScreenUtils.getScreenWidth(getActivity());
    }
}
