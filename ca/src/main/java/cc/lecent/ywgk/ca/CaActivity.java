package cc.lecent.ywgk.ca;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.lang.reflect.Field;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.ca.fragment.LoginFragment;
import cc.lecent.ywgk.data.util.StatusBarUtil;

@Route(path = "/ca/CaActivity")
public class CaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);
        initView();
    }

    @Override
    public void initView() {

        StatusBarUtil.setStatusBarColor(this,R.color.white);
        StatusBarUtil.StatusBarLightMode(this);
        initState();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        Fragment fragment = (Fragment) ARouter.getInstance().build("/ca/LoginFragment")
//                .navigation();
        LoginFragment fragment = new LoginFragment();
        transaction.add(R.id.login_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void initData() {

    }


    /**
     * 动态的设置状态栏  实现沉浸式状态栏
     *
     */
    private void initState() {
        LinearLayout ll_bar=findViewById(R.id.ll_bar);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ll_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight();
            //动态的设置隐藏布局的高度
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ll_bar.getLayoutParams();
            params.height = statusHeight;
            ll_bar.setLayoutParams(params);

        }
    }



    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
