package com.arch.demo.main.otherfragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.arch.demo.R;
import com.arch.demo.core.fragment.MainTabFragment;
import com.arch.demo.core.fragment.MvvmFragment;
import com.arch.demo.databinding.FragmentOthersBinding;

/**
 * Created by Vishal Patolia on 18-Feb-18.
 */

public class ServiceFragment extends MainTabFragment<FragmentOthersBinding, ServiceViewModel> {

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_others;
    }

    @Override
    public ServiceViewModel getViewModel() {
        return new ServiceViewModel();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding.homeTxtTitle.setText(getString(R.string.menu_services));
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected String getFragmentTag() {
        return "ServiceFragment:TabFragment";
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
