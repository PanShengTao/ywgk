package cc.lecent.ywgk.shop.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.shop.common.entity.EntityOrder;

public class WholeViewModel extends BaseViewModel {
    public ObservableField<String> mNmaeField = new ObservableField<>();
    private int mposition;
    public Fragment mFragment;


    private MutableLiveData<List<EntityOrder>> mutableLiveData;
    public List<EntityOrder> orderList = new ArrayList<>();
    public final ObservableList<EntityOrder> observableList = new ObservableArrayList<>();


    public WholeViewModel(int position, Fragment fragment) {
        this.mposition = position;
        this.mFragment = fragment;
        mutableLiveData = new MutableLiveData<>();
        inidata();
    }

    public void inidata() {
        switch (mposition) {
            case 0:
                mNmaeField.set("0");
                fetchBlogs1("全部");
                break;
            case 1:
                mNmaeField.set("1");
                fetchBlogs1("已完成");
                break;
            case 2:
                mNmaeField.set("2");
                fetchBlogs1("待支付");
                break;
            case 3:
                mNmaeField.set("3");
                fetchBlogs1("已取消");
                break;
        }
    }

    public void fetchBlogs1(String name) {
        EntityOrder entityOrder0 = new EntityOrder();
        entityOrder0.setItemType(EntityOrder.TYPE_NINE);
        orderList.add(entityOrder0);
        for (int i = 0; i < 20; i++) {
            EntityOrder entityOrder = new EntityOrder();
            entityOrder.setItemType(EntityOrder.TYPE_ONE);

            entityOrder.setName(name);
            orderList.add(entityOrder);
        }

        mutableLiveData.setValue(orderList);
    }


    //TODO 添加数据
    public void addlistdata(List<EntityOrder> entityOrders) {
        observableList.clear();
        observableList.addAll(entityOrders);
    }

    //TODO 别获取数据
    public MutableLiveData<List<EntityOrder>> getListLiveData() {
        return mutableLiveData;
    }
    //TODO 下拉刷新
    public OnRefreshListener refreshCommand = new OnRefreshListener(){
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            Toast.makeText(mFragment.getActivity(), "hhhhhh", Toast.LENGTH_SHORT).show();
            refreshLayout.finishRefresh(2000);
        }

    };
    //TODO 上拉加载
    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener(){

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            Toast.makeText(mFragment.getActivity(), "gggggg", Toast.LENGTH_SHORT).show();
            refreshLayout.finishLoadMore(2000);
        }
    };


}
