package cc.lecent.ywgk.remittance.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import cc.lecent.bbc.base.BaseFragment;
import cc.lecent.ywgk.remittance.R;
import cc.lecent.ywgk.remittance.databinding.RemittanceFragmentBinding;
import cc.lecent.ywgk.remittance.viewmode.RemittanceViewModel;

public class RemittanceFragment extends BaseFragment {

    private RemittanceFragmentBinding binding;
    private RemittanceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.remittance_fragment, container, false);
//        viewModel = new RemittanceViewModel(this,binding);
        viewModel = ViewModelProviders.of(this).get(RemittanceViewModel.class);
        viewModel.setFragment(this);
        binding.setViewmodel(viewModel);

        binding.setLifecycleOwner(this);
        initView();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initView() {
        binding.rgOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO
                if (checkedId == R.id.rb1) {
                    if (binding.rb1.isChecked()) ;
                    binding.rgTow.clearCheck();

                } else if (checkedId == R.id.rb2) {
                    if (binding.rb2.isChecked())
                        binding.rgTow.clearCheck();

                } else if (checkedId == R.id.rb3) {
                    if (binding.rb3.isChecked())
                        binding.rgTow.clearCheck();

                }

            }
        });
        binding.rgTow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO
                if (checkedId == R.id.rb4) {
                    if (binding.rb4.isChecked())
                        binding.rgOne.clearCheck();

                } else if (checkedId == R.id.rb5) {
                    if (binding.rb5.isChecked())
                        binding.rgOne.clearCheck();

                } else if (checkedId == R.id.rb6) {
                    if (binding.rb6.isChecked())
                        binding.rgOne.clearCheck();

                } else {
                }
            }
        });
    }
}
