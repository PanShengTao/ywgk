package cc.lecent.ywgk.reserve.viewmodel;


import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.reserve.RecordActivity;
import cc.lecent.ywgk.reserve.interfiace.OnTimeSelect;
import cc.lecent.ywgk.reserve.util.SelectTimeAlertDialog;

public class ReserverViewMode extends BaseViewModel {
    public ReserverViewMode(Fragment fragment) {
            this.fragment=fragment;
    }

    public ObservableField<String> settime=new ObservableField<>();
    private Fragment fragment;
    public void btnMommoit(){
        Intent intent=new Intent(fragment.getContext(),RecordActivity.class);
        fragment.startActivity(intent);
    }

    /**
     * 选择时间
     */
    public void selectTime(){
        SelectTimeAlertDialog commonDialog=new SelectTimeAlertDialog(fragment.getContext(), new OnTimeSelect() {
            @Override
            public void onSelect(String date, String time) {
                settime.set(date+time);
            }
        });
            commonDialog.show();
    }

}
