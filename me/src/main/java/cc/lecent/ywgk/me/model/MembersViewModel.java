package cc.lecent.ywgk.me.model;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.me.common.entity.EntityMembers;
import cc.lecent.ywgk.me.ui.MeBindingActivity;
import cc.lecent.ywgk.me.ui.MembersActivity;

public class MembersViewModel extends BaseViewModel {
    File photoFile;
    private MutableLiveData<List<EntityMembers>> mutableLiveData = new MutableLiveData<>();
    public List<EntityMembers> detailsList = new ArrayList<>();
    public final ObservableList<EntityMembers> observableList = new ObservableArrayList<>();
    public Activity mActivity;

    public MembersViewModel(Activity activity){
        this.mActivity=activity;
        photoFile = new File(mActivity.getExternalFilesDir("img"), "scan.jpg");
        fetchBlogs1();

    }
    public void fetchBlogs1() {
       EntityMembers entityMembers=new EntityMembers();
       entityMembers.setItemType(EntityMembers.TYPE_ONE);
       detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        detailsList.add(entityMembers);
        mutableLiveData.setValue(detailsList);
    }

    //TODO 添加数据
    public void adddata(List<EntityMembers> mEntityShopData) {
        observableList.clear();
        observableList.addAll(mEntityShopData);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityMembers>> getListLiveData() {
        return mutableLiveData;
    }


    public void SubmeitOnClick(View view){

        Intent intent = new Intent(mActivity,MeBindingActivity.class);
        mActivity.startActivity(intent);

    }

    public void ReturnOClick(View view){
        mActivity.finish();
    }
}
