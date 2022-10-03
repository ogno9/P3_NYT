package com.example.nytimesmostpopularmvvm.dagger;

import com.example.nytimesmostpopularmvvm.dagger.scopes.PerActivity;
import com.example.nytimesmostpopularmvvm.presentation.master.ArticlesFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    @Provides
    @PerActivity
    public ArticlesFragment provideArticleFragment() {
        return new ArticlesFragment();
    }


}
