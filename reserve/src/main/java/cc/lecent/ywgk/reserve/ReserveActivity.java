package cc.lecent.ywgk.reserve;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.reserve.fragment.ReserveFragment;

/**
 * 会见预约
 */
public class ReserveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        StatusBarUtil.setStatusBarColor(this,R.color.title_bg_color);
        initView();
    }

    @Override
    public void initView() {
//        getSupportActionBar().hide();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ReserveFragment fragment = new ReserveFragment();
        transaction.add(R.id.reserve_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void initData() {

    }
}
