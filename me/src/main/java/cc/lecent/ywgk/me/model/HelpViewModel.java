package cc.lecent.ywgk.me.model;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.me.common.entity.EntityHelp;
import cc.lecent.ywgk.me.common.entity.EntityMembers;

public class HelpViewModel extends BaseViewModel {
    private MutableLiveData<List<EntityHelp>> mutableLiveData = new MutableLiveData<>();
    public List<EntityHelp> detailsList = new ArrayList<>();
    public final ObservableList<EntityHelp> observableList = new ObservableArrayList<>();

    public  Activity mActivity;
    public HelpViewModel(Activity activity) {
        this.mActivity=activity;
        fetchBlogs1();
    }

    public void fetchBlogs1() {
        EntityHelp entityMembers = new EntityHelp();
        entityMembers.setItemType(EntityMembers.TYPE_ONE);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        mutableLiveData.setValue(detailsList);
    }

    //TODO 添加数据
    public void adddata(List<EntityHelp> mEntityShopData) {
        observableList.clear();
        observableList.addAll(mEntityShopData);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityHelp>> getListLiveData() {
        return mutableLiveData;
    }


    public void ReturnOClick(View view){
        mActivity.finish();
    }
}
