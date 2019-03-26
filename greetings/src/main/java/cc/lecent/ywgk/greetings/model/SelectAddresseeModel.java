package cc.lecent.ywgk.greetings.model;

import android.databinding.ObservableField;
import android.support.v4.app.Fragment;


public class SelectAddresseeModel {

    private Fragment fragment;
    public String id;
    private ItemRemove itemRemove;
    public String nametext;
    public SelectAddresseeModel(Fragment fragment,String descStr,String id,ItemRemove itemRemove,String nametext){
        this.fragment = fragment;
        this.id = id;
        this.itemRemove = itemRemove;
        this.nametext = nametext;
        desc.set(nametext);
    }

    public ObservableField<String> desc = new ObservableField<>();



    public void itemClick(){
        itemRemove.removeItem(nametext);
    }

    interface ItemRemove{
        void removeItem(String id);
    }
}
