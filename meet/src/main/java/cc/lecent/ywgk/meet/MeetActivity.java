package cc.lecent.ywgk.meet;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.meet.fragment.RemoteMeetFragment;
@Route(path = "/meet/MeetActivity")
public class MeetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        StatusBarUtil.setStatusBarColor(this,R.color.title_bg_color);
        FragmentTransaction trans = getSupportFragmentManager()
                .beginTransaction();
        trans.replace(R.id.classifyFragment,RemoteMeetFragment.newInstance());
        trans.commit();
    }
}
