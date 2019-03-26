package cc.lecent.ywgk.reserve.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.reserve.R;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import cc.lecent.ywgk.reserve.BR;

public class RecordViewMode extends BaseViewModel {
    private Fragment fragment;
    public RecordViewMode(Fragment fragment){
        this.fragment=fragment;
        setData();
    }



    public final ObservableList<RecordItemModel> items=new ObservableArrayList<>();
    public final ItemBinding<RecordItemModel> itemBinding=ItemBinding.of(BR.item, R.layout.record_item);
    private void setData() {
        for (int i = 0; i < 5; i++) {
            items.add(new RecordItemModel(fragment));
        }
    }
    public OnRefreshListener refreshCommand = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//            Toast.makeText(fragment.getActivity(), "hhhhhh", Toast.LENGTH_SHORT).show();
            refreshLayout.finishRefresh(2000);
        }

    };

    public OnLoadMoreListener loadMoreCommand = new OnLoadMoreListener() {

        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//            Toast.makeText(fragment.getActivity(), "gggggg", Toast.LENGTH_SHORT).show();
            refreshLayout.finishLoadMore(2000);
        }
    };
}
