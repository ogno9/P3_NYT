package com.example.nytimesmostpopularmvvm.dagger;

import com.example.nytimesmostpopularmvvm.presentation.master.ArticlesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    ArticlesFragment getArticlesFragment();
}
