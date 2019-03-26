package cc.lecent.ywgk.shop.common.adapter;

import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.entity.EntityOrder;
import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.databinding.ItemOrderBinding;
import cc.lecent.ywgk.shop.ui.DetailsActivity;
import cc.lecent.ywgk.shop.ui.OrderListActivity;


public class AdapterWhole extends BaseMultiItemQuickAdapter<EntityOrder, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ItemOrderBinding mItemOrderBinding;
    public Fragment mFragment;
    public List<EntityOrder> orderList;

    public AdapterWhole(List<EntityOrder> data, Fragment fragment) {
        super(data);
        this.orderList = data;
        this.mFragment = fragment;
    }


    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityShop.TYPE_ONE:
                mItemOrderBinding = ItemOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                OrderViewModel orderViewModel = new OrderViewModel(mItemOrderBinding);
                mItemOrderBinding.setViewModel(orderViewModel);
                return orderViewModel;
            case EntityShop.TYPE_NINE:
                return new itemOrdel(mLayoutInflater.inflate(R.layout.item, parent, false));

        }

        return super.onCreateDefViewHolder(parent, viewType);
    }


    @Override
    protected void convert(BaseViewHolder helper, EntityOrder item) {
        switch (helper.getItemViewType()) {
            case EntityShop.TYPE_ONE:
                ((OrderViewModel) helper).adddata(item);
                break;
        }
    }

    //TODO 适配器：添加数据
    public void addItems(List<EntityOrder> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }

    //TODO ViewHolderItem
    public class OrderViewModel extends BaseViewHolder {

        public ObservableField<String> name = new ObservableField<>();

        public OrderViewModel(ItemOrderBinding itemOrderBinding) {
            super(itemOrderBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityOrder entityOrder) {
            name.set(entityOrder.getName());
        }

        public void DetailsOnClick(View view) {
            Intent intent = new Intent(mFragment.getActivity(),DetailsActivity.class);
            mFragment.getActivity().startActivity(intent);
        }
    }

    public class itemOrdel extends BaseViewHolder {
        public itemOrdel(View view) {
            super(view);
        }
    }
}
