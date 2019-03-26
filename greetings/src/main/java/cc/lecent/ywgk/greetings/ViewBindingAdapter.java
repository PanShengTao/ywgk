package cc.lecent.ywgk.greetings;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.List;

import cc.lecent.ywgk.greetings.util.ScreenUtils;


public class ViewBindingAdapter {
    public ViewBindingAdapter(){

    }

    /**
     * 设置上拉加载  下拉刷新
     * @param layout
     * @param onRefreshCommand
     * @param onLoadMoreCommand
     */
    @BindingAdapter(value = {"android:onRefreshCommand", "android:onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshAndLoadMoreCommands(SmartRefreshLayout layout, OnRefreshListener onRefreshCommand, OnLoadMoreListener onLoadMoreCommand) {

        if (onRefreshCommand != null) {
            layout.setOnRefreshListener(onRefreshCommand);
        }

        if (onLoadMoreCommand != null) {
            layout.setOnLoadMoreListener(onLoadMoreCommand);
        }

    }

    /**
     * 设置recyclerview中item 宽度
     * @param relativeLayout
     * @param w
     */
    @BindingAdapter(value = {"android:viewWidth"}, requireAll = false)
    public static void setLinearLayoutWith(RelativeLayout relativeLayout, int w) {
        int width= ScreenUtils.getScreenWidth(relativeLayout.getContext());
        float itemW=width/4;
        ViewGroup.LayoutParams lp=  relativeLayout.getLayoutParams();
        lp.width= (int) (itemW * w);

    }







}
