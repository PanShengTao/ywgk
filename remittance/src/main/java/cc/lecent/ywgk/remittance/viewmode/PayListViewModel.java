package cc.lecent.ywgk.remittance.viewmode;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import cc.lecent.bbc.BR;
import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.remittance.R;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19 下午12:58
 * 更改时间：19-2-19
 * 版本号：1
 */
public class PayListViewModel extends BaseViewModel {


    private Fragment fragment;
    public PayListViewModel(Fragment fragment) {
        this.fragment=fragment;
        setData();
    }

    public final ObservableList<PayItemViewModel> items = new ObservableArrayList<>();
    public final ItemBinding<PayItemViewModel> itemBinding = ItemBinding.of(BR.item, R.layout.payitem);

    private void setData() {
        for (int i = 0; i < 10; i++) {
            items.add(new PayItemViewModel(fragment));
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
