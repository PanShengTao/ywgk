package cc.lecent.ywgk.home.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.ywgk.data.util.ToastUtils;
import cc.lecent.ywgk.home.BR;
import cc.lecent.ywgk.home.R;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class HomeModel {
    private Fragment fragment;
    public HomeModel(Fragment fragment) {
        this.fragment=fragment;
        List<String> listData=new ArrayList<>();
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");

        postTest(listData);
    }





    //给RecyclerView添加List
    public final ObservableList<HomeItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<HomeItemModel> itemViewSelector = ItemBinding.of(new OnItemBind<HomeItemModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, HomeItemModel item) {
            if (position==0){
                itemBinding.set(BR.viewModel,R.layout.item_home_slideshow);
            }else if(position==1){
                itemBinding.set(BR.viewModel,R.layout.item_home_rec);
            }else if(position==2){
                itemBinding.set(BR.viewModel,R.layout.item_home_rec);
            }else if(position==3){
                itemBinding.set(BR.viewModel,R.layout.item_home_rec);
            }else if(position==4){
                itemBinding.set(BR.viewModel,R.layout.item_home_title);
            }else{
                itemBinding.set(BR.viewModel,R.layout.item_recyclerview_news);
            }

        }
    });


    private void postData(){




    }



    private void postTest(List<String> data){
        itemModels.clear();

        if (data.size() == 0) {
            ToastUtils.showToast(fragment.getActivity(),"暂无数据");
        } else {
            for (int i = 0; i < data.size(); i++) {
                itemModels.add(new HomeItemModel(fragment,i));
            }
        }
    }



   public OnRefreshListener refreshCommand = new OnRefreshListener(){
       @Override
       public void onRefresh(@NonNull RefreshLayout refreshLayout) {
           refreshLayout.finishRefresh(2000);
       }

    };

    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener(){

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            refreshLayout.finishLoadMore(2000);
        }
    };


}
