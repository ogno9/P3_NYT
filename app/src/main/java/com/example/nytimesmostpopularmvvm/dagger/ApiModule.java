package com.example.nytimesmostpopularmvvm.dagger;


import com.example.nytimesmostpopularmvvm.dagger.scopes.PerActivity;
import com.example.nytimesmostpopularmvvm.data.services.ArticlesService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @PerActivity
    public ArticlesService getService(Retrofit retrofit) {
        return retrofit.create(ArticlesService.class);
    }


}
