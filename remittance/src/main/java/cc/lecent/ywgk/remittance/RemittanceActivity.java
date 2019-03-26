package cc.lecent.ywgk.remittance;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.remittance.fragment.IndexRemittanceFragment;
import cc.lecent.ywgk.remittance.fragment.PayListFragment;
import cc.lecent.ywgk.remittance.fragment.RemittanceFragment;

/**
 * 汇款主activity
 */
public class RemittanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance);
        initView();
        initData();
    }

    @Override
    public void initView() {
        String tostart=this.getIntent().getStringExtra("toPaylist");
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        if (tostart.equals("false")){
            RemittanceFragment fragment=new RemittanceFragment();
            transaction.add(R.id.remittance,fragment);
        }else {
            PayListFragment fragment=new PayListFragment();
            transaction.add(R.id.remittance,fragment);
        }
        transaction.commit();
    }

    @Override
    public void initData() {

    }
}
