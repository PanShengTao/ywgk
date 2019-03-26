package cc.lecent.ywgk.pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cc.lecent.ywgk.data.util.StatusBarUtil;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        StatusBarUtil.setStatusBarColor(this,R.color.title_bg_color);
    }
}
