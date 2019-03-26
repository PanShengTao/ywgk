package cc.lecent.ywgk.greetings.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import cc.lecent.ywgk.greetings.CommonOperations;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.fragment.EditorGreetingsFragment;
import cc.lecent.ywgk.greetings.fragment.GreetingsDetailsFragment;

public class FamilyGreetingsItemModel {
    private Fragment fragment;
    private int replaceContent=R.id.classifyFragment;

    public FamilyGreetingsItemModel(Fragment fragment) {
        this.fragment=fragment;

        int randomnum = (int) (Math.random() * 5);
        if (randomnum==0){
            viewBg.set(fragment.getResources().getDrawable(R.drawable.blue_circle));
        }else if (randomnum==1){
            viewBg.set(fragment.getResources().getDrawable(R.drawable.yellow_circle));
        }else if (randomnum==2){
            viewBg.set(fragment.getResources().getDrawable(R.drawable.cyan_circle));
        }else if (randomnum==3){
            viewBg.set(fragment.getResources().getDrawable(R.drawable.red_circle));
        }else{
            viewBg.set(fragment.getResources().getDrawable(R.drawable.blue_circle));
        }


        auditStatusBg.set(fragment.getResources().getColor(R.color.title_bar_color));
    }

    public  ObservableField<Drawable>  viewBg= new ObservableField<>();
    public  ObservableField<String> nameShort= new ObservableField<> ("得标");
    public  ObservableField<String> nameStr= new ObservableField<> ("范得标");
    public  ObservableField<String> auditStatus= new ObservableField<> ("审核中");
    public  ObservableField<Integer>  auditStatusBg= new ObservableField<>();
    public  ObservableField<String> auditTime= new ObservableField<> ("2019-10-13");
    public  ObservableField<String> auditText= new ObservableField<> ("在里面好好改造啊卢本伟");


    public void itemGreetingsOnClick(){
        Bundle bundle=new Bundle();
        CommonOperations.loadFragmentByReflection(fragment.getFragmentManager(), GreetingsDetailsFragment.class.getCanonicalName(),replaceContent,bundle);

    }



}
