package cc.lecent.ywgk.shop.model;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.shop.common.entity.EntityDetails;
import cc.lecent.ywgk.shop.common.entity.EntityOrder;

public class DetailsViewModel extends BaseViewModel {
    private MutableLiveData<List<EntityDetails>> mutableLiveData = new MutableLiveData<>();
    public List<EntityDetails> detailsList = new ArrayList<>();
    public final ObservableList<EntityDetails> observableList = new ObservableArrayList<>();
    public Activity mActivity;
    public DetailsViewModel(Activity activity) {
        this.mActivity=activity;
        fetchBlogs1();
    }

    public void fetchBlogs1() {


        EntityDetails entityDetails = new EntityDetails();
        entityDetails.setItemType(EntityOrder.TYPE_ONE);
        detailsList.add(entityDetails);

        detailsList.add(entityDetails);
        mutableLiveData.setValue(detailsList);
    }

    //TODO 添加数据
    public void addlistdata(List<EntityDetails> entityOrders) {
        observableList.clear();
        observableList.addAll(entityOrders);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityDetails>> getListLiveData() {
        return mutableLiveData;
    }


    //TODO 下拉刷新
    public OnRefreshListener refreshCommand = new OnRefreshListener(){
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            //Toast.makeText(mFragment.getActivity(), "hhhhhh", Toast.LENGTH_SHORT).show();
            refreshLayout.finishRefresh(2000);
        }

    };
    //TODO 上拉加载
    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener(){

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            //Toast.makeText(mFragment.getActivity(), "gggggg", Toast.LENGTH_SHORT).show();
            refreshLayout.finishLoadMore(2000);
        }
    };



    public void ReturnOClick(View view){
        mActivity.finish();
    }
}
