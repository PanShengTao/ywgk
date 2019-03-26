package cc.lecent.ywgk.me.common.adapter;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cc.lecent.ywgk.me.R;
import cc.lecent.ywgk.me.common.entity.EntityMe;
import cc.lecent.ywgk.me.databinding.ItemHelpBinding;
import cc.lecent.ywgk.me.databinding.ItemMeBinding;
import cc.lecent.ywgk.me.databinding.ItemIdcardBinding;
import cc.lecent.ywgk.me.databinding.ItemNoticeBinding;
import cc.lecent.ywgk.me.databinding.ItemNumberBinding;
import cc.lecent.ywgk.me.ui.HelpActivity;
import cc.lecent.ywgk.me.ui.MembersActivity;
import cc.lecent.ywgk.me.ui.ReplaceActivity;

public class AdapterMe extends BaseMultiItemQuickAdapter<EntityMe, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Fragment mFragment;
    public ItemMeBinding mItemMeBinding;
    public ItemIdcardBinding mItemIdcardBinding;
    public ItemNoticeBinding mItemNoticeBinding;
    public ItemHelpBinding itemHelpBinding;
    public ItemNumberBinding mItemNumberBinding;

    public AdapterMe(List<EntityMe> data, Fragment fragment) {
        super(data);
        this.mFragment = fragment;
    }


    //TODO 适配器：加载布局
    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EntityMe.TYPE_ONE:
                mItemMeBinding = ItemMeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemMe itemMe = new ItemMe(mItemMeBinding);
                mItemMeBinding.setViewModel(itemMe);
                return itemMe;
            case EntityMe.TYPE_TWO:
                mItemIdcardBinding = ItemIdcardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemIDcard itemIDcard = new ItemIDcard(mItemIdcardBinding);
                mItemIdcardBinding.setViewModel(itemIDcard);
                return itemIDcard;
            case EntityMe.TYPE_THREE:
                mItemNoticeBinding = ItemNoticeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemNotice itemNotice = new ItemNotice(mItemNoticeBinding);
                mItemNoticeBinding.setViewModel(itemNotice);
                return itemNotice;
            case EntityMe.TYPE_FOUR:
                itemHelpBinding = ItemHelpBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemHelp itemHelp = new ItemHelp(itemHelpBinding);
                itemHelpBinding.setViewModel(itemHelp);
                return itemHelp;
            case EntityMe.TYPE_FIVE:
                mItemNumberBinding = ItemNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemNumber itemNumber = new ItemNumber(mItemNumberBinding);
                mItemNumberBinding.setViewModel(itemNumber);
                return itemNumber;

            case EntityMe.TYPE_NINE:
                return new itemMargin(mLayoutInflater.inflate(R.layout.item_msg, parent, false));

        }

        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, EntityMe item) {
        switch (helper.getItemViewType()) {
            case EntityMe.TYPE_ONE:
                ((ItemMe) helper).adddata(item);
                break;
            case EntityMe.TYPE_TWO:
                ((ItemIDcard) helper).adddata(item);
                break;
            case EntityMe.TYPE_THREE:
                ((ItemNotice) helper).adddata(item);
                break;
            case EntityMe.TYPE_FOUR:
                ((ItemHelp) helper).adddata(item);
                break;
            case EntityMe.TYPE_FIVE:
                ((ItemNumber) helper).adddata(item);
                break;

        }
    }

    //TODO 适配器：添加数据
    public void addItems(List<EntityMe> list) {
        setNewData(list);
        notifyDataSetChanged();
    }

    //TODO 适配器：清除数据
    public void clearItems() {
        getData().clear();
    }

    //TODO 我的
    public class ItemMe extends BaseViewHolder {
        public ItemMe(ItemMeBinding itemMeBinding) {
            super(itemMeBinding.getRoot());

        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }

        public void MyClick(View view) {
            Intent intent = new Intent(mFragment.getActivity(), MembersActivity.class);
            mFragment.getActivity().startActivity(intent);
        }
    }

    //TODO 身份证
    public class ItemIDcard extends BaseViewHolder {
        public ItemIDcard(ItemIdcardBinding itemIdcardBinding) {
            super(itemIdcardBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }
    }


    //TODO 信息通知
    public class ItemNotice extends BaseViewHolder {
        public ItemNotice(ItemNoticeBinding itemNoticeBinding) {
            super(itemNoticeBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }


        public void HelpOnClick(View view) {
            Intent intent = new Intent(mFragment.getActivity(), HelpActivity.class);
            mFragment.getActivity().startActivity(intent);
        }
    }

    //TODO 使用帮助
    public class ItemHelp extends BaseViewHolder {
        public ItemHelp(ItemHelpBinding itemHelpBinding) {
            super(itemHelpBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }


    }

    //TODO 更换手指号
    public class ItemNumber extends BaseViewHolder {
        public ItemNumber(ItemNumberBinding itemNumberBinding) {
            super(itemNumberBinding.getRoot());
        }

        //TODO 适配器：添加数据
        public void adddata(EntityMe entityDetails) {

        }

        public void ReplaceOnClick(View view) {
            Intent intent = new Intent(mFragment.getActivity(), ReplaceActivity.class);
            mFragment.getActivity().startActivity(intent);
        }
    }

    public class itemMargin extends BaseViewHolder {
        public itemMargin(View view) {
            super(view);
        }
    }
}