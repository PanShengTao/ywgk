package cc.lecent.ywgk.greetings.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.greetings.BR;
import cc.lecent.ywgk.greetings.CommonOperations;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.fragment.EditorGreetingsFragment;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class FamilyGreetingsModel extends BaseViewModel {
    private Fragment fragment;
    private int replaceContent=R.id.classifyFragment;
    public FamilyGreetingsModel(Fragment fragment) {
        this.fragment=fragment;
        List<String> listData=new ArrayList<>();
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");

        postTest(listData);

    }



    //给RecyclerView添加List
    public final ObservableList<FamilyGreetingsItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<FamilyGreetingsItemModel> itemViewSelector = ItemBinding.of(BR.viewModel, R.layout.item_family_geetings);


    private void postTest(List<String> data){
        itemModels.clear();

        if (data.size() == 0) {
//            ToastUtils.showToast(fragment.getActivity(),1,"暂无数据");
        } else {
            for (int i = 0; i < data.size(); i++) {
                itemModels.add(new FamilyGreetingsItemModel(fragment));
            }
        }
    }


    public void EditorGreetingsOnClick(){
        Bundle bundle=new Bundle();
        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), EditorGreetingsFragment.class.getCanonicalName(),replaceContent,bundle);
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
