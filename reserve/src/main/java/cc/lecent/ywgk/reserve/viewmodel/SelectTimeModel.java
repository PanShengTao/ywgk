package cc.lecent.ywgk.reserve.viewmodel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.ldf.calendar.component.CalendarAttr;
import com.ldf.calendar.component.CalendarViewAdapter;
import com.ldf.calendar.model.CalendarDate;

import java.util.HashMap;

import cc.lecent.ywgk.reserve.BR;
import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.interfiace.OnTimeSelect;
import cc.lecent.ywgk.reserve.util.MonthPagerBindingAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-3-1 上午11:34
 * 更改时间：19-3-1
 * 版本号：1
 */
public class SelectTimeModel {
    private Dialog dialog;
    public CalendarViewAdapter calendarAdapter;
    /**
     * 显示年份
     */
    public ObservableField<String> showYeas=new ObservableField<>();
    /**
     * 显示月份
     */
    public ObservableField<String> showMonths=new ObservableField<>();

    public  HashMap<String, String>  markData = new HashMap<>();
    public SelectTimeModel(Dialog dialog, CalendarViewAdapter calendarAdapter, OnTimeSelect onTimeSelect) {
        this.dialog = dialog;
        this.calendarAdapter = calendarAdapter;
        initMarkData();
        itemModels.add(new SelectTimeItemModel(dialog,onTimeSelect));
    }

    public MonthPagerBindingAdapter.onSelectTime onSelect=new MonthPagerBindingAdapter.onSelectTime() {
        @Override
        public void onSelect(CalendarDate today) {
                showMonths.set(today.month+"");
                showYeas.set(today.year+"年");
        }
    };

    /**
     * 设置可预约时间
     * 1 不可预约
     * 0 可以预约
     */
    private void initMarkData() {
        markData.clear();
        for (int i=1;i<31;i++){
            markData.put("2019-3-"+i, ""+i%2);
        }
        calendarAdapter.setMarkData(markData);
    }

    //给RecyclerView添加List
    public final ObservableList<SelectTimeItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<SelectTimeItemModel> itemViewSelector = ItemBinding.of(new OnItemBind<SelectTimeItemModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, SelectTimeItemModel item) {
            if (position==0){
                itemBinding.set(BR.model,R.layout.item_time_select);
            }
        }
    });

    /**
     * @param date
     */
    public void onSelectDate(CalendarDate date) {
        if(markData.containsKey(date.toString())){
            if(markData.get(date.toString()).equals("0")){
                itemModels.get(0).setIsReserve(date,true);
                return;
            }else {
                itemModels.get(0).setIsReserve(date,false);
                return;
            }
        }else {
            itemModels.get(0).setIsReserve(date,false);
        }
    }

    /**
     * 选择今天按钮
     */
    public void today(){
        CalendarDate date=new CalendarDate();
        if(markData.containsKey(date.toString())){
            if(markData.get(date.toString()).equals("0")){
                itemModels.get(0).setIsReserve(date,true);
                return;
            }else {
                itemModels.get(0).setIsReserve(date,false);
                return;
            }
        }else {
            itemModels.get(0).setIsReserve(date,false);
        }
    }
}
