package cc.lecent.ywgk.shop.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cc.lecent.ywgk.shop.ui.WholeFragment;

public class AdapterOrderList extends FragmentPagerAdapter {
    private final String[] TITLES = {"全部", "已完成", "待支付", "已取消"};

    public AdapterOrderList(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return WholeFragment.newInstance(position);
    }
}
