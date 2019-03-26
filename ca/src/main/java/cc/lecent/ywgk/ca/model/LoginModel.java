package cc.lecent.ywgk.ca.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.bbc.utils.StringUtils;
import cc.lecent.ywgk.ca.R;
import cc.lecent.ywgk.ca.util.CountDownTimerUtils;
import cc.lecent.ywgk.ca.util.StringUtil;
import cc.lecent.ywgk.data.YwCallback;
import cc.lecent.ywgk.data.YwRepository;
import cc.lecent.ywgk.data.entity.Login;
import cc.lecent.ywgk.data.util.PopupWindowUtils;
import cc.lecent.ywgk.data.util.ToastUtils;

/**
 * @Description: 账户登录model
 * @Author: 卢凤淦
 * @CreateDate: 19-2-25 下午2:53
 */
public class LoginModel extends BaseViewModel {
    private Fragment fragment;
    private CountDownTimerUtils mCountDownTimerUtils;

    public LoginModel(Fragment fragment) {
        this.fragment = fragment;
    }

    public ObservableField<String> phoneNumber=new ObservableField<>();
    public ObservableField<String> verificationCode=new ObservableField<>();
    //new一个ViewStyle给界面调用
    public final ViewStyle viewStyle = new ViewStyle();

    //定义ViewStyle需要的回调内容
    public class ViewStyle {
        public final ObservableBoolean isSendSms = new ObservableBoolean(false);//更新UI的Spinner
    }


    public void onClickDelete(){
        phoneNumber.set("");
    }

    //登陆键点击事件
    public void onClickToLogin(){
             if (isLogin()){
                 goLogin();
             }
    }

    //验证码点击事件
    public void onClickGetSms(){
        viewStyle.isSendSms.set(!viewStyle.isSendSms.get());
    }

    //获取验证码
    public void getSmsCode(Button button){
        if (phoneNumber.get().isEmpty()){
            ToastUtils.showToast(fragment.getActivity(),"请输入手机号");
            return;
        }else if (phoneNumber.get().length()!=11){
            ToastUtils.showToast(fragment.getActivity(),"您输入的手机号码格式有误");
            return;
        }

        mCountDownTimerUtils = new CountDownTimerUtils(button, 60000, 1000,fragment.getActivity());

        YwRepository.getInstance().getSendSmsCode(phoneNumber.get(), new YwCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                if (!aBoolean){
                    ToastUtils.showToast(fragment.getActivity(),"获取失败");
                }
            }

            @Override
            public void onError(String err) {
                ToastUtils.showToast(fragment.getActivity(),err);
            }

            @Override
            public void onStart() {
                mCountDownTimerUtils.start();
            }

            @Override
            public void onFinish() {
                mCountDownTimerUtils.onFinish();
                mCountDownTimerUtils.cancel();
            }
        });
    }

    //登录
    private void goLogin(){
        YwRepository.getInstance().login(phoneNumber.get(), verificationCode.get(), new YwCallback<Login>() {
            @Override
            public void onSuccess(Login login) {

            }
        });




    }



    private void initPupowindow(){
        View menuView = View.inflate(fragment.getActivity(), R.layout.pupo_window_approve, null);
        final PopupWindow popupWindow = PopupWindowUtils.getPopupWindowAtLocation(menuView,fragment.getActivity().getWindow().getDecorView(), Gravity.CENTER, 0,0);


    }

    private boolean isLogin(){
        if (StringUtils.isEmpty(phoneNumber.get())) {
            ToastUtils.showToast(fragment.getActivity(), "手机号码不能为空");
            return false;
        }

        if (!StringUtil.isMobilePhoneNum(phoneNumber.get())) {
            ToastUtils.showToast(fragment.getActivity(), "请输入正确的手机号");
            return false;
        }

        if (StringUtils.isEmpty(verificationCode.get())) {
            ToastUtils.showToast(fragment.getActivity(), "验证码不能为空");
            return false;
        }

        return true;
    }


}
