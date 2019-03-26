package cc.lecent.ywgk.shop.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.data.util.ScreenUtils;
import cc.lecent.ywgk.shop.R;
import cc.lecent.ywgk.shop.common.adapter.AdapterWhole;
import cc.lecent.ywgk.shop.common.utlis.UtilsDecoratione;
import cc.lecent.ywgk.shop.databinding.WholeFragmentBinding;
import cc.lecent.ywgk.shop.model.WholeViewModel;
import me.jessyan.autosize.internal.CustomAdapt;

//全部
public class WholeFragment extends BaseFragment implements CustomAdapt {
    private static final String ARG_POSITION = "position";
    private int position;
    public WholeViewModel mVholeViewModel;
    public WholeFragmentBinding mWholeFragmentBinding;
    public AdapterWhole mAdapterWhole;
    public static WholeFragment newInstance(int position) {
        WholeFragment f = new WholeFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAdapterWhole=new AdapterWhole(null,this);
        mVholeViewModel=new WholeViewModel(position,this);
        mWholeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.whole_fragment, container, false);
        mWholeFragmentBinding.setViewModel(mVholeViewModel);
        return mWholeFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp();
        setUpdata();
    }
    //TODO 初始话数据
    private void setUp() {
        mWholeFragmentBinding.reDatalistId.setLayoutManager(new LinearLayoutManager(getContext()));
        mWholeFragmentBinding.reDatalistId.addItemDecoration(new UtilsDecoratione(getContext(), UtilsDecoratione.VERTICAL_LIST, UtilsDecoratione.DividerType.TYPE_E4E4E4));
        mWholeFragmentBinding.reDatalistId.setAdapter(mAdapterWhole);
    }
    private void  setUpdata(){
        mVholeViewModel.getListLiveData().observe(this, blogs -> mVholeViewModel.addlistdata(blogs));

    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return ScreenUtils.getScreenWidth(getActivity());

    }
}
