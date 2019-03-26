package cc.lecent.ywgk.shop.common.adapter;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;



import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.common.entity.EntityShopData;
import cc.lecent.ywgk.shop.databinding.ItemShopdataBinding;


public class AdapterShopData extends BaseMultiItemQuickAdapter<EntityShopData, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ItemShopdataBinding mItemShopdataBinding;
    public onShopClickListener mOnShopClickListener;
    public Fragment mFragment;
    public AdapterShopData(List<EntityShopData> data,Fragment fragment) {
        super(data);
        this.mFragment=fragment;

    }

    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityShop.TYPE_ONE:
                mItemShopdataBinding = ItemShopdataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemShopDataViewModel itemShopDataViewModel = new ItemShopDataViewModel(mItemShopdataBinding);
                mItemShopdataBinding.setViewModel(itemShopDataViewModel);
                return itemShopDataViewModel;
        }

        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityShopData item) {
        switch (helper.getItemViewType()) {
            case EntityShop.TYPE_ONE:
                ((ItemShopDataViewModel) helper).adddata(item);
        }
    }


    //TODO 适配器：添加数据
    public void addItems(List<EntityShopData> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }

    public class ItemShopDataViewModel extends BaseViewHolder {
        public ObservableField<Integer> serialnumber = new ObservableField<>();
        public ObservableField<String> name = new ObservableField<>();
        public ObservableField<String> usenumber = new ObservableField<>();
        public final ObservableField<String> imageUrl = new ObservableField<>();
        public Bundle bundle = new Bundle();
        public int umber = 0;

        public ItemShopDataViewModel(ItemShopdataBinding itemShopdataBinding) {
            super(itemShopdataBinding.getRoot());

        }

        //TODO 适配器：添加数据
        public void adddata(EntityShopData entityShopData) {
            serialnumber.set(entityShopData.getSerialnumber());
            usenumber.set(entityShopData.getUsenumber() + "");
            name.set(entityShopData.getName());
            imageUrl.set("http://image.bitauto.com/dealer/news/100043511/835040c0-c2b3-483d-a335-1c9088266cc0.jpg");
        }

        //TODO 添加事件
        public void AddtoOnClick() {
            umber=getData().get(serialnumber.get()).getUsenumber();
            umber++;
            getData().get(serialnumber.get()).setUsenumber(umber);
            notifyDataSetChanged();
            mOnShopClickListener.AddShopOnClick(collect());
        }

        public void ReduceOnClick() {
            umber=getData().get(serialnumber.get()).getUsenumber();
            umber--;
            if (umber >= 0) {
                getData().get(serialnumber.get()).setUsenumber(umber);
                notifyDataSetChanged();
                mOnShopClickListener.AddShopOnClick(collect());
            } else {
                umber = 0;
            }
        }
        public Bundle collect() {
            bundle.putString("id", serialnumber.get() + "");
            bundle.putDouble("money", 0.1);
            bundle.putString("name", name.get());
            bundle.putInt("number", umber);
            bundle.putString("picture","http://image.bitauto.com/dealer/news/100043511/835040c0-c2b3-483d-a335-1c9088266cc0.jpg");
           return bundle;
        }

    }

    public interface onShopClickListener {
        void AddShopOnClick(Bundle bundle);
    }

    public void setonShopClickListener(onShopClickListener onShopClickListener) {
        this.mOnShopClickListener = onShopClickListener;
    }
}
