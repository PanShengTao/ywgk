package cc.lecent.ywgk.reserve;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.reserve.databinding.ActivityRecordBinding;
import cc.lecent.ywgk.reserve.fragment.RecordFragment;

/**
 * 会见记录
 */
public class RecordActivity extends BaseActivity {

    private ActivityRecordBinding binding;
    private String[] titles = {"全部", "待审核", "审核通过","审核未通过"};
    private List<Fragment> list;
    private ViewPagesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_record);
        initView();
        initData();
    }

    @Override
    public void initView() {
//        getSupportActionBar().hide();
        binding.tablayout.setTabTextColors(0xff666666,0xff0077EA);
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        binding.tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        binding.tablayout.setSelectedTabIndicatorColor(0xff0077EA);
        binding.tablayout.setSelectedTabIndicatorHeight(10);


        list=new ArrayList<>();
        list.add(new RecordFragment(0));
        list.add(new RecordFragment(1));
        list.add(new RecordFragment(2));
        list.add(new RecordFragment(3));
        adapter=new ViewPagesAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.viewpager);

    }

    @Override
    public void initData() {

    }


    class ViewPagesAdapter extends FragmentPagerAdapter {

        public ViewPagesAdapter(FragmentManager fm) {
            super(fm);
        }
        //获得每个页面的下标
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        //获得List的大小
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
