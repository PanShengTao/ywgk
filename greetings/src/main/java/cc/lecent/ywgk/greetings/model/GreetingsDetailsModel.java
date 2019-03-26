package cc.lecent.ywgk.greetings.model;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;
import android.view.View;

public class GreetingsDetailsModel {
    private Fragment fragment;
    public GreetingsDetailsModel(Fragment fragment) {
        this.fragment=fragment;
    }

    public ObservableField<String>  recipientName=new ObservableField<>("潘子");
    public ObservableField<String>  senderName=new ObservableField<>("老卢");
    public ObservableField<String>  theme=new ObservableField<>("好好改造，不要打游戏");
    public ObservableField<String>  desc=new ObservableField<>("哈哈哈哈哈哈哈啊哈哈哈哈哈啊哈哈啊哈哈哈哈哈啊哈哈哈哈");
    public ObservableField<Integer>  rlWidth=new ObservableField<>(2);
    public ObservableField<Integer>  showFour=new ObservableField<>(View.GONE);
    public ObservableField<Integer>  showThree=new ObservableField<>(View.VISIBLE);
    public ObservableField<Integer>  showTwo=new ObservableField<>(View.VISIBLE);
    public ObservableField<Integer>  showOne=new ObservableField<>(View.VISIBLE);





}
