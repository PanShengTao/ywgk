package cc.lecent.ywgk.meet.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.meet.R;
import cc.lecent.ywgk.meet.BR;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;


public class RemoteMeetModel extends BaseViewModel {
    private Fragment fragment;
    public RemoteMeetModel(Fragment fragment) {
        this.fragment=fragment;
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        postTest(list);

    }


    //给RecyclerView添加List
    public final ObservableList<ItemRemoteMeetModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<ItemRemoteMeetModel> itemViewSelector = ItemBinding.of(new OnItemBind<ItemRemoteMeetModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, ItemRemoteMeetModel item) {
            if (position==0){
                itemBinding.set(BR.viewModel,R.layout.item_rc_one);
            }else if(position==1){
                itemBinding.set(BR.viewModel,R.layout.item_rc_two);
            }else if(position==2){
                itemBinding.set(BR.viewModel,R.layout.item_rc_three);
            }else if(position==3){
                itemBinding.set(BR.viewModel,R.layout.item_rc_three);
            }else if(position==4){
                itemBinding.set(BR.viewModel,R.layout.item_rc_three);
            }else if(position==5){
                itemBinding.set(BR.viewModel,R.layout.item_rc_four);
            }

        }
    });




    private void postTest(List<String> data){
        itemModels.clear();

        if (data.size() == 0) {
//            ToastUtils.showToast(fragment.getActivity(),1,"暂无数据");
        } else {
            for (int i = 0; i < data.size(); i++) {
                itemModels.add(new ItemRemoteMeetModel(fragment,i));
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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
