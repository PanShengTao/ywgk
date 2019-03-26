package cc.lecent.ywgk.greetings.model;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import java.util.List;


/**
 * 罪犯列表
 */
public class AddresseeItemModel {
    private Fragment fragment;
    private ItemClick click;
    public AddresseeItemModel(Fragment fragment,ItemClick click,String nameStr){
        this.fragment = fragment;
//        this.beans = beans;
//        name.set(beans.getRelation());
//        relation.set(beans.getPrisoner_name());
        name.set(nameStr);
        this.click = click;
    }

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> relation = new ObservableField<>();



    public void itemClick(){
        click.select(name.get());
    }

    public interface ItemClick{
        void select(String beans);
    }

}
