package cc.lecent.ywgk.shop.common.utlis;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import cc.lecent.component.shop.adapter.AdapterDilog;
import cc.lecent.ywgk.shop.common.adapter.AdapterDetails;
import cc.lecent.ywgk.shop.common.adapter.AdapterShop;
import cc.lecent.ywgk.shop.common.adapter.AdapterShopData;
import cc.lecent.ywgk.shop.common.adapter.AdapterWhole;
import cc.lecent.ywgk.shop.common.entity.EntityDetails;
import cc.lecent.ywgk.shop.common.entity.EntityOrder;
import cc.lecent.ywgk.shop.common.entity.EntityShop;
import cc.lecent.ywgk.shop.common.entity.EntityShopData;

public final class UtilsBinding {
    private UtilsBinding() {
    }
    //TODO 购物车分类适配器
    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<EntityShop> blogs) {
        AdapterShop adapter = (AdapterShop) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }
    //TODO 购物车分类适配器
    @BindingAdapter({"adapter"})
    public static void addBlogItems1(RecyclerView recyclerView, List<EntityShopData> blogs) {
        AdapterShopData adapter = (AdapterShopData) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }

    }
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    //TODO
    @BindingAdapter({"adapter"})
    public static void addBlogOrder(RecyclerView recyclerView, List<EntityOrder> blogs) {
        AdapterWhole adapter = (AdapterWhole) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }

    //TODO
    @BindingAdapter(value = {"android:onRefreshCommand", "android:onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshAndLoadMoreCommands(SmartRefreshLayout layout, OnRefreshListener onRefreshCommand, OnLoadMoreListener onLoadMoreCommand) {

        if (onRefreshCommand != null) {
            layout.setOnRefreshListener(onRefreshCommand);
        }
        if (onLoadMoreCommand != null) {
            layout.setOnLoadMoreListener(onLoadMoreCommand);
        }

    }

    //TODO
    @BindingAdapter({"adapter"})
    public static void addBlogdetalis(RecyclerView recyclerView, List<EntityDetails> blogs) {
        AdapterDetails adapter = (AdapterDetails) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }
}

