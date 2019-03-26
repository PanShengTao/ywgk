package cc.lecent.ywgk.greetings;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.greetings.fragment.FamilyGreetingsFragment;

@Route(path = "/greetings/GreetingsActivity")
public class GreetingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);
        StatusBarUtil.setStatusBarColor(this,R.color.title_bg_color);
        FragmentTransaction trans = getSupportFragmentManager()
                .beginTransaction();
        trans.replace(R.id.classifyFragment,FamilyGreetingsFragment.newInstance());
        trans.commit();
    }
}
