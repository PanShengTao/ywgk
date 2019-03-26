package cc.lecent.ywgk.home.model;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.home.BR;
import cc.lecent.ywgk.home.R;
import cc.lecent.ywgk.home.RecyclerDataImp;
import cc.lecent.ywgk.home.SocialPublicActivity;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class HomeItemModel {
    private int position;
    private Fragment fragment;

    public HomeItemModel(Fragment fragment, int position) {
        this.position = position;
        this.fragment = fragment;

        initView();
    }


    public ObservableField<List<String>> listurlStr = new ObservableField<>();
    public ObservableBoolean recyclerviewDirection = new ObservableBoolean(true);

    //给RecyclerView添加List
    public final ObservableList<HomeItemRecyclerviewModel> itemModelsItem = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<HomeItemRecyclerviewModel> itemViewSelectorItem = ItemBinding.of(BR.viewModel, R.layout.item_recyclerview);

    List<String> list1;
    private void initView() {
        recyclerviewDirection.set(true);
        if (position == 0) {
            List<String> list = new ArrayList<>();
            list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            list.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            listurlStr.set(list);
        }else if(position==1) {
//
            list1=new ArrayList<>();
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
        }else if(position==2) {
//
            list1=new ArrayList<>();
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
        }else if(position==3) {
//
            list1=new ArrayList<>();
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201306/2013062320262198.jpg");
            list1.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
        }


    }


    //    private void installData(List<String> data){
//        itemModelsItem.clear();
//
//        if (data.size() == 0) {
//            ToastUtils.showToast(fragment.getActivity(),1,"暂无数据");
//        } else {
//            for (int i = 0; i < data.size(); i++) {
//                itemModelsItem.add(new HomeItemRecyclerviewModel(fragment));
//            }
//        }
//    }

    public  void toMoreClick(){

        fragment.startActivity(new Intent(fragment.getActivity(),SocialPublicActivity.class));

    }

    public RecyclerDataImp installData = new RecyclerDataImp() {
        @Override
        public void RecyclerDataImpClick() {

            itemModelsItem.clear();

            if (list1.size() == 0) {
//                ToastUtils.showToast(fragment.getActivity(), 1, "暂无数据");
            } else {
                for (int i = 0; i < list1.size(); i++) {
                    itemModelsItem.add(new HomeItemRecyclerviewModel(fragment));
                }
            }
        }
    };
}
