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
import com.arch.demo.core.fragment.IBasePagingView;
import com.arch.demo.core.fragment.MainTabFragment;
import com.arch.demo.core.fragment.MvvmFragment;
import com.arch.demo.core.model.SuperBaseModel;
import com.arch.demo.core.viewmodel.MvvmBaseViewModel;
import com.arch.demo.databinding.FragmentAccountBinding;
import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;


/**
 * Created by Vishal Patolia on 18-Feb-18.
 */
public class AccountFragment extends MainTabFragment<FragmentAccountBinding, AccountViewModel> {

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_account;
    }

    @Override
    public AccountViewModel getViewModel() {
        return new AccountViewModel();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
       viewDataBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CCResult result = CC.obtainBuilder("UserCenter")  .setActionName("login")
                        .build().call();

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected String getFragmentTag() {
        return "AccountFragment:TabFragment";
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
