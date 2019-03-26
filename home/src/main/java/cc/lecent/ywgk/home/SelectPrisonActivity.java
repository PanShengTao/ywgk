package cc.lecent.ywgk.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.home.view.CharacterParser;
import cc.lecent.ywgk.home.view.PinyinComparator;
import cc.lecent.ywgk.home.view.SideBar;

/**
 * Created by wang on 2019/3/6.
 * 监狱选择
 */

public class SelectPrisonActivity extends BaseActivity {
    private CharacterParser characterParser;
    private PinyinComparator pinyinComparator;
    private SideBar sideBar;
    private ListView sortListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_prison);
        initView();
    }

    @Override
    public void initView() {
        List<String> listBeans=new ArrayList<>();
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        sideBar = (SideBar) findViewById(R.id.sideBar);
//        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
//
//            @Override
//            public void onTouchingLetterChanged(String s) {
//                int position = adapter.getPositionForSection(s.charAt(0));
//                if (position != -1) {
//                    sortListView.setSelection(position);
//                }
//
//            }
//        });
//
//        sortListView = (ListView) findViewById(R.id.prison_rc);
//        if (null!=listBeans){
//            SourceDateList = filledData(listBeans);  //初始数据
//            Collections.sort(SourceDateList, pinyinComparator);
//            adapter = new SortGroupMemberAdapter(this, SourceDateList);
//            sortListView.setAdapter(adapter);
//        }

    }

    @Override
    public void initData() {

    }
}