package cc.lecent.ywgk.shop.common.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.entity.EntityDetails;
import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.databinding.ItemDetailsBinding;


public class AdapterDetails extends BaseMultiItemQuickAdapter<EntityDetails, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Activity mActivity;
    public ItemDetailsBinding mItemDetailsBinding;
    public AdapterDetails(List<EntityDetails> data, Activity activity) {
        super(data);
        this.mActivity=activity;
    }
    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityShop.TYPE_ONE:
                mItemDetailsBinding = ItemDetailsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemDetails itemDetails=new ItemDetails(mItemDetailsBinding);
                mItemDetailsBinding.setViewModel(itemDetails);
                return  itemDetails;
            case EntityShop.TYPE_NINE:
                return new itemMargin(mLayoutInflater.inflate(R.layout.item_margin, parent, false));

        }

        return super.onCreateDefViewHolder(parent, viewType);
    }
    @Override
    protected void convert(BaseViewHolder helper, EntityDetails item) {

    }

    //TODO 适配器：添加数据
    public void addItems(List<EntityDetails> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }
    public class ItemDetails extends BaseViewHolder {
        public ItemDetails(ItemDetailsBinding  itemDetailsBinding) {
            super(itemDetailsBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityDetails entityDetails) {

        }
    }

    public class itemMargin extends BaseViewHolder {
        public itemMargin(View view) {
            super(view);
        }
    }
}

