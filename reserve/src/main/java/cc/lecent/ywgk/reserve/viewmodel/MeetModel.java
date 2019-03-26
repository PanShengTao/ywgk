package cc.lecent.ywgk.reserve.viewmodel;

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
import java.util.Random;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.reserve.BR;
import cc.lecent.ywgk.reserve.R;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class MeetModel extends BaseViewModel {
    private Fragment fragment;
    private int random = new Random().nextInt(10);

    public MeetModel(Fragment fragment) {
        this.fragment = fragment;
        List<String> listData = new ArrayList<>();
        listData.add("1");
        listData.add("1");
        listData.add("1");
        if (random % 2 == 0) {
            listData.add("1");
            listData.add("1");
            listData.add("1");
        }
        postTest(listData);
    }


    //给RecyclerView添加List
    public final ObservableList<MeetItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<MeetItemModel> itemViewSelector = ItemBinding.of(new OnItemBind<MeetItemModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MeetItemModel item) {
            if (position == 0) {
                itemBinding.set(BR.viewModel, R.layout.item_meet_slideshow);
            } else if (position == 1) {
                itemBinding.set(BR.viewModel, R.layout.item_meet_rec);
            } else if (random % 2 != 0 && position == 2) {
                itemBinding.set(BR.viewModel, R.layout.item_meet_null);
            } else {
                itemBinding.set(BR.viewModel, R.layout.item_meet_list);
            }

        }
    });


    private void postData() {


    }


    private void postTest(List<String> data) {
        itemModels.clear();

        if (data.size() == 0) {
//            ToastUtils.showToast(fragment.getActivity(),1,"暂无数据");
        } else {
            for (int i = 0; i < data.size(); i++) {
//                flag = flag+1;
                itemModels.add(new MeetItemModel(fragment, i));
            }
        }
    }


    public OnRefreshListener refreshCommand = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            refreshLayout.finishRefresh(2000);
        }

    };

    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener() {

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
            refreshLayout.finishLoadMore(2000);
        }
    };


}
