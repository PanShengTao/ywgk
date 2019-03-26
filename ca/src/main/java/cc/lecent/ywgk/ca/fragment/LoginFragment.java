package cc.lecent.ywgk.ca.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.ca.R;
import cc.lecent.ywgk.ca.databinding.FragmentLoginBinding;
import cc.lecent.ywgk.ca.model.LoginModel;

/**
 * @Description: 账户登录fragment
 * @Author: 卢凤淦
 * @CreateDate: 19-2-25 下午2:53
 */
@Route(path = "/ca/LoginFragment")
public class LoginFragment extends BaseFragment {
    private FragmentLoginBinding binding;
    private LoginModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        model = new LoginModel(this);
        binding.setViewModel(model);
        initView();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cbTitle.setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private void initView(){
        model.viewStyle.isSendSms.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                model.getSmsCode(binding.sendSms);
            }
        });
    }
}
