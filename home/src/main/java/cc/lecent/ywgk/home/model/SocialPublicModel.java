package cc.lecent.ywgk.home.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.ywgk.data.util.ToastUtils;
import cc.lecent.ywgk.home.BR;
import cc.lecent.ywgk.home.R;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class SocialPublicModel {
    private Fragment fragment;
    public SocialPublicModel(Fragment fragment) {
        this.fragment=fragment;

        List<String> listStr=new ArrayList<>();
        listStr.add("1");
        listStr.add("1");
        listStr.add("1");
        listStr.add("1");
        setData(listStr);
    }


    //给RecyclerView添加List
    public final ObservableList<SocialPublicItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<SocialPublicItemModel> itemViewSelector = ItemBinding.of(BR.viewModel,R.layout.item_recyclerview_social);



    public OnRefreshListener refreshCommand = new OnRefreshListener(){
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            Toast.makeText(fragment.getActivity(), "hhhhhh", Toast.LENGTH_SHORT).show();
            refreshLayout.finishRefresh(2000);
        }

    };

    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener(){

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            Toast.makeText(fragment.getActivity(), "gggggg", Toast.LENGTH_SHORT).show();
            refreshLayout.finishLoadMore(2000);
        }
    };


    public void setData(List<String> listStr){

        itemModels.clear();

        if (listStr.size() == 0) {
            ToastUtils.showToast(fragment.getActivity(), "暂无数据");
        } else {
            for (int i = 0; i < listStr.size(); i++) {
                itemModels.add(new SocialPublicItemModel(fragment));
            }
        }

    }
}
