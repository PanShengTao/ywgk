package cc.lecent.ywgk.home;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.launcher.ARouter;

import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.data.util.StatusBarUtil;
import cc.lecent.ywgk.home.nav.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.ywgk.home.fragment.HomeFragment;
import cc.lecent.ywgk.home.util.PopupWindowUtils;
import cc.lecent.ywgk.me.ui.MeFragment;
import cc.lecent.ywgk.remittance.fragment.IdexRemittanceFragment;
import cc.lecent.ywgk.reserve.fragment.MeetFragment;
import me.jessyan.autosize.internal.CustomAdapt;

public class HomeActivity extends AppCompatActivity  implements CustomAdapt {

    private String[] tabText = {"首页", "会见预约", "亲情汇款", "我的"};
    //未选中icon
    private int[] normalIcon = {R.drawable.home_normal, R.drawable.meet_normal, R.drawable.remittance_normal, R.drawable.me_normal};
    //选中时icon
    private int[] selectIcon = {R.drawable.home_select, R.drawable.meet_select, R.drawable.remittance_select, R.drawable.me_select};

    private List<Fragment> fragments = new ArrayList<>();

    private  EasyNavigationBar navigationBar;
    private RelativeLayout generalTitle,meTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StatusBarUtil.setStatusBarColor(this, cc.lecent.ywgk.ca.R.color.title_bg_color);
        initView();
    }

    private void initView() {
        navigationBar = findViewById(R.id.navigationBar);
        generalTitle = findViewById(R.id.general_title);
        meTitle = findViewById(R.id.me_title);

        findViewById(R.id.toSelectPrison).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,SelectPrisonActivity.class));
            }
        });

        findViewById(R.id.to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/ca/CaActivity")
                        .navigation();
            }
        });

        View view = LayoutInflater.from(this).inflate(R.layout.custom_add_view, null);
      //  Fragment meFragment = (Fragment) ARouter.getInstance().build("/me/MeFragment")
             //   .navigation();

        fragments.add(new HomeFragment());
        fragments.add(new MeetFragment());
        fragments.add(new IdexRemittanceFragment());
//        fragments.add((Fragment) ARouter.getInstance().build("/me/MeFragment").navigation());
        fragments.add(new MeFragment());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .iconSize(20)     //Tab图标大小
                .tabTextSize(10)   //Tab文字大小
                .tabTextTop(2)     //Tab文字距Tab图标的距离
                .navigationHeight(40)  //导航栏高度
                .mode(EasyNavigationBar.MODE_ADD_VIEW)
                .addCustomView(view)
                .addLayoutRule(EasyNavigationBar.RULE_BOTTOM)
                .addAlignBottom(true)  //加号下文字是否同Tab文字底部对齐  RULE_BOTTOM时有效；
                .normalTextColor(Color.parseColor("#BEC3CA"))   //Tab未选中时字体颜色
                .selectTextColor(Color.parseColor("#0077EA"))   //Tab选中时字体颜色
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {   //Tab点击事件  return true 页面不会切换
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        if (position!=4){
                            generalTitle.setVisibility(View.VISIBLE);
                            meTitle.setVisibility(View.GONE);
                        }else{
                            generalTitle.setVisibility(View.GONE);
                            meTitle.setVisibility(View.VISIBLE);
                        }

                        return false;
                    }
                })
                .fragmentManager(getSupportFragmentManager())
                .build();

        navigationBar.getCustomAddView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             View menuView = View.inflate(HomeActivity.this, R.layout.popu_window_home_message, null);
             final PopupWindow popupWindow = PopupWindowUtils.getPopupWindowAtLocation(menuView,getWindow().getDecorView(), Gravity.BOTTOM, 0,0);
                menuView.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                menuView.findViewById(R.id.to_greetings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance()
                                .build("/greetings/GreetingsActivity")
                                .navigation();
                        popupWindow.dismiss();
                    }
                });

                menuView.findViewById(R.id.to_meet).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance()
                                .build("/meet/MeetActivity")
                                .navigation();
                        popupWindow.dismiss();
                    }
                });

                menuView.findViewById(R.id.to_shop).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ARouter.getInstance()
                                .build("/shop/ShopActivity")
                                .navigation();
                        popupWindow.dismiss();
                    }
                });

            }
        });

    }


    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
         return ScreenUtils.getScreenWidth(HomeActivity.this);
    }
}
