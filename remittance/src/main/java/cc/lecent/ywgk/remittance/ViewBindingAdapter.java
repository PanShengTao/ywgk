package cc.lecent.ywgk.remittance;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import cc.lecent.ywgk.remittance.util.ScreenUtils;


public class ViewBindingAdapter {
    public ViewBindingAdapter() {

    }

    /**
     * 设置上拉加载  下拉刷新
     *
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
     * 设置轮播图数据
     *
     * @param layout
     * @param listUrl
     */
    @BindingAdapter(value = {"android:listUrl"}, requireAll = false)
    public static void onbanner(Banner layout, List<String> listUrl) {

        if (listUrl != null) {
            layout.setDelayTime(2000);//设置轮播图的间隔时间
            layout.setImages(listUrl);
            layout.setImageLoader(new GlideImageLoader());//设置轮播图的加载方式
            layout.start();
        }

    }


    /**
     * 设置recyclerview 方向
     *
     * @param view
     * @param str
     * @param imp
     */
    @BindingAdapter(value = {"android:viewDirection", "android:imp"}, requireAll = false)
    public static void setRecyclerviewFX(RecyclerView view, boolean str, RecyclerDataImp imp) {
        if (str == true) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            view.setLayoutManager(layoutManager);
            imp.RecyclerDataImpClick();
        } else if (str == false) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            view.setLayoutManager(layoutManager);
        }

    }

    public static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }

    /**
     * 设置recyclerview中item 宽度
     *
     * @param relativeLayout
     * @param w
     */
    @BindingAdapter(value = {"android:viewWidth"}, requireAll = false)
    public static void setLinearLayoutWith(RelativeLayout relativeLayout, int w) {
        int width = ScreenUtils.getScreenWidth(relativeLayout.getContext());
        float itemW = width / w;
        ViewGroup.LayoutParams lp = relativeLayout.getLayoutParams();
        lp.width = (int) itemW;

    }

    /**
     *
     * @param relativeLayout
     * @param listener
     */
    @BindingAdapter(value = {"android:onCheckedChangeListener"}, requireAll = false)
    public static void setOnCheckedChangeListener(RadioGroup relativeLayout, RadioGroup.OnCheckedChangeListener listener) {
        relativeLayout.setOnCheckedChangeListener(listener);
    }
    /**
     *
     * @param radioButton
     * @param listener
     */
    @BindingAdapter(value = {"android:checkItem"}, requireAll = false)
    public static void setOnCheckedChangeListener(RadioButton radioButton, RadioButton.OnCheckedChangeListener listener) {
        radioButton.setOnCheckedChangeListener(listener);
    }
}
