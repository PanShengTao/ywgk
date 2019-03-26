package cc.lecent.ywgk.me.common.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.common.entity.EntityMe;
import cc.lecent.ywgk.me.common.entity.EntityMembers;
import cc.lecent.ywgk.me.common.utlis.slrecyclerview.RecyclerTouchListener;
import cc.lecent.ywgk.me.databinding.ItemMeBinding;
import cc.lecent.ywgk.me.databinding.ItemMemberBinding;


public class AdapterMembers extends BaseMultiItemQuickAdapter<EntityMembers, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Activity mActivity;
    public ItemMemberBinding itemMemberBinding;
    public AdapterMembers(List<EntityMembers> data, Activity activity) {
        super(data);
        this.mActivity = activity;
    }


    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityMe.TYPE_ONE:
                itemMemberBinding = ItemMemberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemMembers itemMembers=new ItemMembers(itemMemberBinding);
                itemMemberBinding.setViewModel(itemMembers);
                return itemMembers;

        }

        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityMembers item) {

    }

    //TODO 适配器：添加数据
    public void addItems(List<EntityMembers> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }


    //TODO 使用帮助
    public class ItemMembers extends BaseViewHolder {
        public ItemMemberBinding binding;
        public ItemMembers(ItemMemberBinding itemMemberBinding) {
            super(itemMemberBinding.getRoot());
            this.binding=itemMemberBinding;


        }

        //TODO 适配器：添加数据
        public void adddata(EntityMembers entityDetails) {

        }


    }
}
