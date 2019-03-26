package cc.lecent.ywgk.me.common.utlis;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cc.lecent.ywgk.me.common.adapter.AdapterHelp;
import cc.lecent.ywgk.me.common.adapter.AdapterMe;
import cc.lecent.ywgk.me.common.adapter.AdapterMembers;
import cc.lecent.ywgk.me.common.entity.EntityHelp;
import cc.lecent.ywgk.me.common.entity.EntityMe;
import cc.lecent.ywgk.me.common.entity.EntityMembers;


public final class UtilsBinding {
    private UtilsBinding() {
    }

    //TODO 购物车分类适配器
    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<EntityMe> blogs) {
        AdapterMe adapter = (AdapterMe) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }

    //TODO 购物车分类适配器
    @BindingAdapter({"adapter"})
    public static void addBlogmember(RecyclerView recyclerView, List<EntityMembers> blogs) {
        AdapterMembers adapter = (AdapterMembers) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }


    //TODO 购物车分类适配器
    @BindingAdapter({"adapter"})
    public static void addBloghelp(RecyclerView recyclerView, List<EntityHelp> blogs) {
        AdapterHelp adapter = (AdapterHelp) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }


   /* //TODO
    @BindingAdapter(value = {"android:onRefreshCommand", "android:onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshAndLoadMoreCommands(SmartRefreshLayout layout, SwipeRefreshLayout.OnRefreshListener onRefreshCommand, OnLoadMoreListener onLoadMoreCommand) {

        if (onRefreshCommand != null) {
            layout.setOnRefreshListener(onRefreshCommand);
        }
        if (onLoadMoreCommand != null) {
            layout.setOnLoadMoreListener(onLoadMoreCommand);
        }

    }*/


}

