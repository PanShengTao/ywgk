package cc.lecent.ywgk.me.common.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.me.common.entity.EntityHelp;
import cc.lecent.ywgk.me.common.entity.EntityMe;
import cc.lecent.ywgk.me.databinding.ItemhelpViewmodelBinding;


public class AdapterHelp extends BaseMultiItemQuickAdapter<EntityHelp,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Activity mActivity;
    public ItemhelpViewmodelBinding mItemhelpViewmodelBinding;


    public AdapterHelp(List<EntityHelp> data,Activity activity) {
        super(data);
        this.mActivity=activity;
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case EntityHelp.TYPE_ONE:
                mItemhelpViewmodelBinding = ItemhelpViewmodelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemHelpViewModel itemHelpViewModel=new ItemHelpViewModel(mItemhelpViewmodelBinding);
                mItemhelpViewmodelBinding.setViewModel(itemHelpViewModel);
                return itemHelpViewModel;

        }
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityHelp item) {

    }
    //TODO 适配器：添加数据
    public void addItems(List<EntityHelp> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }


    //TODO 信息通知
    public class ItemHelpViewModel extends BaseViewHolder {
        public ItemHelpViewModel(ItemhelpViewmodelBinding viewmodelBinding) {
            super(viewmodelBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }


        public void HelpOnClick(View view) {

        }
    }
}
