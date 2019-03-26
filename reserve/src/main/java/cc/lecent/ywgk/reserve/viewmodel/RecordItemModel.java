package cc.lecent.ywgk.reserve.viewmodel;

import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.reserve.RecordDetailActivity;


public class RecordItemModel extends BaseViewModel {
    private Fragment fragment;
    public ObservableField<String> status=new ObservableField<>();
    public ObservableField<Integer> textColor=new ObservableField<>();
    public RecordItemModel(Fragment fragment){
        this.fragment=fragment;
    }
    public void itemClick(){
        Intent intent;
        intent = new Intent(fragment.getContext(),RecordDetailActivity.class);
        fragment.startActivity(intent);
    }
}
