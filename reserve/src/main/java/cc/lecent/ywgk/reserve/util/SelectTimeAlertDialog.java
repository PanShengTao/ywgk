package cc.lecent.ywgk.reserve.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldf.calendar.Utils;
import com.ldf.calendar.component.CalendarAttr;
import com.ldf.calendar.component.CalendarViewAdapter;
import com.ldf.calendar.interf.OnSelectDateListener;
import com.ldf.calendar.model.CalendarDate;
import com.ldf.calendar.view.Calendar;
import com.ldf.calendar.view.MonthPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cc.lecent.ywgk.reserve.R;
import cc.lecent.ywgk.reserve.databinding.SelectTimeBinding;
import cc.lecent.ywgk.reserve.interfiace.OnTimeSelect;
import cc.lecent.ywgk.reserve.view.CustomDayView;
import cc.lecent.ywgk.reserve.viewmodel.SelectTimeModel;

public class SelectTimeAlertDialog extends AlertDialog implements View.OnClickListener{

    private RecyclerView mList;
    private CoordinatorLayout mContent;
    private CalendarViewAdapter calendarAdapter;
    private Context context;
    private OnSelectDateListener onSelectDateListener;
    private CalendarDate currentDate=new CalendarDate();
    private int mCurrentPage = MonthPager.CURRENT_DAY_INDEX;
    private boolean initiated=false;
    private SelectTimeBinding binding;
    private SelectTimeModel selectTimeModel;
    private OnTimeSelect onTimeSelect;
    private ArrayList<Calendar> currentCalendars = new ArrayList<>();
    public SelectTimeAlertDialog(@NonNull Context context, OnTimeSelect onTimeSelect) {
        super(context);
        this.context=context;
        this.onTimeSelect=onTimeSelect;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.select_time,  null, false);
        setContentView(binding.getRoot());
        initView();
        initCurrentDate();
        initCalendarView();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !initiated) {
            refreshMonthPager();
            initiated = true;
        }
    }

    /**
     * 初始化currentDate
     *
     * @return void
     */
    private void initCurrentDate() {
        currentDate = new CalendarDate();
        binding.showYearView.setText(currentDate.getYear() + "年");
        binding.showMonthView.setText(currentDate.getMonth() + "");
    }
    private void refreshMonthPager() {
        CalendarDate today = new CalendarDate();
        calendarAdapter.notifyDataChanged(today);
        binding.showYearView.setText(currentDate.getYear() + "年");
        binding.showMonthView.setText(currentDate.getMonth() + "");
    }
    private void refreshClickDate(CalendarDate date) {
        currentDate = date;
        binding.showYearView.setText(currentDate.getYear() + "年");
        binding.showMonthView.setText(currentDate.getMonth() + "");
    }
    private void initView() {
        binding.monthPager .setViewHeight(Utils.dpi2px(context, 270));
        mList = (RecyclerView) findViewById(R.id.list);
        mList.setHasFixedSize(true);
        //这里用线性显示 类似于listview
        mList.setLayoutManager(new LinearLayoutManager(context));
        mContent = (CoordinatorLayout) findViewById(R.id.content);
        binding.backTodayButton.setOnClickListener(this);
        binding.nextMonth.setOnClickListener(this);
        binding.lastMonth.setOnClickListener(this);
    }
    /**
     * 初始化CustomDayView，并作为CalendarViewAdapter的参数传入
     */
    private void initCalendarView() {
        initListener();
        CustomDayView customDayView = new CustomDayView(context, R.layout.custom_day);
        calendarAdapter = new CalendarViewAdapter(
                context,
                onSelectDateListener,
                CalendarAttr.CalendarType.MONTH,
                CalendarAttr.WeekArrayType.Monday,
                customDayView);
        calendarAdapter.setOnCalendarTypeChangedListener(new CalendarViewAdapter.OnCalendarTypeChanged() {
            @Override
            public void onCalendarTypeChanged(CalendarAttr.CalendarType type) {
                if (calendarAdapter.getCalendarType()== CalendarAttr.CalendarType.WEEK) {
                    binding.lastMonth.setText("上一月");
                    binding.nextMonth.setText("下一月");
                }else {
                    binding.lastMonth.setText("上一周");
                    binding.nextMonth.setText("下一周");
                }
                mList.scrollToPosition(0);
            }
        });

        binding.monthPager .setAdapter(calendarAdapter);
        binding.monthPager .setCurrentItem(MonthPager.CURRENT_DAY_INDEX);
        selectTimeModel = new SelectTimeModel(this,calendarAdapter,onTimeSelect);
        binding.setModel(selectTimeModel);
    }


    private void initListener() {
        onSelectDateListener = new OnSelectDateListener() {
            @Override
            public void onSelectDate(CalendarDate date) {
                refreshClickDate(date);
                selectTimeModel.onSelectDate(date);
                if(selectTimeModel.markData.containsKey(date.toString())){
                        if (selectTimeModel.markData.get(date.toString()).equals("0")){
                            if (calendarAdapter.getCalendarType() == CalendarAttr.CalendarType.MONTH) {
                                Utils.scrollTo(binding.content, binding.list, binding.monthPager.getCellHeight(), 200);
                                calendarAdapter.switchToWeek( binding.monthPager.getRowIndex());
                                return;
                            }
                        }else {
                            if (calendarAdapter.getCalendarType() == CalendarAttr.CalendarType.WEEK) {
                                Utils.scrollTo(binding.content, binding.list, binding.monthPager.getViewHeight(), 200);
                                calendarAdapter.switchToMonth();
                                return;
                            }
                        }
                }else {
                    if (calendarAdapter.getCalendarType() == CalendarAttr.CalendarType.WEEK) {
                                            Utils.scrollTo(binding.content, binding.list, binding.monthPager.getViewHeight(), 200);
                    calendarAdapter.switchToMonth();
                        return;
                    }
                }
            }

            @Override
            public void onSelectOtherMonth(int offset) {
                //偏移量 -1表示刷新成上一个月数据 ， 1表示刷新成下一个月数据
                binding.monthPager .selectOtherMonth(offset);
            }
        };
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.back_today_button) {
            refreshMonthPager();
            selectTimeModel.today();

        } else if (i == R.id.last_month) {
            binding.monthPager.setCurrentItem(binding.monthPager.getCurrentPosition() - 1);

        } else if (i == R.id.next_month) {
            binding.monthPager.setCurrentItem(binding.monthPager.getCurrentPosition() + 1);
//                if (calendarAdapter.getCalendarType() == CalendarAttr.CalendarType.WEEK) {
//                    Utils.scrollTo(binding.content, binding.list, binding.monthPager.getViewHeight(), 200);
//                    calendarAdapter.switchToMonth();
//                } else {
//                    Utils.scrollTo(binding.content, binding.list, binding.monthPager.getCellHeight(), 200);
//                    calendarAdapter.switchToWeek( binding.monthPager.getRowIndex());
//                }

        }
    }


}
