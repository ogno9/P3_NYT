package com.example.nytimesmostpopularmvvm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.nytimesmostpopularmvvm.dagger.component.DaggerAppComponent;
import com.example.nytimesmostpopularmvvm.utils.Constants;
import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MyApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    public DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    public DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .url(Constants.URL)
                .build()
                .inject(this);

        Fresco.initialize(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
