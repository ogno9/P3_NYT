package com.example.nytimesmostpopularmvvm.dagger;


import com.example.nytimesmostpopularmvvm.dagger.scopes.PerActivity;
import com.example.nytimesmostpopularmvvm.presentation.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {


    @PerActivity
    @ContributesAndroidInjector(modules = {ApiModule.class, ActivityModule.class, FragmentBuilder.class})
    MainActivity getMainActivity();
}



