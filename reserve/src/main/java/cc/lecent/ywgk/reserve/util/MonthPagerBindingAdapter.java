package cc.lecent.ywgk.reserve.util;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.ldf.calendar.component.CalendarViewAdapter;
import com.ldf.calendar.model.CalendarDate;
import com.ldf.calendar.view.Calendar;
import com.ldf.calendar.view.MonthPager;

import java.util.ArrayList;

import cc.lecent.ywgk.reserve.R;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-3-1 上午11:16
 * 更改时间：19-3-1
 * 版本号：1
 */
public class MonthPagerBindingAdapter {
    private static ArrayList<Calendar> currentCalendars = new ArrayList<>();
    public MonthPagerBindingAdapter() {
    }
    @BindingAdapter(value = {"android:calendarAdapter","android:addOnPageChangeListener"},requireAll = false)
    public static void addOnPageChangeListener(MonthPager monthPager, CalendarViewAdapter calendarAdapter,onSelectTime listener){
        monthPager.addOnPageChangeListener(new MonthPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                currentCalendars = calendarAdapter.getPagers();
                if (currentCalendars.get(position % currentCalendars.size()) != null) {
                    CalendarDate date = currentCalendars.get(position % currentCalendars.size()).getSeedDate();
                    listener.onSelect(date);

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        monthPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                position = (float) Math.sqrt(1 - Math.abs(position));
                page.setAlpha(position);
            }
        });
    }
    public interface onSelectTime{
        void onSelect(CalendarDate calendarDate);
    }
    @BindingAdapter(value = {"android:selector"})
    public static void onSelector(LinearLayout linearLayout,boolean select){
        if(select){
            linearLayout.setBackgroundResource(R.drawable.linear_select_icon);
        }else {
            linearLayout.setBackgroundResource(R.drawable.gray_btn_rectangle);
        }
    }
}
