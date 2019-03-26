package cc.lecent.ywgk.remittance.viewmode;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.remittance.CommonOperations;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.fragment.PayNextFragment;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19 上午10:26
 * 更改时间：19-2-19
 * 版本号：1
 */
public class RemittanceViewModel extends BaseViewModel {
    private Fragment fragment;
    private int payMoney = 0;


    public ObservableField<Integer> payWay = new ObservableField<>();
    public ObservableField<Boolean> checkBox = new ObservableField<>();
    public ObservableField<Integer> checkMoney = new ObservableField<>();
    public ObservableField<String> showOtherMoney = new ObservableField<>();

    public RemittanceViewModel() {
        payWay.set(0);
        checkMoney.set(0);
        checkBox.set(true);
        showOtherMoney.set("其它");
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * 下一步
     */
    public void onNext() {
        if (payMoney <= 0) {
//            ToastUtils.showToast(fragment.getContext(), 1, "请选择支付金额");
            return;
        }
        if (payWay.get() == 0) {
//            ToastUtils.showToast(fragment.getContext(), 1, "请选择支付方式");
            return;
        }

        Bundle bundle=new Bundle();
        bundle.putInt("payMoney",payMoney);
        bundle.putInt("payWay",payWay.get());
        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), PayNextFragment.class.getCanonicalName(), R.id.remittance, bundle);
    }

    /**
     * 选择汇款金额
     */
    public RadioButton.OnCheckedChangeListener checkItem = new RadioButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked == true) {
                showOtherMoney.set("其它");
                int i = buttonView.getId();
                if (i == R.id.rb1) {
                    checkMoney.set(1);
                    payMoney = 100;

                } else if (i == R.id.rb2) {
                    checkMoney.set(2);
                    payMoney = 200;

                } else if (i == R.id.rb3) {
                    checkMoney.set(3);
                    payMoney = 300;

                } else if (i == R.id.rb4) {
                    checkMoney.set(4);
                    payMoney = 500;

                } else if (i == R.id.rb5) {
                    checkMoney.set(5);
                    payMoney = 1000;

                } else if (i == R.id.rb6) {
                }
            }

        }
    };

    /**
     * 支付宝支付
     */
    public void aliPay() {
        payWay.set(1);
    }

    /**
     * 微信支付
     */
    public void weixinPay() {
        payWay.set(2);
    }

    /**
     * 银联支付
     */
    public void ylianPay() {
        payWay.set(3);
    }

    /**
     * 协议说明
     */
    public void agreementDescription() {

    }

    /**
     * 选择其他金额
     */
    public void otherMoneny() {
        checkMoney.set(6);
        OptionPicker picker = new OptionPicker(fragment.getActivity(),
                new String[]{"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "2000", "3000", "4000", "5000"
                });
        picker.setLabel("元");
        picker.setTopBackgroundColor(0xFFEEEEEE);
//        picker.setTopLineColor(0xFFEE0000);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setTextColor(0xFF0077EA, 0xFF999999);
        picker.setLineColor(0xFF0077EA);
        picker.setTextSize(30);
        picker.setCancelTextSize(20);
        picker.setSubmitTextSize(20);
        picker.setItemWidth(100);
        picker.setSelectedItem("1000");
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                showOtherMoney.set(item + "元");
                payMoney = Integer.parseInt(item);
            }
        });

        picker.show();
    }


}
