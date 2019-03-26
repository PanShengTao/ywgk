package cc.lecent.ywgk.reserve.viewmodel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.widget.Toast;


import com.ldf.calendar.model.CalendarDate;

import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.interfiace.OnTimeSelect;

/**
 * 文件描述：时间选择界面 RecylcView的第一个item
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-3-1 下午2:49
 * 更改时间：19-3-1
 * 版本号：1
 */
public class SelectTimeItemModel {
    public ObservableField<String> isReserve=new ObservableField<>();
    public ObservableField<Integer> color1=new ObservableField<>();
    public ObservableField<Integer> color2=new ObservableField<>();
    public ObservableField<Integer> bg1=new ObservableField<>();
    public ObservableField<Integer> bg2=new ObservableField<>();

    public ObservableField<Boolean> selector1=new ObservableField<Boolean>();
    public ObservableField<Boolean> selector2=new ObservableField<Boolean>();
    /**
     * 选择上午和下午
     */
    private String period=null;
    private Dialog dialog;
    private CalendarDate date;
    private OnTimeSelect onTimeSelect;

    public SelectTimeItemModel(Dialog dialog, OnTimeSelect onTimeSelect) {
        this.dialog = dialog;
        this.onTimeSelect=onTimeSelect;
        isReserve.set("不可预约");
        setIsReserve(new CalendarDate(),false);
    }


    public void setIsReserve(CalendarDate date,boolean isReserve) {
        this.date=date;
        if (isReserve){
            this.isReserve.set("可预约");
        }else {
            this.isReserve.set("不可预约");
        }
        color1.set(Color.parseColor("#ff999999"));
        color2.set(Color.parseColor("#ff999999"));
        bg1.set(R.drawable.yellow_rectangle_k);
        bg2.set(R.drawable.yellow_rectangle_k);
        period=null;
        selector1.set(false);
        selector2.set(false);
    }

    /**
     *选择预约时间上午
     */
    public void selectOne(){

        if((isReserve.get()).equals("不可预约")){
            Toast.makeText(dialog.getContext(),"今天不可预约",Toast.LENGTH_SHORT).show();
            return;
        }
        selector2.set(false);
        selector1.set(true);
        period="上午8:30-11:30";
        color1.set(Color.parseColor("#FFCB33"));
        color2.set(Color.parseColor("#ff999999"));
        bg1.set(R.drawable.yellow_rectangle_k);
        bg2.set(R.drawable.gray_btn_rectangle);
    }

    /**
     *选择预约时间下午
     */
    public void selectTow(){

        if((isReserve.get()).equals("不可预约")){
            Toast.makeText(dialog.getContext(),"今天不可预约",Toast.LENGTH_SHORT).show();
            return;
        }
        selector2.set(true);
        selector1.set(false);
        period="下午13:30-15:30";
        color1.set(Color.parseColor("#ff999999"));
        color2.set(Color.parseColor("#FFCB33"));
        bg1.set(R.drawable.gray_btn_rectangle);
        bg2.set(R.drawable.yellow_rectangle_k);
    }


    /**
     * 确定按钮
     */
    public void define(){

        if((isReserve.get()).equals("不可预约")){
            Toast.makeText(dialog.getContext(),"今天不可预约",Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (period==null){
                Toast.makeText(dialog.getContext(),"请选择时间段",Toast.LENGTH_SHORT).show();
                return;
            }
            onTimeSelect.onSelect(date.toString(),period);
            dialog.dismiss();
            Toast.makeText(dialog.getContext(),date.toString()+period,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 取消按钮
     */
    public void cancel(){
        dialog.dismiss();
    }
}
