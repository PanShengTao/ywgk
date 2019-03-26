package cc.lecent.ywgk.reserve.viewmodel;

import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.ywgk.reserve.ReserveActivity;


public class MeetItemModel {
    private int position;
    private Fragment fragment;

    public MeetItemModel(Fragment fragment, int position) {
        this.position = position;
        this.fragment = fragment;

        initView();
    }


    public ObservableField<List<String>> listurlStr = new ObservableField<>();
    public ObservableBoolean recyclerviewDirection = new ObservableBoolean(true);


    List<String> list1;

    private void initView() {
        recyclerviewDirection.set(true);
        if (position == 0) {
            List<String> list = new ArrayList<>();
            list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            listurlStr.set(list);
        }
    }

    /**
     * 立即预约按钮
     */
    public void reserveNow() {
//        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), ReserveFragment.class.getCanonicalName(), R.id.reserve_fragment, null);
        Intent intent = new Intent(fragment.getActivity(), ReserveActivity.class);
        intent.putExtra("flag",1);
        fragment.startActivity(intent);
    }

    /**
     * 立即预约按钮
     */
    public void reserveRecord() {
//        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), ReserveFragment.class.getCanonicalName(), R.id.reserve_fragment, null);
        Intent intent = new Intent(fragment.getActivity(), ReserveActivity.class);
        intent.putExtra("flag",1);
        fragment.startActivity(intent);
    }

}
