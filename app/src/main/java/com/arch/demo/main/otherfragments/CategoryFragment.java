package com.arch.demo.main.otherfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.arch.demo.R;
import com.arch.demo.core.fragment.MainTabFragment;
import com.arch.demo.core.fragment.MvvmFragment;
import com.arch.demo.databinding.FragmentOthersBinding;


/**
 * Created by Vishal Patolia on 18-Feb-18.
 */

public class CategoryFragment extends MainTabFragment<FragmentOthersBinding, CategoryViewModel> {
    FragmentOthersBinding mBinding;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_others;
    }

    @Override
    public CategoryViewModel getViewModel() {
        return new CategoryViewModel();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        viewDataBinding.homeTxtTitle.setText(getString(R.string.menu_categories));
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected String getFragmentTag() {
        return "CategoryFragment:TabFragment";
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
