package cc.lecent.ywgk.me.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.me.common.entity.EntityMe;


public class MeModelViewModel extends BaseViewModel {
    private Fragment fragment;
    private MutableLiveData<List<EntityMe>> mutableLiveData = new MutableLiveData<>();
    public List<EntityMe> detailsList = new ArrayList<>();
    public final ObservableList<EntityMe> observableList = new ObservableArrayList<>();

    public MeModelViewModel(Fragment fragment) {
        this.fragment = fragment;
        fetchBlogs1();
    }

    public void fetchBlogs1() {
        EntityMe entityMe0 = new EntityMe();
        entityMe0.setItemType(EntityMe.TYPE_NINE);
        detailsList.add(entityMe0);

        EntityMe entityOrder1 = new EntityMe();
        entityOrder1.setItemType(EntityMe.TYPE_ONE);
        detailsList.add(entityOrder1);

        EntityMe entityOrder2 = new EntityMe();
        entityOrder2.setItemType(EntityMe.TYPE_TWO);
        detailsList.add(entityOrder2);

        EntityMe entityOrder3 = new EntityMe();
        entityOrder3.setItemType(EntityMe.TYPE_THREE);
        detailsList.add(entityOrder3);


        detailsList.add(entityMe0);


        EntityMe entityOrder4 = new EntityMe();
        entityOrder4.setItemType(EntityMe.TYPE_FOUR);
        detailsList.add(entityOrder4);

        EntityMe entityOrder5 = new EntityMe();
        entityOrder5.setItemType(EntityMe.TYPE_FIVE);
        detailsList.add(entityOrder5);

        mutableLiveData.setValue(detailsList);
    }

    //TODO 添加数据
    public void adddata(List<EntityMe> mEntityShopData) {
        observableList.clear();
        observableList.addAll(mEntityShopData);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityMe>> getListLiveData() {
        return mutableLiveData;
    }

}
