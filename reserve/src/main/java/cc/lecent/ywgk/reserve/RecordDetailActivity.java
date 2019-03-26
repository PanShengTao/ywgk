package cc.lecent.ywgk.reserve;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.lecent.bbc.base.BaseActivity;
import cc.lecent.ywgk.reserve.databinding.ActivityRecordDetailBinding;
import cc.lecent.ywgk.reserve.viewmodel.RecordDetailModel;

/**
 * 会见记录详情
 */
public class RecordDetailActivity extends BaseActivity {

    private RecordDetailModel viewmodel;
    private ActivityRecordDetailBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_record_detail);
        viewmodel=new RecordDetailModel(this.getApplicationContext());
        binding.setItem(viewmodel);
        initView();
        initData();
    }

    @Override
    public void initView() {
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_record_detail);
    }

    @Override
    public void initData() {

    }
}
