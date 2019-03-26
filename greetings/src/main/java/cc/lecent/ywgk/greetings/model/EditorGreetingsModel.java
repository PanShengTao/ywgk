package cc.lecent.ywgk.greetings.model;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.View;

import com.sh.shvideolibrary.VideoInputDialog;


import java.util.ArrayList;
import java.util.List;

import cc.lecent.bbc.utils.ToastUtils;
import cc.lecent.ywgk.greetings.R;
import cc.lecent.ywgk.greetings.BR;
import cc.lecent.ywgk.greetings.activity.AudioRecorderActivity;
import cc.lecent.ywgk.greetings.fragment.EditorGreetingsFragment;
import cc.lecent.ywgk.greetings.util.StringUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class EditorGreetingsModel {
    private EditorGreetingsFragment fragment;
    private AddresseeItemModel.ItemClick itemClick;//收件人添加
    private SelectAddresseeModel.ItemRemove itemRemove;//收件人移除
    public EditorGreetingsModel(EditorGreetingsFragment fragment) {
        this.fragment=fragment;

        itemRemove = new SelectAddresseeModel.ItemRemove() {
            @Override
            public void removeItem(String id) {
                for (int i = 0; i < itemModelsSjr.size(); i++) {
                    if (itemModelsSjr.get(i).nametext.equals(id)) {
                        itemModelsSjr.remove(i);
                    }
                }

            }
        };

        itemClick = new AddresseeItemModel.ItemClick() {
            @Override
            public void select(String nameText) {
//                linearLayout.setVisibility(View.VISIBLE);
//                String desc = beans.getPrisoner_name() + "(" + beans.getRelation() + ")";
//                for (int i = 0; i < itemModelsSjr.size(); i++) {
//                    if (itemModelsSjr.get(i).id.equals(beans.getId_card_no())) {
//                        ToastUtils.showToast(fragment.getActivity(), 1,"已经添加该收件人,请不要重复添加");
//                        return;
//                    }
//                }
                itemModelsSjr.add(new SelectAddresseeModel(fragment, "desc", "1",itemRemove,nameText));
            }
        };

        List<String> list=new ArrayList<>();
        list.add("刘东强");
        list.add("张二愣");
        list.add("胡一发");
        setData(list);
    }



    public ObservableField<String> videoPath = new ObservableField<>();//视频路径
    public ObservableField<Long> videoTime = new ObservableField<>();//视频时间"S"
    public ObservableField<Long> videoSize = new ObservableField<>();//视频大小"KB"

    public ObservableField<String> audioPath = new ObservableField<>();//音频路径
    public ObservableField<Long> audioTime = new ObservableField<>();//音频时间"S"
    public ObservableField<Long> audioSize = new ObservableField<>();//音频大小"KB"

    public ObservableField<String> theme = new ObservableField<>();//主题
    public ObservableField<String> desc = new ObservableField<>();//内容

    public ObservableField<String> senderName = new ObservableField<>("王大锤");//内容



    //收件人
    //给RecyclerView添加List
    public final ObservableList<SelectAddresseeModel> itemModelsSjr = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<SelectAddresseeModel> itemViewSelectorSjr = ItemBinding.of(BR.viewModel, R.layout.item_model_select_addressee);

    //选择收件人
    //给RecyclerView添加List
    public final ObservableList<AddresseeItemModel> itemModels = new ObservableArrayList<>();
    //给RecyclerView添加List的Item
    public final ItemBinding<AddresseeItemModel> itemViewSelector = ItemBinding.of(BR.viewModel, R.layout.item_addressee_model);



    public void recordOnClick(){
        Intent intent = new Intent();
        intent.setClass(fragment.getActivity(), AudioRecorderActivity.class);
        fragment.startActivity(intent);
    }

    public void cameraOnClick(){
        VideoInputDialog.show(fragment.getActivity().getSupportFragmentManager(),fragment,VideoInputDialog.Q720,fragment.getActivity());

    }

    private void setData(List<String> beans) {

        for (int i = 0; i < beans.size(); i++) {
            itemModels.add(new AddresseeItemModel(fragment, itemClick,beans.get(i)));
        }

    }

//
//    private void sendRequestSjy(AddFamilyGreetEntity addFamilyGreetEntit) {
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(addFamilyGreetEntit));
//        mHttpRequest.doPost((RxAppCompatActivity) fragment.getActivity(), new HttpResultListener<HttpResultBeans>() {
//            @Override
//            public void onSuccess(HttpResultBeans beans) {
//                LogUtils.e("-------------------------->creditPhotoEntity:" + beans.toString());
//                ToastUtils.newToast(fragment.getActivity(), "发送成功，请耐心等待审核");
//                fragment.getActivity().onBackPressed();
//            }
//
//            @Override
//            public void onFail(Context context, HttpResultBeans httpResultBeans, HttpResultBeans beans) {
//                ProgressDialogUtils.dialogDismiss();
//
//                ToastUtils.newToast(fragment.getActivity(), httpResultBeans.getMsg());
//            }
//        }, HttpApi.API_FAMILYGREETING_INSERTFAMILYGREETING, body);
//    }

    private boolean isSend() {
        if (itemModelsSjr.size() == 0) {
//            ToastUtils.showToast(fragment.getActivity(), 1,"请选择至少一个收件人");
            return false;
        }

        if (theme.get()== null || theme.get().isEmpty()) {
//            ToastUtils.showToast(fragment.getActivity(), 1,"主题不能为空");
            return false;
        }

        if (StringUtils.isEmptyString(desc.get()) && StringUtils.isEmptyString(audioPath.get()) && StringUtils.isEmptyString(videoPath.get())) {
//            ToastUtils.showToast(fragment.getActivity(),1, "亲情问候内容不能为空");
            return false;
        }
        return true;
    }



}
