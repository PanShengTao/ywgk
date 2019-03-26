package cc.lecent.ywgk.shop.common.adapter;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.databinding.ItemShopBinding;

public class AdapterShop extends BaseMultiItemQuickAdapter<EntityShop, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ItemShopBinding mItemShopBinding;
    public shopClickListener mShopClickListener;
    public Fragment mFragment;
    public  int it=0;
    public AdapterShop(List<EntityShop> data,Fragment fragment) {
        super(data);
        this.mFragment=fragment;
    }

    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityShop.TYPE_ONE:
                mItemShopBinding = ItemShopBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemShopViewModel itemShopViewModel = new ItemShopViewModel(mItemShopBinding);
                mItemShopBinding.setViewModel(itemShopViewModel);
                return itemShopViewModel;

        }

        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityShop item) {
        switch (helper.getItemViewType()) {
            case EntityShop.TYPE_ONE:
                ((ItemShopViewModel) helper).adddata(item);
        }
    }

    //TODO 适配器：添加数据
    public void addItems(List<EntityShop> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }

    //TODO ViewHolderItem
    public class ItemShopViewModel extends BaseViewHolder {

        public ObservableField<String> name=new ObservableField<>();
        public ObservableField<Integer> namecolos=new ObservableField<>();
        public ObservableField<Integer> serialnumber=new ObservableField<>();
        public ItemShopViewModel(ItemShopBinding itemShopBinding) {
            super(itemShopBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityShop entityShop) {
            name.set(entityShop.getName());
            namecolos.set(entityShop.getBercolr());
            serialnumber.set(entityShop.getSerialnumber());
        }

        //TODO 返回事件
        public void ClassificationOneOnClick(View view) {
            mShopClickListener.ClassificationOneOnClick();
            namecolos.set(mFragment.getResources().getColor(R.color.text_red_color));


        }




    }

    public interface shopClickListener {
        void ClassificationOneOnClick();
    }

    public void setShopClickListener(shopClickListener shopClickListener){
        this.mShopClickListener=shopClickListener;
    }


}