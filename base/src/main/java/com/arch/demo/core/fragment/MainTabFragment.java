package com.arch.demo.core.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.arch.demo.core.viewmodel.IMvvmBaseViewModel;

public abstract class MainTabFragment<V extends ViewDataBinding, VM extends IMvvmBaseViewModel> extends MvvmFragment<V, VM> implements IVisibleAware {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                Log.e(getFragmentTag() + "lifecycle", event.name());
            }
        });

    }

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
//                getFragmentManager().beginTransaction()
//                        .setMaxLifecycle(this, Lifecycle.State.RESUMED)
//                        .commitNow();
                Log.e(getFragmentTag(), this + ": " + "onVisible");
                onVisible();
            } else {
//                getFragmentManager().beginTransaction()
//                        .setMaxLifecycle(this, Lifecycle.State.CREATED)
//                        .commitNow();
                Log.e(getFragmentTag(), this + ": " + "onInvisible");
                onInvisible();
            }
        }
    }
}
