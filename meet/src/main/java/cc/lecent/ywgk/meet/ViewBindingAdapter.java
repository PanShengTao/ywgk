package cc.lecent.ywgk.meet;


import android.databinding.BindingAdapter;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;




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









}
