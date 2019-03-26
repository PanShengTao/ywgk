package cc.lecent.ywgk.reserve.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import cc.lecent.bbc.base.BaseViewModel;
import cc.lecent.ywgk.reserve.util.MapUtil;

public class RecordDetailModel extends BaseViewModel {
        private ObservableField<String> destination=new ObservableField<>();
        private Context context;
        public RecordDetailModel(Context context){
            destination.set("贵州王武监狱");
            this.context=context;
        }
    /**
     * 导航按钮
     */
    public void mapNavigation(){
        if(MapUtil.checkappMap(context)){
            MapUtil.openAllMap(context,destination.get());
        }else {
            MapUtil.openWebPage(context,"0","0",destination.get());
        }
    }

}
