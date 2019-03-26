package cc.lecent.ywgk.remittance.viewmode;

import android.annotation.SuppressLint;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import java.text.DecimalFormat;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.remittance.CommonOperations;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.fragment.PaySuccessFragment;
import cc.lecent.ywgk.remittance.util.TimeUtil;


/**
 * 文件描述：
 * 作者：pst
 * 邮箱：1274218999@qq.com
 * 创建时间：19-2-19 上午10:26
 * 更改时间：19-2-19
 * 版本号：1
 */
public class PayNextViewModel extends BaseViewModel {
    private Fragment fragment;
    private int time = 90;
    private Thread runTime;


    /**
     * 支付金额
     */
    public ObservableField<String> payMoney = new ObservableField<>();
    /**
     * 实际支付金额
     */
    public ObservableField<String> trueMoney = new ObservableField<>();
    /**
     * 实际支付金额
     */
    public ObservableField<String> procedureMoney = new ObservableField<>();
    /**
     * 选择的支付方式
     */
    public ObservableField<Integer> payWay = new ObservableField<>();
    /**
     * 显示剩余的支付时间
     */
    public ObservableField<String> showTime = new ObservableField<>();

    private DecimalFormat df = new DecimalFormat("#.##");

    @SuppressLint("HandlerLeak")
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showTime.set(TimeUtil.formatSeconds(msg.what));
            if (msg.what == 0) {
                if (fragment != null) {
                    fragment.getActivity().onBackPressed();
                }

            }
        }
    };


    public void setFragment(Fragment fragment, Bundle bundle) {
        this.fragment = fragment;
        int allMoney = bundle.getInt("payMoney");
        payMoney.set("￥" + allMoney + ".00");
        payWay.set(bundle.getInt("payWay"));
        showTime.set("01:30");

        procedureMoney.set(df.format(allMoney * 0.01) + "元");
        trueMoney.set(df.format(allMoney - (allMoney * 0.01)) + "元");
    }


    public PayNextViewModel() {
    }

    private void runTime() {

        runTime = new Thread(new Runnable() {
            @Override
            public void run() {
                while (time >= 0)
                    try {
                        Thread.sleep(1000);
                        time--;
                        timeHandler.sendEmptyMessage(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        if (!runTime.isAlive()) {
            runTime.start();
        }
    }

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
     * 下一步
     */
    public void onNext() {
        if (payWay.get() == 0) {
//            ToastUtils.showToast(fragment.getContext(), 1, "请选择支付方式");
            return;
        }
        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), PaySuccessFragment.class.getCanonicalName(), R.id.remittance, null);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        runTime();
    }

    @Override
    public void onDestroy() {
        time = -1;
        fragment = null;
        super.onDestroy();
    }
}


