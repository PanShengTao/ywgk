package cc.lecent.ywgk.shop.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.component.shop.dilog.ShopCartDialog;
import cc.lecent.component.shop.interfaceipe.Iterfaceipe;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.common.entity.EntityShopData;
import cc.lecent.ywgk.shop.ui.SettlementActivity;

public class ShopViewModel extends BaseViewModel implements Iterfaceipe {
    public Fragment mFragment;
    public final ObservableList<EntityShop> blogObservableArrayList = new ObservableArrayList<>();
    private MutableLiveData<List<EntityShop>> blogListLiveData;
    public List<EntityShop> list = new ArrayList<>();

    public final ObservableList<EntityShopData> mObservableArrayList = new ObservableArrayList<>();
    private MutableLiveData<List<EntityShopData>> mListMutableLiveData;
    public List<EntityShopData> dataArrayList = new ArrayList<>();
    public ObservableField<String> money = new ObservableField<>();


    public ShopCartDialog mShopCartDialog;

    public ShopViewModel(Fragment fragment) {
        this.mFragment = fragment;
        blogListLiveData = new MutableLiveData<>();
        mListMutableLiveData = new MutableLiveData<>();
        mShopCartDialog = new ShopCartDialog(mFragment.getActivity(), this);
        fetchBlogs();
    }

    public void fetchBlogs() {

        EntityShop entityPrisoner = new EntityShop();
        entityPrisoner.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setSerialnumber(0);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setName("饮料");
        list.add(entityPrisoner);


        EntityShop entityPrisoner1 = new EntityShop();
        entityPrisoner1.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setSerialnumber(1);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner1.setName("水果");
        list.add(entityPrisoner1);

        EntityShop entityPrisoner2 = new EntityShop();
        entityPrisoner2.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setSerialnumber(2);
        entityPrisoner2.setName("奶制品");
        list.add(entityPrisoner2);

        EntityShop entityPrisoner3 = new EntityShop();
        entityPrisoner3.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner3.setName("休闲零食");
        list.add(entityPrisoner3);

        EntityShop entityPrisoner4 = new EntityShop();
        entityPrisoner4.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setSerialnumber(3);
        entityPrisoner4.setName("衣服");
        list.add(entityPrisoner4);

        EntityShop entityPrisoner5 = new EntityShop();
        entityPrisoner5.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setSerialnumber(4);
        entityPrisoner5.setName("文具");
        list.add(entityPrisoner5);

        EntityShop entityPrisoner6 = new EntityShop();
        entityPrisoner6.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setSerialnumber(5);
        entityPrisoner6.setName("香烟");
        list.add(entityPrisoner6);


        EntityShop entityPrisoner7 = new EntityShop();
        entityPrisoner7.setItemType(EntityShop.TYPE_ONE);
        entityPrisoner.setBercolr(mFragment.getResources().getColor(R.color.home_text_color));
        entityPrisoner.setSerialnumber(6);
        entityPrisoner7.setName("其他");
        list.add(entityPrisoner7);


        blogListLiveData.setValue(list);
        fetchBlogs1(4);
    }

    public void fetchBlogs1(int in) {
        if (dataArrayList.size() > 0) {
            dataArrayList.clear();
            addshopdata(in);
        } else {
            addshopdata(in);
        }

    }

    public void addshopdata(int in) {
        for (int i = 0; i < in; i++) {
            EntityShopData entityPrisoner = new EntityShopData();
            entityPrisoner.setItemType(EntityShopData.TYPE_ONE);
            entityPrisoner.setUsenumber(0);
            entityPrisoner.setSerialnumber(i);
            entityPrisoner.setName("小米扎" + i);
            dataArrayList.add(entityPrisoner);
        }

        if (mShopCartDialog.refresh().size() > 0) {
            for (int j = 0; j < mShopCartDialog.refresh().size(); j++) {
                for (int k = 0; k < dataArrayList.size(); k++) {
                    if (Integer.valueOf(mShopCartDialog.refresh().get(j).getId()) == dataArrayList.get(k).getSerialnumber()) {
                        dataArrayList.get(k).setUsenumber(mShopCartDialog.refresh().get(j).getNumber());
                    }
                }
            }
            mListMutableLiveData.setValue(dataArrayList);
        } else {
            mListMutableLiveData.setValue(dataArrayList);
        }
    }


    //TODO 添加到购物车
    public void addshop(Bundle bundle) {
        mShopCartDialog.addobject(bundle, null);
    }


    //TODO 类别添加数据
    public void addBlogItemsToList(List<EntityShop> manageList) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(manageList);
    }

    //TODO 添加数据
    public void addBlogItemsTolistdata(List<EntityShopData> mEntityShopData) {
        mObservableArrayList.clear();
        mObservableArrayList.addAll(mEntityShopData);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityShop>> getBlogListLiveData() {
        return blogListLiveData;
    }

    //TODO 获取数据
    public MutableLiveData<List<EntityShopData>> getmListMutableLiveData() {
        return mListMutableLiveData;
    }

    public void ShopOnClick(View view) {
        mShopCartDialog.show();
    }

    public void SettlementOnClick(View view) {
        //ARouter.getInstance().build("/shop/SettlementActivity").navigation();
        Intent intent = new Intent(mFragment.getActivity(),SettlementActivity.class);
        mFragment.getActivity().startActivity(intent);
        mShopCartDialog.settleaccounts();
    }

    //TODO 购物车数量更改
    @Override
    public void addnumber(String s, int i) {
        for (int k = 0; k < dataArrayList.size(); k++) {
            if (Integer.valueOf(s) == dataArrayList.get(k).getSerialnumber()) {
                dataArrayList.get(k).setUsenumber(i);
            }
        }
        mListMutableLiveData.setValue(dataArrayList);
    }

    @Override
    public void amountofmoney(double v) {
        money.set(Double.toString(v));
    }

    @Override
    public void datanumber(int i, int i1) {


    }

    @Override
    public void settleaccounts(String s) {
        Log.e("购物车返回来的数据", s);
    }

    public void ReturnOClick(View view){
        mFragment.getActivity().finish();
    }
}
