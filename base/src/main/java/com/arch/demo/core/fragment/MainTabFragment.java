package com.arch.demo.core.fragment;

import android.util.Log;

import androidx.databinding.ViewDataBinding;

import com.arch.demo.core.viewmodel.IMvvmBaseViewModel;

public abstract class MainTabFragment<V extends ViewDataBinding, VM extends IMvvmBaseViewModel> extends MvvmFragment<V, VM> implements IVisibleAware {
    @Override
    public void onResume() {
        super.onResume();

        if (getUserVisibleHint()) {
            onVisible();
            Log.e(getFragmentTag(), this + ": " + "onVisible");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onVisible();
            Log.e(getFragmentTag(), this + ": " + "onInvisible");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        setUserVisibleHint(!hidden);

        if (isResumed()) {
            if (!hidden) {
                Log.e(getFragmentTag(), this + ": " + "onVisible");
                onVisible();
            } else {
                Log.e(getFragmentTag(), this + ": " + "onInvisible");
                onInvisible();
            }
        }
    }
}
