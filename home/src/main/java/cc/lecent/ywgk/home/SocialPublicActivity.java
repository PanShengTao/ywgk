package cc.lecent.ywgk.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.home.fragment.SocialPublicFragment;

/**
 * 社会公示
 */
public class SocialPublicActivity extends BaseActivity {
    private TabLayout tablayout;
    private String[] titles = {"减刑假释", "法律法规", "监外执行","劳动时间"};
    private List<Fragment> list;
    private ViewPagesAdapter adapter;
    private ViewPager viewpager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_social_public);
         tablayout= findViewById(R.id.tablayout);
         viewpager= findViewById(R.id.viewpager);
         initView();
         initData();
    }

    @Override
    public void initView() {
//        getSupportActionBar().hide();
        tablayout.setTabTextColors(0xff666666,0xff0077EA);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setSelectedTabIndicatorColor(0xff0077EA);
        tablayout.setSelectedTabIndicatorHeight(10);


        list=new ArrayList<>();
        list.add(new SocialPublicFragment());
        list.add(new SocialPublicFragment());
        list.add(new SocialPublicFragment());
        list.add(new SocialPublicFragment());
        adapter=new ViewPagesAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
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
